package com.adidas.ys.adapters.twitter

import javax.inject.Singleton

data class Tweet(val id: Int, val message: String)

interface ITweeterAdapter {
    fun getTweet(tweetId: Int): Tweet
    fun getPopularTweets(): List<Tweet>
}

@Singleton
class TweeterAdapter : ITweeterAdapter {

    override fun getTweet(tweetId: Int): Tweet = Tweet(1, "zio-tweet")

    override fun getPopularTweets(): List<Tweet> =
            listOf(Tweet(1, "zio-tweet-1"),
                    Tweet(2, "zio-tweet-2"))
}