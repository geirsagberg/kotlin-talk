package net.sagberg

import arrow.core.continuations.either
import arrow.core.getOrHandle

suspend fun main() {
    with(EitherKitchen) {
        either<CookingError, Lunch> {
            val lettuce = getFood("lettuce").bind()
            val knife = getUtensil("knife").bind()
            prepareLunch(lettuce, knife).bind()
        }.getOrHandle(::handleError).also(::println)
    }
}