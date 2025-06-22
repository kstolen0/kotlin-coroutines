package main

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    runBlocking {
        // launch a new job so that it can be run
        // concurrently in the current coroutine scope
        launch {
            println("task 1 step 1")
            // suspend the current job and immediately schedule it
            // fow when the thread becomes available
            yield()
            println("task 1 step 2")
            yield()
            println("task 1 step 3")
        }
        launch {
            println("task 2 step 1")
            yield()
            println("task 2 step 2")
            yield()
            println("task 2 step 3")
        }
    }
}