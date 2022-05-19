package net.sagberg

import io.ktor.client.call.*
import io.ktor.client.request.*

var fetchWillFail = false

suspend fun fetchQuote() =
    if (fetchWillFail)
        throw Exception("Sorry, no internet today!")
    else
        httpClient.get("https://api.quotable.io/random").body<Quote>()
