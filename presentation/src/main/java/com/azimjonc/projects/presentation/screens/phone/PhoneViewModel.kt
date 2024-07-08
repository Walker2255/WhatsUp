package com.azimjonc.projects.presentation.screens.phone

import androidx.lifecycle.ViewModel
import com.azimjonc.projects.domain.usecase.auth.SendSmsCodeUseCase

class PhoneViewModel constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
) : ViewModel() {

}