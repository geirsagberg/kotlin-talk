package net.sagberg

object NormalKitchen {

    fun getFood(type: String) =
        if (foodExists()) Food(type) else null

    fun getUtensil(type: String) =
        if (utensilExists()) Utensil(type) else null

    fun prepareLunch(utensil: Utensil, food: Food) =
        if (noAccidents())
            Lunch(utensil, listOf(food), NormalKitchen::class)
        else
            throw Exception(accident(utensil))
}
