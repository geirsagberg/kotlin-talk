package net.sagberg

import arrow.core.continuations.either

suspend fun main() {
    with(EitherKitchen) {
        val lunchResult = either {
            val lettuce = getFood("lettuce").bind()
            val tomato = getFood("tomato").bind()
            val knife = getUtensil("knife").bind()
            prepareLunch(knife, lettuce, tomato).bind()
        }
        lunchResult.fold({ it.toString() }, { it.toString() })
            .also(::println)
    }
}