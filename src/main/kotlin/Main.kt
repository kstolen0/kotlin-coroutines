package main

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    // create the coroutine context
    runBlocking {
        someTask()
    }
}

suspend fun someTask() {
    // coroutineScope is another coroutine builder
    // which creates a new context while inheriting the current
    // coroutine context.
    // coroutine scope suspends the current coroutine until all
    // jobs in the block have been completed
    coroutineScope {
        // some coroutine functions (such as launch and
        // async) can only be called directly in a
        // coroutine builder
        launch {
            println("begin task A")
            // yield suspends the current coroutine so
            // that task B can execute
            yield()
            println("complete task A")
        }
        launch {
            println("begin task B")
            // delay suspend the current coroutine
            // so task A can resume
            delay(1000)
            println("complete task B")
        }
    }
    // wont execute until all jobs in coroutineScope have completed
    println("finished some task")
}