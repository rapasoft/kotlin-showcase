package no.itera.kotlin.examples

import java.io.FileInputStream
import java.nio.file.Paths
import java.util.*
import kotlin.reflect.declaredMemberProperties

data class ForFun(val myPropertah: String)

fun main(args: Array<String>) {
    val mutableList = arrayListOf(1, 2, 3, 4, 5)

    // Getting the name of class from class/instance
    println(ArrayList::class.java)
    println(mutableList.javaClass)

    // Kotlin Class
    println(ForFun::class.declaredMemberProperties)
    println(ForFun::class.java.declaredFields.map { it })

    // Java Class
    println(SomeJavaClass::class.declaredMemberProperties)
    println(SomeJavaClass::class.java.declaredFields.map { it })

    // Try with resources Kotlin style
    val stream = FileInputStream(Paths.get("./resource/sales.csv").loadFromClassPath().toFile())
    stream.buffered().reader().use { reader -> println(reader.readText().length) }
}


