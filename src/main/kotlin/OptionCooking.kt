package net.sagberg

import arrow.core.getOrElse

fun main() {
    with(OptionKitchen) {
        val maybeLunch =
            getFood("lettuce").flatMap { lettuce ->
                getUtensil("knife").flatMap { knife ->
                    prepareLunch(knife, lettuce)
                }
            }
        val result = maybeLunch
            .map { lunch -> lunch.toString() }
            .getOrElse { "Something was missing :(" }
        println(result)
    }
}