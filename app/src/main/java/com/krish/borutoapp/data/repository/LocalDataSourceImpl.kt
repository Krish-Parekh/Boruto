package com.krish.borutoapp.data.repository

import com.krish.borutoapp.data.local.BorutoDatabase
import com.krish.borutoapp.domain.model.Hero
import com.krish.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    borutoDatabase: BorutoDatabase
) : LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }

}