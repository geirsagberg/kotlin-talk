package net.sagberg

import arrow.core.left
import arrow.core.valueOr
import arrow.core.zip

fun main() {
    with(ValidatedKitchen) {
        val maybeLettuce = getFood("lettuce")
        val maybeTomato = getFood("tomato")
        val maybeKnife = getUtensil("knife")
        val result =
            maybeLettuce.zip(maybeTomato, maybeKnife) { lettuce, tomato, knife ->
                prepareLunch(knife, lettuce, tomato)
            }
                .valueOr { errors -> DetailedError("Problems: ${errors.joinToString { it.toString() }}").left() }
                .fold({ error -> error.toString() }, { lunch -> lunch.toString() })

        println(result)
    }
}

