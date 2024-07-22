package com.azimjonc.projects.domain.repo

import com.google.firebase.auth.FirebaseUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface AuthRepository {
    fun sendSmsCode(phone: String): Completable
    fun verify(code: String): Completable
    val isLoggedIn: Boolean
}