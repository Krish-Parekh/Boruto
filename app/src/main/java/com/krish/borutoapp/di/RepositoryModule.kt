package com.krish.borutoapp.di

import android.content.Context
import com.krish.borutoapp.data.repository.DataStoreOperationImpl
import com.krish.borutoapp.data.repository.Repository
import com.krish.borutoapp.domain.repository.DataStoreOperations
import com.krish.borutoapp.domain.use_cases.UseCases
import com.krish.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.krish.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.krish.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.krish.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.krish.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository = repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository = repository)
        )
    }

}

