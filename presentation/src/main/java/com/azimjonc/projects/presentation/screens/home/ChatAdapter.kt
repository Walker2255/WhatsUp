package com.azimjonc.projects.presentation.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.azimjonc.projects.domain.model.Chat
import com.azimjonc.projects.presentation.R
import com.azimjonc.projects.presentation.databinding.ItemChatBinding
import com.bumptech.glide.Glide

class ChatAdapter(private val chats: List<Chat>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) = with(binding) {
            Glide.with(root).load(R.drawable.ic_person).into(avatar)
            name.text = chat.user.name
            last.text = chat.user.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = chats.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chats[position])
    }
}