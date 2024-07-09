package com.azimjonc.projects.presentation.screens.onboarding

import com.azimjonc.projects.domain.usecase.settings.OnboardedUseCase
import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.navigation.Screens.PhoneScreen
import com.azimjonc.projects.presentation.screens.onboarding.OnboardingViewModel.*
import com.github.terrakok.cicerone.Router

class OnboardingViewModel(
    private val onboardedUseCase: OnboardedUseCase,
    private val router: Router
) : BaseViewModel<State, Input, Effect>() {

    class State
    sealed class Input {
        object Onboarded : Input()
    }

    class Effect

    override fun getDefaultState() = State()

    override fun proccesInput(input: Input) {
        when (input) {
            Input.Onboarded -> onboarded()

        }
    }

    private fun onboarded() {
        onboardedUseCase().subscribe {
            router.replaceScreen(PhoneScreen())
        }
    }
}