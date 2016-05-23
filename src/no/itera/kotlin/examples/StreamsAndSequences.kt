package no.itera.kotlin.examples

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.system.measureTimeMillis

data class TransactionRecord(
        val Transaction_date: String, val Product: String, val Price: String, val Payment_Type: String,
        val Name: String, val City: String, val State: String, val Country: String,
        val Account_Created: String, val Last_Login: String, val Latitude: String, val Longitude: String)

data class Transaction(val productName: String, val price: Double, val state: String)

fun listToTransaction(list: List<String>): TransactionRecord = TransactionRecord(
        list[0], list[1], list[2], list[3],
        list[4], list[5], list[6], list[7],
        list[8], list[9], list[10], list[11]
)

fun Path.loadFromClassPath(): Path {
    return File(TransactionRecord::class.java.classLoader.getResource(this.toString()).toURI()).toPath()
}

// Compare Java 8 streams and Kotlin sequences
fun main(args: Array<String>) {
    val timeWithLazy = measureTimeMillis {
        println(
                Files.lines(Paths.get("./resource/sales.csv").loadFromClassPath())
                        .map { listToTransaction(it.split(",").toList()) }
                        .map { Transaction(it.Product, it.Price.toDouble(), it.State) }
                        .filter { it.price > 1000 }
                        .findFirst()
        )
    }

    println("Java 8: $timeWithLazy ms")

    val timeWithoutLazy = measureTimeMillis {
        println(
                Paths.get("./resource/sales.csv").loadFromClassPath().toFile().readLines()
                        .map { listToTransaction(it.split(",").toList()) }
                        .map { Transaction(it.Product, it.Price.toDouble(), it.State) }
                        .filter { it.price > 1000 }
                        .first()
        )
    }

    println("Kotlin: $timeWithoutLazy ms")
}