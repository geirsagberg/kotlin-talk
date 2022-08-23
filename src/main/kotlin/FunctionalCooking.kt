package net.sagberg

fun main() {
    with(VanillaKitchen) {
        val result = getFood("lettuce")?.let { lettuce ->
            getUtensil("knife")?.let { knife ->
                prepareLunch(knife, lettuce)
            } ?: "Knife missing :("
        } ?: "Lettuce missing :("
        println(result)
    }
}
