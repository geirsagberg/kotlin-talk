package net.sagberg

import arrow.core.None
import arrow.core.Some


object OptionKitchen {
    fun getFood(type: String) =
        if (foodExists())
            Some(Food(type))
        else
            None

    fun getUtensil(type: String) =
        if (utensilExists())
            Some(Utensil(type))
        else
            None

    fun prepareLunch(utensil: Utensil, vararg food: Food) =
        if (noAccidents())
            Some(Lunch(utensil, food.toList(), OptionKitchen::class))
        else
            None
}