package com.example.dsaproblems.leetCodeProblem

fun main(){

    val rows = 5
    val cols = 6
    val matrix = Array(rows){
        IntArray(cols)
    }
    var value = 1
    for (i in 0..<rows){
        for (j in 0..<cols){
            matrix[i][j] = value ++
            print(" ${matrix[i][j]}")
        }
        println()
    }
    println("Out put")
    spiralMatrix(matrix)

}

private fun spiralMatrix(matrix: Array<IntArray>){

    var rowBegin = 0
    var colBegin = 0
    var rowEnd = matrix.size -1
    var colEnd = matrix[0].size -1

    while (rowBegin <= rowEnd && colBegin<=colEnd){
        for (i in colBegin..colEnd){
            print(" ${matrix[rowBegin] [i]}")
        }
        rowBegin++

        println()
        for (i in rowBegin..rowEnd){
            print(" ${matrix[i][colEnd]}")
        }
        println()
        colEnd--


        for (i in colEnd downTo colBegin){
            print(" ${matrix[rowEnd][i]}")
        }
        rowEnd --
        println()

        for (i in rowEnd downTo rowBegin){
            print(" ${matrix[i][colBegin]}")
        }
        colBegin++
        println()
    }
}