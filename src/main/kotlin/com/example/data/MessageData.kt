package com.example.data

import com.example.model.Message

class MessageData {
    companion object {
        var messageData = mutableListOf(
            Message("user1", "Hello", "e99f7129-1d03-46c9-ae70-930ea459a343"),
            Message("user2", "Hi!"),
            Message("user1", "Ok"),
            Message("user2", "Understood"),
        )
    }
}
