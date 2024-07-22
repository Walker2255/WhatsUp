package com.azimjonc.projects.data.mapper

import com.azimjonc.projects.data.remote.users.model.UserDocument
import com.azimjonc.projects.domain.model.User

fun UserDocument.toUser(): User? {
    return User(
        id = id ?: return null,
        phone = phone ?: return null,
        name = name ?: return null,
        avatar = avatar
    )
}
