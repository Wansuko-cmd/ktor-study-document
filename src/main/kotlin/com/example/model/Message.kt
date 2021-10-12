package com.example.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Message(
    @SerialName("user_name")
    val userName: String,
    val text: String,
    val id: String = UUID.randomUUID().toString(),
)
