package net.sagberg

import kotlin.reflect.KClass

data class Lunch(val utensil: Utensil, val ingredients: Iterable<Food>, val kitchen: KClass<*>) {
    override fun toString(): String =
        "Enjoy your lunch of ${ingredients.joinToString(" and ") { it.type }} prepared by ${utensil.type} in a ${kitchen.simpleName}!"
}

open class Food(val type: String)

class ChoppedFood(type: String) : Food(type)

class SpoiledFood(type: String) : Food(type)

class Utensil(val type: String)

fun foodExists() = Math.random() < 0.7

fun foodIsOkay() = Math.random() < 0.8

fun utensilExists() = Math.random() < 0.9

fun noAccidents() = Math.random() > 0.6