package com.adidas.ys.http.enpoints.echo

import com.adidas.ys.http.transformers.NameTransformer
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.micronaut.ktor.KtorRoutingBuilder
import javax.inject.Singleton

@Singleton
class EchoEndpoint(private val nameTransformer: NameTransformer) : KtorRoutingBuilder({
    get("/health-check/echo") {
        call.respondText ( "Service Working", contentType = ContentType.Text.Plain )
    }
})