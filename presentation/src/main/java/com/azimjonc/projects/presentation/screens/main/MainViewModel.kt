package com.azimjonc.projects.presentation.screens.main

import com.azimjonc.projects.domain.usecase.settings.GetInitialScreenUseCase
import com.azimjonc.projects.domain.usecase.settings.GetInitialScreenUseCase.Result
import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.navigation.Screens.HomeScreen
import com.azimjonc.projects.presentation.navigation.Screens.OnboardingScreen
import com.azimjonc.projects.presentation.navigation.Screens.PhoneScreen
import com.azimjonc.projects.presentation.screens.main.MainViewModel.*
import com.github.terrakok.cicerone.Router

class MainViewModel(
    private val router: Router,
    private val getInitialScreenUseCase: GetInitialScreenUseCase
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
        getInitialScreenUseCase()
            .subscribe { result ->
                val screen = when (result) {
                    Result.Home -> HomeScreen()
                    Result.Onboarding -> OnboardingScreen()
                    Result.Phone -> PhoneScreen()
                }
                router.replaceScreen(screen)
            }
    }
}