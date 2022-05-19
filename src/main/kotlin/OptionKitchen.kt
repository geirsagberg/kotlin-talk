package net.sagberg

import arrow.core.None
import arrow.core.Some

class SpoiledFood(val type: String)

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

    fun prepareLunch(utensil: Utensil, food: Food) =
        if (noAccidents())
            Some("Enjoy your ${food.type} prepared by ${utensil.type} in an Option-driven kitchen!")
        else
            None
}