package de.nkono.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*

fun Application.configureAuthentication() {
    install(Authentication){
        basic("auth-admin") {
            realm = "Access to the '/' path"
            validate { credentials ->
                if (credentials.name == "admin" && credentials.password == "12") { // User Login Data
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }

}