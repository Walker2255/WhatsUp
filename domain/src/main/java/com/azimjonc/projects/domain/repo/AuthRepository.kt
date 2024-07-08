package com.azimjonc.projects.domain.repo

interface AuthRepository {
    fun sendSmsCode(phone: String)
}