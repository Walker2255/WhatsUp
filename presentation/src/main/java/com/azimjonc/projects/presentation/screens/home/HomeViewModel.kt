package com.azimjonc.projects.presentation.screens.home

import com.azimjonc.projects.domain.model.Chat
import com.azimjonc.projects.domain.usecase.chat.GetChatsUseCase
import com.azimjonc.projects.presentation.base.BaseViewModel
import com.azimjonc.projects.presentation.screens.home.HomeViewModel.*

class HomeViewModel(
    private val getChatsUseCase: GetChatsUseCase
) : BaseViewModel<State, Input, Effect>() {

    init {
        getChats()
    }

    data class State(
        val chats: List<Chat> = emptyList(),
        val loading: Boolean = false,
        val error: Boolean = false
    )

    sealed class Input {
        object GetChats : Input()

    }

    class Effect

    override fun getDefaultState() = State()

    override fun proccesInput(input: Input) {
        when (input) {
            Input.GetChats -> getChats()
        }

    }

    private fun getChats() = getChatsUseCase()
        .doOnSubscribe {
            updateState { it.copy(loading = true, error = false) }
        }
        .doOnError {
            updateState { it.copy(error = true) }
        }
        .doAfterSuccess { chats ->
            updateState { it.copy(chats = chats) }
        }
        .doFinally {
            updateState { it.copy(loading = false) }
        }.subscribe()

}