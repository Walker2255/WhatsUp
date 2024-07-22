package com.azimjonc.projects.presentation.screens.phone

import androidx.lifecycle.ViewModel
import com.azimjonc.projects.domain.model.User
import com.azimjonc.projects.domain.usecase.auth.SendSmsCodeUseCase
import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.navigation.Screens.CodeScreen
import com.azimjonc.projects.presentation.screens.code.CodeFragment
import com.azimjonc.projects.presentation.screens.phone.PhoneViewModel.*
import com.github.terrakok.cicerone.Router


class PhoneViewModel constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase,
    private val router: Router
) : BaseViewModel<State, Input, Effect>() {

    data class State(
        val loading: Boolean = false
    )

    sealed class Effect {
        object Error : Effect()
    }

    sealed class Input {
        data class SendCode(val phone: String) : Input()
    }

    override fun getDefaultState() = State()
    override fun proccesInput(input: Input) {
        when (input) {
            is Input.SendCode -> sendCode(input.phone)
        }
    }


    private fun sendCode(phone: String) = sendSmsCodeUseCase(phone)
        .doOnSubscribe {
            updateState { it.copy(loading = true) }
        }.doOnError {
            emitEffect(Effect.Error)
        }.doOnComplete {
            router.navigateTo(CodeScreen(phone))
        }.doFinally {
            updateState { it.copy(loading = false) }
        }.subscribe({}, {})
}