package com.azimjonc.projects.data.remote.users

import com.azimjonc.projects.data.remote.users.model.UserDocument
import com.google.firebase.auth.FirebaseUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface UsersFirestore {
    fun saveUser(user: FirebaseUser): Completable
    fun getUsers(): Single<List<UserDocument>>
}