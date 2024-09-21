package de.bytecave.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

import io.ktor.server.plugins.statuspages.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<IllegalStateException> { call, cause ->
            call.respondText("App in illegal state as ${cause.message}")
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/error-test") {
            throw IllegalStateException("Too Busy")
        }
    }
}