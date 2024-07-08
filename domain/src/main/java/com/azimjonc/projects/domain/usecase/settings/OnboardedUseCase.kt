package com.azimjonc.projects.domain.usecase.settings

import com.azimjonc.projects.domain.repo.SettingsRepository

class OnboardedUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke() = settingsRepository.onboarded()
}