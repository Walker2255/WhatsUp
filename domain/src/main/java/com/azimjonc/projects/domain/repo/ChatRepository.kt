package com.azimjonc.projects.domain.repo

import com.azimjonc.projects.domain.model.Chat
import com.azimjonc.projects.domain.model.Message
import com.azimjonc.projects.domain.model.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ChatRepository {
    fun getChats(): Single<List<Chat>>
    fun sendMessage(to: String, message: String): Completable
    fun getMessages(with: String): Observable<List<Message>>
}