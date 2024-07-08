package com.azimjonc.projects.presentation.screens.phone

import androidx.lifecycle.ViewModel
import com.azimjonc.projects.domain.model.User
import com.azimjonc.projects.domain.usecase.auth.SendSmsCodeUseCase
import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.screens.phone.PhoneViewModel.*


class PhoneViewModel constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
) : BaseViewModel<State, Input, Effect>() {

    data class State(
        val user: User? = null
    )

    class Effect

    class Input

    override fun getDefaultState() = State()

    override fun proccesInput(input: Input) {

    }

}