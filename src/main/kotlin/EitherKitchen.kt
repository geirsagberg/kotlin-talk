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

    fun prepareLunch(utensil: Utensil, vararg ingredients: Food) =
        if (noAccidents())
            Lunch(utensil, ingredients.toList(), EitherKitchen::class).right()
        else
            DetailedError(accident(utensil)).left()
}