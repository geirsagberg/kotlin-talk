package net.sagberg

data class Quote(val content: String, val author: String) {
    override fun toString() = "'$content' - $author"
}
