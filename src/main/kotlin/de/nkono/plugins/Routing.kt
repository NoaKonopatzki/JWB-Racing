package de.nkono.plugins

import de.nkono.models.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.util.*
import java.io.File

fun Application.configureRouting() {
    routing {
        authenticate("auth-admin") {
            route("/admin") {
                get {
                    val pageName = Name("Admin")
                    call.respond(
                        FreeMarkerContent(
                            "pages/admin.ftl",
                            mapOf("pageName" to pageName),
                            contentType = ContentType.Text.Html
                        )
                    )
                }
                get("/new") {
                    val pageName = Name("News")
                    // Show a page with fields for creating a new article
                    call.respond(FreeMarkerContent("pages/news/new.ftl", mapOf("pageName" to pageName)))
                }
                get("/{id}/edit") {
                    val pageName = Name("News")
                    // Show a page with fields for editing an article
                    val id = call.parameters.getOrFail<Int>("id").toInt()
                    call.respond(
                        FreeMarkerContent(
                            "pages/news/edit.ftl",
                            mapOf("news" to news.find { it.id == id }, "pageName" to pageName)
                        )
                    )
                }
                get("/upload") {
                    val pageName = Name("Gallery")

                    call.respond(
                        FreeMarkerContent(
                            "pages/gallery.ftl",
                            mapOf("pageName" to pageName),
                            contentType = ContentType.Text.Html
                        )
                    )
                }
            }
        }
        get {
            val pageName = Name("Home")
            call.respond(
                FreeMarkerContent(
                    "pages/home.ftl",
                    mapOf("pageName" to pageName),
                    contentType = ContentType.Text.Html
                )
            )
        }
        route("/news") {
            get {
                val pageName = Name("News")
                // Show a list of articles
                call.respond(FreeMarkerContent("pages/news.ftl", mapOf("news" to news, "pageName" to pageName)))
            }
            post {
                // Save an article
                val formParameters = call.receiveParameters()
                val title = formParameters.getOrFail("title")
                val body = formParameters.getOrFail("body")
                val newEntry = News.newEntry(title, body)
                news.add(newEntry)
                call.respondRedirect("/news/${newEntry.id}")
            }
            get("{id}") {
                val pageName = Name("News")
                // Show an article with a specific id
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(
                    FreeMarkerContent(
                        "pages/news/show.ftl",
                        mapOf("news" to news.find { it.id == id }, "pageName" to pageName)
                    )
                )
            }
            post("{id}") {
                // Update or delete an article
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "Update" -> {
                        val index = news.indexOf(news.find { it.id == id })
                        val title = formParameters.getOrFail("title")
                        val body = formParameters.getOrFail("body")
                        news[index].title = title
                        news[index].body = body
                        call.respondRedirect("/news/$id")
                    }

                    "Delete" -> {
                        news.removeIf { it.id == id }
                        call.respondRedirect("/news")
                    }
                }
            }
        }
        route("/gallery") {
            get {
                val pageName = Name("Gallery")
                call.respond(
                    FreeMarkerContent(
                        "pages/gallery.ftl",
                        mapOf("pageName" to pageName),
                        contentType = ContentType.Text.Html
                    )
                )
            }
        }
        get("/contact") {
            val pageName = Name("Contact")
            call.respond(
                FreeMarkerContent(
                    "pages/contact.ftl",
                    mapOf("pageName" to pageName),
                    contentType = ContentType.Text.Html
                )
            )
        }
        static("/utils") {
            staticRootFolder = File("static")
            static("/") {
                staticBasePackage = "static"
                static("css") {
                    resources("css")
                }
                static("js") {
                    resources("js")
                }
                static("img") {
                    resources("img")
                }
            }
        } // Statics
    }
}

data class Name(val name: String)
