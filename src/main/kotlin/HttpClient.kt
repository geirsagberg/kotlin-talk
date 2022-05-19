package net.sagberg

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*

val httpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        gson()
    }
}