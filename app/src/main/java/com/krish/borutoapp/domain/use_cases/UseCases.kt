package com.krish.borutoapp.domain.use_cases

import com.krish.borutoapp.data.paging_source.SearchHeroesSource
import com.krish.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.krish.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.krish.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.krish.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.krish.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)
