package com.azimjonc.projects.data.mapper

import com.azimjonc.projects.data.remote.messages.MessageDocument
import com.azimjonc.projects.domain.model.Message
import com.azimjonc.projects.domain.model.Type

fun MessageDocument.toMessage(userId: String) : Message?{
    return Message(
        id = id  ?: return null,
        message = message ?: return null,
        time = time ?: return null,
        type = if (from == userId) Type.text_out else Type.text_in
    )
}