package de.nkono.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages){
        status(HttpStatusCode.NotFound) { call, status ->
            val pageName = Name("404")
            call.respond(
                FreeMarkerContent(
                "pages/404.ftl",
                mapOf("pageName" to pageName),
                contentType = ContentType.Text.Html
            )
            )
        }
    }
}