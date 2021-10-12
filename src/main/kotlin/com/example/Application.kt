package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(){

    routing {
        get("/"){

            val query = call.request.queryParameters["query"]

            call.respond(HttpStatusCode.OK, query ?: "Hello World")
        }

        get("/{id}"){
            val id = call.parameters["id"] ?: "null"

            call.respond(HttpStatusCode.OK, id)
        }
    }
}
