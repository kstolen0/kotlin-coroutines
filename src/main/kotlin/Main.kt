package main

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    // create coroutine context
    runBlocking {
        // launch a job to run concurrently
        launch {
            println("print 1")
            // suspend job
            yield()
            println("print 3")
        }

        // launch a job to run concurrently
        launch {
            println("print 2")
            // suspend job
            yield()
            println("print 4")
        }
    }
}