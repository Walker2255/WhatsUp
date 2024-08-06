package com.azimjonc.projects.domain.usecase.chat

import com.azimjonc.projects.domain.repo.ChatRepository

class SendMessagesUseCase(
    private val chatRepository: ChatRepository
) {
    operator fun invoke(to: String, message: String) = chatRepository.sendMessage(to, message)
}