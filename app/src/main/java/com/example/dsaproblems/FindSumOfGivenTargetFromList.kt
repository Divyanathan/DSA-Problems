package com.example.dsaproblems

import java.util.ArrayList

val arrayOfValues = intArrayOf(1,5,2,6,3,4)
val target = 4
var result = ArrayList<ArrayList<Int>>()

fun main(){
    println("without duplicate")
    combinationSumWithOutDuplicate(ArrayList(),0,0)
    for (combination in result){
       println(combination.toString())
    }

    println("with duplicate")
    result.clear()
    combinationSumWithDuplicate(ArrayList(),0)
    for (combination in result){
        println(combination.toString())
    }
}

fun combinationSumWithDuplicate(combination: ArrayList<Int>, sum: Int) {
    if (sum == target) {
        result.add(ArrayList(combination))
        return
    }
    if (sum > target) {
        return
    }
    for (i in arrayOfValues) {
        combination.add(i)
        combinationSumWithDuplicate(combination, sum + i)
        combination.remove(i)
    }
}


fun combinationSumWithOutDuplicate(current: MutableList<Int>, sum: Int, startIndex: Int) {
    // If the sum matches the target, add the current combination to the result
    if (sum == target) {
        result.add(ArrayList(current))
        return
    }

    // If the sum exceeds the target, stop further processing
    if (sum > target) return

    // Try adding each element starting from 'start' index to the current combination
    for (i in startIndex until arrayOfValues.size) {
        current.add(arrayOfValues[i])
        combinationSumWithOutDuplicate(current, sum + arrayOfValues[i], i + 1) // Move to the next index to avoid duplicates
        current.removeAt(current.size - 1) // backtrack
    }
}
