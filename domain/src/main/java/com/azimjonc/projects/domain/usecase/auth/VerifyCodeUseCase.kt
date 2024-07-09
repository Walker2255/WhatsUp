package com.azimjonc.projects.domain.usecase.auth

import com.azimjonc.projects.domain.repo.AuthRepository

class VerifyCodeUseCase constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(code: String) = authRepository.verify(code)

}