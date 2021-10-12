package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(){

    routing {
        get("/"){

            val query = call.request.queryParameters["query"]

            call.respond(HttpStatusCode.OK, query ?: "Hello World")
        }

        post("/") {
            val parameters = call.receiveParameters()
            val value = parameters["value"] ?: ""
            println(value)
        }
    }
}
