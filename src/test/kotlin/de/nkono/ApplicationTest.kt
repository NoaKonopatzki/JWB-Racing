package de.nkono

import io.ktor.server.routing.*
import io.ktor.http.*
import freemarker.cache.*
import io.ktor.server.freemarker.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import de.nkono.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}