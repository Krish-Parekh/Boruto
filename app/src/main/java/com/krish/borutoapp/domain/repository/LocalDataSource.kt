package com.krish.borutoapp.domain.repository

import com.krish.borutoapp.domain.model.Hero

interface LocalDataSource {

    suspend fun getSelectedHero(heroId: Int): Hero
}