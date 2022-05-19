package net.sagberg

import arrow.core.flatMap
import arrow.core.getOrHandle

fun main() {
    with(EitherKitchen) {
        val either =
            getFood("lettuce").flatMap { lettuce ->
                getUtensil("knife").flatMap { knife ->
                    prepareLunch(lettuce, knife)
                }
            }

        either.getOrHandle(::handleError).also(::println)
    }
}

fun handleError(cookingError: CookingError): String = when (cookingError) {
    FoodNotFound -> "No food found :("
    UtensilNotFound -> "That utensil is unavailable :("
    is DetailedError -> cookingError.message
}