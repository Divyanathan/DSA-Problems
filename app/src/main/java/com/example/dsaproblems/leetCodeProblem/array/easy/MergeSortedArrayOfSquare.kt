package com.example.dsaproblems.leetCodeProblem.array.easy

fun main(){
    sortedSquares(
        arrayOf(-10,-5, 4, 7, 8)
    )
}

fun sortedSquares(arr1: Array<Int>) {

    println(
        "\n\nGiven Array \n" +
                "Array 1 {${arr1.joinToString()}}\n"
    )
    var i =0
    var j = arr1.lastIndex
    val sortedArray = IntArray(arr1.size) { 0 }
    for (index in arr1.lastIndex downTo 0) {
        val left = arr1[i] * arr1[i]
        val right = arr1[j] * arr1[j]

        if (left > right){
            sortedArray[index] = left
            i++
        }else{
            sortedArray[index] = right
            j--
        }
    }
    println(
        "Sorted Square Array ${sortedArray.joinToString()}"
    )
}