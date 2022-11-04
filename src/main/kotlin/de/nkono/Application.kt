package de.nkono

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import de.nkono.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {

        //Load Routing
        configureRouting()

        //Load Templates
        configureTemplating()

        //Load Authentication
        configureAuthentication()

        //Load StatusPage (404)
        configureStatusPages()

    }.start(wait = true)
}