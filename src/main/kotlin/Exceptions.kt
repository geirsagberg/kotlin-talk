@file:OptIn(ExperimentalTime::class)

package net.sagberg

import arrow.core.left
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun time(label: String, block: () -> Unit) {
    val duration = measureTime(block)
    println("$label: $duration")
}

private const val times = 100000

sealed class CustomError {
    class Exception(val message: String) : CustomError()
}

class EmptyException : Exception() {
    override fun fillInStackTrace(): Throwable {
        return this
    }
}

fun failWithException() = try {
    throw Exception("oops")
} catch (_: Exception) {
}

fun failWithExceptionLeft() = Exception("oops").left()
fun failWithCustomErrorLeft() = CustomError.Exception("oops").left()


private fun failWithEmptyException() {
    try {
        throw EmptyException()
    } catch (_: Exception) {
    }
}

fun main() {
    time("failWithException") {
        repeat(times) {
            failWithException()
        }
    }
    time("failWithExceptionLeft") {
        repeat(times) {
            failWithExceptionLeft()
        }
    }
    time("failWithCustomErrorLeft") {
        repeat(times) {
            failWithCustomErrorLeft()
        }
    }
    time("failWithEmptyException") {
        repeat(times) {
            failWithEmptyException()
        }
    }
}