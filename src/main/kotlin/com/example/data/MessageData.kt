package com.example.data

import com.example.model.Message

class MessageData {
    companion object {
        val messageData = mutableListOf(
            Message("user1", "Hello"),
            Message("user2", "Hi!"),
            Message("user1", "Ok"),
            Message("user2", "Understood"),
        )
    }
}
