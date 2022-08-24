package net.sagberg

sealed class CookingError

data class FoodNotFound(val food: String) : CookingError() {
    override fun toString(): String = "No $food found :("
}

object UtensilNotFound : CookingError() {
    override fun toString(): String = "That utensil is unavailable :("
}

data class DetailedError(val message: String) : CookingError() {
    override fun toString(): String = message
}

fun handleError(cookingError: CookingError): String = cookingError.toString()