package com.example.dsaproblems.leetCodeProblem.array.easy

fun main() {
    mergingTwoSortedArray(
        arrayOf(1, 4, 7, 8),
        arrayOf(5)
    )

    mergingTwoSortedArray(
        arrayOf(4),
        arrayOf(2, 3, 5, 6, 9)
    )
}

fun mergingTwoSortedArray(arr1: Array<Int>, arr2: Array<Int>) {

    println(
        "\n\nGiven Array \n" +
                "Array 1 {${arr1.joinToString()}}\n" +
                "Array 2 {${arr2.joinToString()}}"
    )

    val mergedArray = IntArray(arr1.size + arr2.size) { 0 }
    var i = 0
    var j = 0
    var k = 0
    while (i < arr1.size && j < arr2.size) {
        if (arr1[i] < arr2[j]) {
            mergedArray[k++] = arr1[i]
            i++
        } else {
            mergedArray[k++] = arr2[j]
            j++
        }
    }

    while (i < arr1.size) {
        mergedArray[k++] = arr1[i]
        i++
    }

    while (j < arr2.size) {
        mergedArray[k++] = arr2[j]
        j++
    }
    println(
        "Merged Array  {${mergedArray.joinToString()}}"
    )

}