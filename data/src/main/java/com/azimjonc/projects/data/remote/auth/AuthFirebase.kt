package com.azimjonc.projects.data.remote.auth

interface AuthFirebase {
    fun sendSmsCode(phone: String)
}