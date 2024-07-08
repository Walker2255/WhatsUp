package com.azimjonc.projects.presentation.screens.main

import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.navigation.Screens.Phone
import com.azimjonc.projects.presentation.screens.main.MainViewModel.*
import com.github.terrakok.cicerone.Router

class MainViewModel(
    private val router: Router
) : BaseViewModel<State, Input, Effect>() {
    class State

    class Input

    class Effect

    init {
        router.newRootScreen(Phone())
    }

    override fun getDefaultState() = State()

    override fun proccesInput(input: Input) {
    }
}