package net.sagberg

import arrow.core.Either

suspend fun main() {
    val quote = fetchQuote()
    println("$quote")

    fetchWillFail = true

    try {
        val quote2 = fetchQuote()
        println("$quote2")
    } catch (exception: Exception) {
        println("Could not fetch quote: ${exception.localizedMessage}")
    }

    val maybeQuote = maybeFetchQuote()


}

suspend fun maybeFetchQuote(): Either<Throwable, Unit> = Either.catch {
    fetchQuote()
}