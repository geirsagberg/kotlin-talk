package net.sagberg

sealed class CookingError

data class FoodNotFound(val food: String) : CookingError()
object UtensilNotFound : CookingError()
data class DetailedError(val message: String) : CookingError()

fun handleError(cookingError: CookingError): String = when (cookingError) {
    is FoodNotFound -> "No ${cookingError.food} found :("
    UtensilNotFound -> "That utensil is unavailable :("
    is DetailedError -> cookingError.message
}