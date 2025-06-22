package main

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    // runBlocking is a coroutine builder.
    // It creates a new coroutine context which bridges
    // the gap between synchronous and asynchronous code
    runBlocking {
        susPrint("hello!")
    }
}

// suspend functions can only be run
// in a coroutine context. This allows
// the function to call other coroutine functions.
// Additionally, when the function is blocked, the
// coroutine is "suspended" which releases
// the underlying thread to execute other coroutines
suspend fun susPrint(text: String) {
    // delay is a kotlinx coroutine function which suspends the
    // coroutine for the specified period of milliseconds
    delay(100)
    println(text)
}