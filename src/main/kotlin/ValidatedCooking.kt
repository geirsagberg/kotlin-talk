package net.sagberg

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
        println(result)
    }
}

