package com.azimjonc.projects.domain.usecase.chat

import com.azimjonc.projects.domain.repo.ChatRepository

class GetMessagesUseCase(
    private val chatRepository: ChatRepository
) {
    operator fun invoke(with:String) = chatRepository.getMessages(with)
}