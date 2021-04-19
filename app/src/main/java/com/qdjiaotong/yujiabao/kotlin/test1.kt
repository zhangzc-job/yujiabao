package com.qdjiaotong.yujiabao.kotlin

import kotlinx.coroutines.*

fun main(){

    runBlocking {
       val start=System.currentTimeMillis()
        val result1=async {
            delay(1000)
            5+5
        }.await()
        val result2=async {
            delay(1000)
            5+10
        }.await()

        println("result is ${result1+result2}")
        val end=System.currentTimeMillis()
        println("cost ${end-start} ms")
    }

    /*GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")
    }*/
    /*runBlocking {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")
        }

        launch {
            println("launch2")
            delay(1000)
            println("launch2 finished")
        }
    }

    val start=System.currentTimeMillis()
    runBlocking {
        repeat(20000){
            launch {
                println(".......")
            }
        }
    }
    val end=System.currentTimeMillis()
    println(end-start)*/
//    Thread.sleep(2000)

    /*runBlocking {
        coroutineScope {
            launch {
                for(i in 1..10){
                    println(i)
                    delay(1000)
                }
            }
        }

        async {

        }
        println("coroutimen finished")
    }
    println("runblocking finished")

    val job= Job()
    val scope= CoroutineScope(job)
    */
}

suspend fun printDot(){
    println("ddd")
    delay(1000)
}

suspend fun printDot2()= coroutineScope {
    launch {

    }
}