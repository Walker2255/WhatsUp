package com.azimjonc.projects.domain.usecase.settings

import com.azimjonc.projects.domain.repo.SettingsRepository

class GetOnboardedUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke() = settingsRepository.getOnboarded()
}