package main

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    // create coroutine context
    runBlocking {
        // async is a coroutine builder which returns a Deferred object.
        // A Deferred object will eventually return a result, or it will fail
        val taskOne = async {
            yield()
            " world"
        }
        val taskTwo = async {
            // uncomment the below line to also cancel the
            // job awaiting the result from taskTwo
            // cancel()
            "hello"
        }

        launch {
            // await suspends the current coroutine
            // until the result is available.
            // if the job was cancelled then this job will also be cancelled
            print(taskOne.await())
        }
        launch {
            print(taskTwo.await())
        }
    }
}