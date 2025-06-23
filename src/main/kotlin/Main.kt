package main

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    // create a coroutine context
    runBlocking {
        // suspend until jobs have completed
        coroutineScope {
            launch {
                delay(100)
                println("job 1 complete")
            }

            launch {
                delay(50)
                println("job 2 complete")
            }
        }
        println("all jobs completed")
    }
}