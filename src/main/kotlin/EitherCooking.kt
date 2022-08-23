package net.sagberg

import arrow.core.flatMap
import arrow.core.getOrHandle

fun main() {
    with(EitherKitchen) {
        val lunchOrError =
            getFood("lettuce").flatMap { lettuce ->
                getUtensil("knife").flatMap { knife ->
                    prepareLunch(lettuce, knife)
                }
            }

        lunchOrError.getOrHandle(::handleError).also(::println)
    }
}
