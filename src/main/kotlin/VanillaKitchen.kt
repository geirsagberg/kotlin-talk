package net.sagberg

object VanillaKitchen {
    fun getFood(type: String) =
        if (foodExists()) Food(type) else null

    fun getUtensil(type: String) =
        if (utensilExists()) Utensil(type) else null

    fun prepareLunch(utensil: Utensil, vararg food: Food) =
        if (noAccidents())
            Lunch(utensil, food.toList(), VanillaKitchen::class)
        else
            throw Exception(accident(utensil))
}
