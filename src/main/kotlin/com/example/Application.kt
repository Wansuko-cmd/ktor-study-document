package com.example

import com.example.service.MessageService
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json


fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(){

    install(ContentNegotiation){
        json(Json)
    }

    val messageService = MessageService()

    routing {
        get("/"){

            val limit = call.request.queryParameters["limit"]

            call.respond(HttpStatusCode.OK, messageService.readMessages(limit?.toInt()))
        }

        post("/") {
            val parameters = call.receiveParameters()

            val userName = parameters["user_name"] ?: ""
            val text = parameters["text"] ?: ""

            println("userName: $userName")
            println("text: $text")

            messageService.createMessage(userName, text)

            call.respond(HttpStatusCode.OK)
        }
    }
}
