package net.sagberg

fun main() {
    with(NormalKitchen) {
        val result = try {
            val lettuce = getFood("lettuce") ?: throw Exception("No lettuce :(")
            val knife = getUtensil("knife") ?: throw Exception("No knife :(")
            prepareLunch(knife, lettuce)
        } catch (exception: Exception) {
            "No lunch today: ${exception.localizedMessage}"
        }
        println(result)
    }
}