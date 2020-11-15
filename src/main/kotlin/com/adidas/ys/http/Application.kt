package com.adidas.ys.http
import io.ktor.server.netty.NettyApplicationEngine
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val server = embeddedServer(Netty, port = 8080) {
            routing {
                get("/") {
                    call.respondText("Hello World!", ContentType.Text.Plain)
                }
                get("/demo") {
                    call.respondText("HELLO WORLD!")
                }
            }
        }
        server.start(wait = true)
    }
}
