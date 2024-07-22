package com.azimjonc.projects.domain.repo

import com.azimjonc.projects.domain.model.Chat
import com.azimjonc.projects.domain.model.User
import io.reactivex.rxjava3.core.Single

interface ChatRepository {
    fun getChats(): Single<List<Chat>>
}