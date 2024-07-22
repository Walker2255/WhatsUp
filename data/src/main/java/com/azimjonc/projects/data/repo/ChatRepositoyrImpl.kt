package com.azimjonc.projects.data.repo

import com.azimjonc.projects.data.mapper.toUser
import com.azimjonc.projects.data.remote.users.UsersFirestore
import com.azimjonc.projects.domain.model.Chat
import com.azimjonc.projects.domain.repo.ChatRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ChatRepositoyrImpl(
    private val usersFirestore: UsersFirestore
) : ChatRepository {

    override fun getChats(): Single<List<Chat>> = usersFirestore.getUsers().map { users ->
        users.mapNotNull { user ->
            user.toUser()?.let { Chat(user = it) }
        }
    }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}