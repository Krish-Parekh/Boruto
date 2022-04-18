package com.krish.borutoapp.data.paging_source

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.krish.borutoapp.data.local.BorutoDatabase
import com.krish.borutoapp.data.remote.BorutoApi
import com.krish.borutoapp.domain.model.Hero
import com.krish.borutoapp.domain.model.HeroRemoteKeys
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator @Inject constructor(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
) : RemoteMediator<Int, Hero>() {


    private val heroDao = borutoDatabase.heroDao()
    private val heroRemoteKeysDao = borutoDatabase.heroRemoteKeysDao()

    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdated = heroRemoteKeysDao.getRemoteKeys(heroId = 1)?.lastUpdated ?: 0L
        val cacheTimeOut = 1440
        
        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60
        return if (diffInMinutes.toInt() <= cacheTimeOut) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }

    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            val response = borutoApi.getAllHeroes(page = page)
            Log.d("Krish", "$response")
            if (response.heroes.isNotEmpty()) {
                borutoDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        heroDao.deleteAllHeroes()
                        heroRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.heroes.map { hero ->
                        HeroRemoteKeys(
                            id = hero.id,
                            prevPage = prevPage,
                            nextPage = nextPage,
                            lastUpdated = response.lastUpdated
                        )
                    }
                    heroRemoteKeysDao.addAllRemoteKey(heroRemoteKey = keys)
                    heroDao.addHeroes(heroes = response.heroes)
                }
            }
            return MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Hero>
    ): HeroRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                heroRemoteKeysDao.getRemoteKeys(heroId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Hero>
    ): HeroRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { hero ->
            heroRemoteKeysDao.getRemoteKeys(heroId = hero.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Hero>
    ): HeroRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { hero ->
            heroRemoteKeysDao.getRemoteKeys(heroId = hero.id)
        }
    }

    private fun parseMillis(millis: Long): String {
        val date = Date(millis)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.ROOT)
        return format.format(date)
    }
}