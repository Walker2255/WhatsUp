package com.azimjonc.projects.presentation.screens.home

import android.os.Bundle
import android.view.View
import com.azimjonc.projects.domain.model.Chat
import com.azimjonc.projects.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.azimjonc.projects.presentation.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(::rednderChats){it.chats}
        viewModel.state.observe(::rednderLoading){it.loading}
        viewModel.state.observe(::rednderError){it.error}

    }

    private fun rednderError(error: Boolean) {

    }

    private fun rednderLoading(loading: Boolean) {
        
    }

    private fun rednderChats(chats: List<Chat>)  = with(binding){
        binding.chats.adapter = ChatAdapter(chats)

    }
}