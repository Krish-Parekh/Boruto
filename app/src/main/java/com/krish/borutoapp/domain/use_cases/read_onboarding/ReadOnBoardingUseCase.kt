package com.krish.borutoapp.domain.use_cases.read_onboarding

import com.krish.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    // just by initializing this class this invoke function
    // will start working
    operator fun invoke() : Flow<Boolean>{
        return repository.readOnBoardingState()
    }
}