package com.krish.borutoapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.krish.borutoapp.data.repository.Repository
import com.krish.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }

}