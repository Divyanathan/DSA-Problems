package com.example.dsaproblems.leetCodeProblem

fun main(){
    val rows = 3
    val column = 3
    val matrix = Array(rows){
        IntArray(column)
    }
    var value = 9
    for (i in 0..<rows){
        for (j in 0..<column){
            matrix[i][j] = value --
        }
    }

    for (i in 0..<rows){
        for (j in 0..<column){
            print( "${matrix[i][j] } ")
        }
        println()
    }
    println()
    var temp = 0
    for (i in 0..<rows) {
        for (j in 0..<column) {
            for (k in 0..<rows) {
                for (l in 0..<column){
                    if (matrix[i][j] < matrix[k][l]){
                        temp = matrix[i][j]
                        matrix[i][j] = matrix[k][l]
                        matrix[k][l] = temp
                    }
                }
            }
        }
    }

    for (i in 0..<rows){
        for (j in 0..<column){
            print( "${matrix[i][j] } ")
        }
        println()
    }

}