package com.krish.borutoapp.data.repository

import androidx.paging.PagingData
import com.krish.borutoapp.domain.model.Hero
import com.krish.borutoapp.domain.repository.DataStoreOperations
import com.krish.borutoapp.domain.repository.LocalDataSource
import com.krish.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local : LocalDataSource,
    private val dataStore: DataStoreOperations,
    private val remote : RemoteDataSource
) {

    fun getAllHeroes() : Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query : String): Flow<PagingData<Hero>>{
        return remote.searchHeroes(query = query)
    }

    suspend fun getSelectedHero(heroId : Int) : Hero{
        return local.getSelectedHero(heroId = heroId)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState() : Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}