package net.sagberg

import arrow.core.left
import arrow.core.right

object EitherKitchen {
    fun getFood(type: String) =
        if (foodExists())
            Food(type).right()
        else
            FoodNotFound(type).left()

    fun getUtensil(type: String) =
        if (utensilExists())
            Utensil(type).right()
        else
            UtensilNotFound.left()

    fun prepareLunch(food: Food, utensil: Utensil) =
        if (noAccidents())
            Lunch(utensil, listOf(food), EitherKitchen::class).right()
        else
            DetailedError(accident(utensil)).left()
}