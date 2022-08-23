package net.sagberg

import arrow.core.continuations.either
import arrow.core.getOrHandle
import arrow.core.left
import arrow.core.valueOr
import arrow.core.zip

suspend fun main() {
    with(ArrowKitchen) {
        val result = either {
            val maybeSpoiledLettuce = getFood("lettuce")
                .bind { FoodNotFound("lettuce") }
                .mapLeft {
                    DetailedError("Lettuce was spoiled")
                }.toValidatedNel()

            val possiblyRottenTomato = getFood("tomato")
                .bind { FoodNotFound("tomato") }
                .mapLeft {
                    DetailedError("Tomato was spoiled")
                }.toValidatedNel()

            val knife = getUtensil("knife")
                .bind { UtensilNotFound }

            maybeSpoiledLettuce.zip(possiblyRottenTomato) { freshLettuce, niceTomato ->
                prepareLunch(knife, freshLettuce, niceTomato)
            }.valueOr { errors ->
                DetailedError("Problematic ingredients: ${errors.joinToString { it.message }}").left()
            }.bind()
        }

        result.getOrHandle(::handleError).also(::println)
    }
}
