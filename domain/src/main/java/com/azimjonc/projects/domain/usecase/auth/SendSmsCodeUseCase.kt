package com.azimjonc.projects.domain.usecase.auth

import com.azimjonc.projects.domain.repo.AuthRepository

class SendSmsCodeUseCase constructor(
    private val authRepository: AuthRepository
) {

    operator fun invoke(phone: String) {
        authRepository.sendSmsCode(phone)

    }

}