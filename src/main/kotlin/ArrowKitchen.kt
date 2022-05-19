package net.sagberg

import arrow.core.None
import arrow.core.Some
import arrow.core.left
import arrow.core.right

object ArrowKitchen {
    fun chopFood(food: Food) = ChoppedFood(food.type)

    fun getFood(type: String) =
        if (foodExists())
            Some(existingFood(type))
        else
            None

    private fun existingFood(type: String) =
        if (foodIsOkay())
            Food(type).right()
        else
            SpoiledFood(type).left()

    fun getUtensil(type: String) =
        if (utensilExists())
            Some(Utensil(type))
        else
            None

    fun prepareLunch(utensil: Utensil, vararg ingredients: Food) =
        if (noAccidents())
            Lunch(utensil, ingredients.toList(), ArrowKitchen::class).right()
        else
            DetailedError(accident(utensil)).left()
}