package com.adidas.ys.http.enpoints.twitter

import com.adidas.ys.adapters.twitter.ITweeterAdapter
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.get
import io.micronaut.ktor.KtorRoutingBuilder
import javax.inject.Singleton
import arrow.core.Either
import arrow.core.toOption

@Singleton
class TwitterEndpoint(private val adapter: ITweeterAdapter) : KtorRoutingBuilder({
    get("/tweeter/tweets/popular") {
        call.respond(adapter.getPopularTweets())
    }
    get("/tweeter/tweets/{id}") {
        val id = call.parameters["id"]?.toIntOrNull().toOption()
        id.fold({ call.respond(adapter.getTweet(0)) }  , { id -> call.respond(adapter.getTweet(id)) })
    }
})
