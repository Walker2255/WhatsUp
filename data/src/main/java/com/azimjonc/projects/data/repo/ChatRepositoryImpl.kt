package com.azimjonc.projects.data.repo

import com.azimjonc.projects.data.mapper.toMessage
import com.azimjonc.projects.data.mapper.toUser
import com.azimjonc.projects.data.remote.auth.AuthFirebase
import com.azimjonc.projects.data.remote.messages.MessagesFirestore
import com.azimjonc.projects.data.remote.users.UsersFirestore
import com.azimjonc.projects.domain.model.Chat
import com.azimjonc.projects.domain.model.Message
import com.azimjonc.projects.domain.repo.ChatRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ChatRepositoryImpl(
    private val usersFirestore: UsersFirestore,
    private val messagesFirestore: MessagesFirestore,
    private val authFirebase: AuthFirebase
) : ChatRepository {

    override fun getChats(): Single<List<Chat>> = usersFirestore.getUsers().map { users ->
        users.mapNotNull { user ->
            user.toUser()?.let { Chat(user = it) }
        }
    }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun sendMessage(to: String, message: String): Completable =
        messagesFirestore.sendMessage(authFirebase.userId!!, to, message)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getMessages(with: String): Observable<List<Message>> =
        messagesFirestore.getMessages(authFirebase.userId!!, with).map { messages ->
            messages.mapNotNull { it.toMessage(authFirebase.userId!!) }
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}