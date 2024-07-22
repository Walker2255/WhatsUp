package com.azimjonc.projects.presentation.screens.code

import com.azimjonc.projects.domain.usecase.auth.VerifyCodeUseCase
import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.navigation.Screens.HomeScreen
import com.azimjonc.projects.presentation.screens.code.CodeViewModel.*
import com.github.terrakok.cicerone.Router

class CodeViewModel(
    private val verifyCodeUseCase: VerifyCodeUseCase,
    private val router: Router
) : BaseViewModel<State, Input, Effect>() {
    class State

    sealed class Input {
        data class Verify(val code: String) : Input()
    }

    sealed class Effect {
        object Error : Effect()
    }

    override fun getDefaultState() = State()

    override fun proccesInput(input: Input) {
        when (input) {
            is Input.Verify -> verify(input.code)
        }
    }

    private fun verify(code: String) = verifyCodeUseCase(code)
        .doOnError {
            emitEffect(Effect.Error)
        }.doOnComplete {
            router.replaceScreen(HomeScreen())
        }.subscribe({}, {})
}