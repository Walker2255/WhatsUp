package com.azimjonc.projects.domain.usecase.chat

import com.azimjonc.projects.domain.repo.ChatRepository

class GetChatsUseCase(
    private val chatRepository: ChatRepository
) {

    operator fun invoke() = chatRepository.getChats()
}