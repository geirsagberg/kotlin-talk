package net.sagberg

import arrow.core.left
import arrow.core.valueOr
import arrow.core.zip

fun main() {
    with(ValidatedKitchen) {
        val maybeLettuce = getFood("lettuce")
        val maybeTomato = getFood("tomato")
        val maybeKnife = getUtensil("knife")
        val zipResult =
            maybeLettuce.zip(maybeTomato, maybeKnife) { lettuce, tomato, knife ->
                prepareLunch(knife, lettuce, tomato)
            }
        val validatedResult = zipResult.valueOr { errors ->
            DetailedError("Problems: ${errors.joinToString { it.toString() }}").left()
        }
        val result = validatedResult.fold({ error ->
            error.toString()
        }, { lunch ->
            lunch.toString()
        })

        println(result)
    }
}

