package net.sagberg

fun main() {
    with(NormalKitchen) {
        val lettuce = getFood("lettuce")

        if (lettuce != null) {
            val knife = getUtensil("knife")
            if (knife != null) {
                val lunch = prepareLunch(knife, lettuce)

                println(lunch)
            } else {
                println("No knife, no lunch :(")
            }
        } else {
            println("No lettuce, no lunch :(")
        }
    }
}