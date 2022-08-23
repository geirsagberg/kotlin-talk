package net.sagberg

import arrow.core.*

object ValidatedKitchen {
    fun getFood(type: String): ValidatedNel<CookingError, Food> =
        if (foodExists())
            Food(type).valid()
        else
            FoodNotFound(type).invalidNel()

    fun getUtensil(type: String): ValidatedNel<CookingError, Utensil> =
        if (utensilExists())
            Utensil(type).valid()
        else
            UtensilNotFound.invalidNel()

    fun prepareLunch(utensil: Utensil, vararg ingredients: Food) =
        if (noAccidents())
            Lunch(utensil, ingredients.toList(), ValidatedKitchen::class).right()
        else
            DetailedError(accident(utensil)).left()
}