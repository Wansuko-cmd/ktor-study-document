package com.example.service

import com.example.data.MessageData
import com.example.model.Message

class MessageService {

    private var messageData = MessageData.messageData


    fun readMessages(limit: Int? = null): List<Message> =
        if(limit != null) messageData.take(limit)
        else messageData

    fun createMessage(userName: String, text: String) {
        messageData = messageData + listOf(Message(userName, text))
    }


    fun updateMessage(id: String, userName: String, text: String){
        messageData = messageData
            .map { if(it.id == id) Message(userName, text, id) else it }
    }

    fun deleteMessage(id: String) {
        messageData = messageData.filterNot { it.id == id }
    }
}
