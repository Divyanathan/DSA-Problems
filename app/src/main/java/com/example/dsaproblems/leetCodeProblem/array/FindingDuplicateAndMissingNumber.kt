package com.example.dsaproblems.leetCodeProblem.array

import kotlin.math.abs

fun main() {
    findingMissingAndRepeatedNumberByModifyingArray()
    findingMissingAndRepeatedNumberUsingSlowAndFastPointer()
}

/**
 * Modifying the array itself to find the missing and repeated number
 * Time complexity should be O(n) and space complexity should be O(1)
 */
fun findingMissingAndRepeatedNumberByModifyingArray(
    array: IntArray = intArrayOf(
        4, 2, 1, 2
    )
) {
    println("\n/**\n" +
            " * Modifying the array itself to find the missing and repeated number\n" +
            " * Time complexity should be O(n) and space complexity should be O(1)\n" +
            " */\n")
    println("========================================")
    println("Given Array\n ${array.joinToString()}")
    var missing = -1
    var repeated = -1
    for (num in array) {
        var i = abs(num) - 1
        if (array[i] < 0) {
            repeated = abs(array[i])
        } else {
            array[i] = -array[i]
        }

    }
    for (i in array.indices) {
        if (array[i] > 0) {
            missing = i + 1
            break
        }
    }
    println("Repeated Value: $repeated, Missing Value: $missing")
    println("========================================")
}

/**
 * Using slow and fast pointer approach to find the missing and repeated number
 *
 * Given an array of integers array containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in array, return this repeated number.
 *
 * * Time complexity should be O(n) and space complexity should be O(1)
 *
 * Note : You must solve the problem without modifying the array array and using only constant extra space.
 *
 */
fun findingMissingAndRepeatedNumberUsingSlowAndFastPointer(
    array: IntArray = intArrayOf(
        3, 2, 1, 2
    )
) {
    println("\n\n\n /**\n" +
            " * Using slow and fast pointer approach to find the missing and repeated number\n" +
            " *\n" +
            " * Given an array of integers array containing n + 1 integers where each integer is in the range [1, n] inclusive.\n" +
            " * There is only one repeated number in array, return this repeated number.\n" +
            " * \n" +
            " * * Time complexity should be O(n) and space complexity should be O(1)\n" +
            " *\n" +
            " * Note : You must solve the problem without modifying the array array and using only constant extra space.\n" +
            " *\n" +
            " */")
    println("========================================")
    println("Given Array\n ${array.joinToString()}")
    var slow = 0
    var fast = 0
    do {
        slow = array[slow]
        fast = array[array[fast]]
    } while (slow != fast)
    fast = 0
    while (slow != fast) {
        slow = array[slow]
        fast = array[fast]
    }
    val repeated = slow + 1

    val expectedSum = (array.size * (array.size + 1)) / 2
    val actualSum = array.sum()
    val missing = expectedSum - actualSum + repeated

    println("Repeated Value: $repeated, Missing Value: $missing")
    println("========================================")
}