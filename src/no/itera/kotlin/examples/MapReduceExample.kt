package no.itera.kotlin.examples

// Immutable list
val listOfEvents = listOf(
        "200, \"OK\", 1345",
        "403, \"User is not authorized\", 32",
        "404, \"Not found\", 143",
        "500, \"Internal server error\", 6"
)

// Data class
data class Event(val code: Int, val message: String, val timesOccured: Int)

// Extension functions
fun String.toEvent() : Event {
    val chunks = this.split(",").map { it.trim() }
    return Event(chunks[0].toInt(), chunks[1], chunks[2].toInt())
}

// Map / Filter / Reduce
private fun countNumberOfErrors(listOfEvents: List<String>) =
        listOfEvents
                .map { it.toEvent() }
                .filter { it.code >= 400 }
                .map { it.timesOccured }
                .reduce { acc, next -> acc + next } // the same as '.sum()'

fun main(args: Array<String>) {
    val numberOfErrorsOccurred = countNumberOfErrors(listOfEvents)

    println(numberOfErrorsOccurred)
}
