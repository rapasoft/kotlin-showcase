package no.itera.kotlin.examples

import java.io.FileInputStream
import java.nio.file.Paths
import java.util.*
import kotlin.reflect.declaredMemberProperties

fun main(args: Array<String>) {
    val mutableList = arrayListOf(1, 2, 3, 4, 5)

    println(ArrayList::class.java)
    println(mutableList.javaClass)

    data class ForFun(val myPropertah: String)

    // Java Class
    println(SomeJavaClass::class.declaredMemberProperties)
    println(SomeJavaClass::class.java.declaredFields.map { it })

    val stream = FileInputStream(Paths.get("./resource/sales.csv").loadFromClassPath().toFile())
    stream.buffered().reader().use { reader -> println(reader.readText().length) }
}


