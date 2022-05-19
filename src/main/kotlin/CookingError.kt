package net.sagberg

sealed class CookingError

object FoodNotFound : CookingError()
object UtensilNotFound : CookingError()
data class DetailedError(val message: String) : CookingError()