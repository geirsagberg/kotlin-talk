package net.sagberg

import arrow.core.*
import arrow.core.continuations.either

suspend fun main() {
    with(ArrowKitchen) {
        val result = either {

            val maybeSpoiledLettuce = getFood("lettuce")
                .toEither { FoodNotFound("lettuce") }
                .flatMap {
                    it.mapLeft { DetailedError("Lettuce was spoiled") }
                }
                .toValidatedNel()

            val possiblyRottenTomato = getFood("tomato")
                .toEither { FoodNotFound("tomato") }
                .flatMap {
                    it.mapLeft { DetailedError("Tomato was rotten") }
                }
                .toValidatedNel()

            val potentialKnife = getUtensil("knife")
                .toEither { UtensilNotFound }
                .toValidatedNel()

            val zipResult = maybeSpoiledLettuce
                .zip(possiblyRottenTomato, potentialKnife)
                { freshLettuce, niceTomato, knife ->
                    prepareLunch(knife, freshLettuce, niceTomato)
                }
            zipResult.valueOr { errors ->
                DetailedError("Problems: ${errors.joinToString { it.toString() }}").left()
            }.bind()
        }

        result.getOrHandle(::handleError).also(::println)
    }
}
