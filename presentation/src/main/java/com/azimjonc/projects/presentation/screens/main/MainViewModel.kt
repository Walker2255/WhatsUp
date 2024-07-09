package com.azimjonc.projects.presentation.screens.main

import com.azimjonc.projects.domain.usecase.settings.GetOnboardedUseCase
import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.navigation.Screens.OnboardingScreen
import com.azimjonc.projects.presentation.navigation.Screens.PhoneScreen
import com.azimjonc.projects.presentation.screens.main.MainViewModel.*
import com.github.terrakok.cicerone.Router

class MainViewModel(
    private val router: Router,
    private val getOnboardedUseCase: GetOnboardedUseCase
) : BaseViewModel<State, Input, Effect>() {

    class State

    class Input

    class Effect

    init {
        getOnboarded()
    }

    override fun getDefaultState() = State()

    override fun proccesInput(input: Input) {
    }

    private fun getOnboarded() {
        getOnboardedUseCase().subscribe { onboarded ->
            router.newRootScreen(
                if (onboarded) PhoneScreen() else OnboardingScreen()
            )
        }
    }
}