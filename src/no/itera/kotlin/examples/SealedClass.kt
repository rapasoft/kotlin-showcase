package no.itera.kotlin.examples

/**
 * Created by Pavol Rajzak, Itera.
 */

sealed class Result {
    object Yes : Result()
    object No : Result()
    object Maybe : Result()
}

fun main(args: Array<String>) {
    val res : Result = Result.Yes

    when(res) {
        is Result.Yes -> print("Yes")
        is Result.No -> print("No")
        is Result.Maybe -> print("Maybe")
    }
}