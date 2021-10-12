package com.example.service

import com.example.data.MessageData
import com.example.model.Message

class MessageService {

    fun readMessages(limit: Int? = null): List<Message> =
        if(limit != null) MessageData.messageData.take(limit)
        else MessageData.messageData

    fun createMessage(userName: String, text: String) =
        MessageData.messageData
            .add(Message(userName, text))

    fun updateMessage(id: String, userName: String, text: String){
        MessageData.messageData = MessageData.messageData
            .map { if(it.id == id) Message(userName, text) else it }
            .toMutableList()
    }
}
