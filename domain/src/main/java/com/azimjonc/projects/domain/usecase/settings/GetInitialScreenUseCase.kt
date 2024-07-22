package com.azimjonc.projects.domain.usecase.settings

import com.azimjonc.projects.domain.repo.AuthRepository
import com.azimjonc.projects.domain.repo.SettingsRepository
import com.azimjonc.projects.domain.usecase.settings.GetInitialScreenUseCase.Result.*
import io.reactivex.rxjava3.core.Single

class GetInitialScreenUseCase(
    private val settingsRepository: SettingsRepository,
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Single<Result> = settingsRepository.getOnboarded().map { onboarded ->
        return@map when {
            authRepository.isLoggedIn -> Home
            onboarded -> Phone
            else -> Onboarding
        }
    }

    sealed class Result {
        object Onboarding : Result()
        object Phone : Result()
        object Home : Result()
    }
}