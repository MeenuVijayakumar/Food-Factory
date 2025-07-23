package com.applab.foodfactory.practices

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
//    Ex1 - get distinct numbers  from flow
    /* val flow = flowOf(1, 2, 5, 67, 45, 44, 89, 98, 4, 44)
     val filterList = flow.filter { it % 2 == 0 }
     filterList.collect { println(it) }*/

    /**
     * flow.filter { it%2==0 }.distinctUntilChanged()
     * 🔢 Filtered Even Numbers:
     * 2, 44, 98, 4, 44
     *
     * 🔁 distinctUntilChanged() only skips if two adjacent values are the same:
     * 44 appears twice, but not consecutively → so both are printed.
     * //    to get distinct numbers
     * //    val filterList = flow.filter { it%2==0 }.toList().distinct()
     * //    or
     * //    val filterSet = flow.filter { it%2==0 }.toSet()
     *
     *
     */
    /* val flow = flowOf(1, 2, 5, 67, 45, 44, 89, 98, 4, 44)
     val squaredFlow = flow.map { it*it }
     squaredFlow.collect {
         println(it)
     }
     println("Multiplying by 2")
     flow.map { it*2 }.collect {
         println(it)
     }
     flow.onEach { println("Received $it") }.collect()*/

    val userIdFlow = flowOf(1, 2, 3, 4, 5)
    /*userIdFlow.collect {
        println("Id is $it")
        getUserDetails(it).collect { it1 ->
            println(it1)
        }
    }*/
    /*val result = userIdFlow.flatMapConcat {
        println("Id is $it")
        getUserDetails(it)
    }*/
    /* val result = userIdFlow.flatMapMerge {
         println("Id is $it")
         getUserDetails(it)
     }
     result.collect {
         println(it)
     }*/

    val searchQuerry = flow {
        emit("ca")
        delay(10)
        emit("cat")
    }
    searchQuerry
        .flatMapLatest { query -> searchApi(query) }
        .collect { result ->
            println("Result: $result")
        }


}

fun searchApi(str: String): Flow<String> = flow {
    println("seacrching for $str")
    delay(1000)
    emit("Emit result for $str")
}

fun getUserDetails(id: Int) = flow {
    println("Id in getUserDetails $id")
    // delay(2000)
    delay((6 - id) * 1000L)
    emit("Details fetched for $id")
}