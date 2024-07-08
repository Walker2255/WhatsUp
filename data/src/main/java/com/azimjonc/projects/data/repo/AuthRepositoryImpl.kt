package com.azimjonc.projects.data.repo

import com.azimjonc.projects.data.remote.auth.AuthFirebase
import com.azimjonc.projects.domain.repo.AuthRepository

class AuthRepositoryImpl constructor(
    private val authFirebase: AuthFirebase
) : AuthRepository {
    override fun sendSmsCode(phone: String) {
        authFirebase.sendSmsCode(phone)
    }
}