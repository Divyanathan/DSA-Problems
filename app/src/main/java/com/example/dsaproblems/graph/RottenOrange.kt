package com.example.dsaproblems.graph

import java.util.LinkedList
import java.util.Queue

fun main(){
    val graph :Array<IntArray> = arrayOf(
        intArrayOf(2,1,1),
        intArrayOf(1,1,0),
        intArrayOf(0,1,1)
    )

    orangesRotting(graph)

    val graph2 :Array<IntArray> = arrayOf(
        intArrayOf(0,2)
    )

    orangesRotting(graph2)

    val graph3 :Array<IntArray> = arrayOf(
        intArrayOf(2,1,1),
        intArrayOf(0,1,1),
        intArrayOf(1,0,1)
    )

    orangesRotting(graph3)
}

fun orangesRotting(grid: Array<IntArray>) {
    val queque : Queue<IntArray?> = LinkedList()
    for(i in 0..grid.size-1){
        for(j in 0..grid[0].size-1){
            if(grid[i][j] == 2){
                queque.add(
                    intArrayOf(i,j)
                )
                queque.add(null)
            }
        }
    }
    var day = 0
    while(!queque.isEmpty()){
        val indexArray = queque.remove()
        if(indexArray == null){
            if (!queque.isEmpty()) {
                queque.add(null)
                day++
            }
        }else{
            val i = indexArray[0]
            val j = indexArray[1]
            if ((i >= 0 && i < grid.size) && (j >= 0 && j < grid[0].size) || grid[i][j] == 2) {
                if (isFreshOrange(grid, i, j + 1)) {
                    grid[i][j + 1] = 2
                    queque.add(
                        intArrayOf(i, j + 1)
                    )
                }
                if (isFreshOrange(grid, i, j - 1)) {
                    grid[i][j - 1] = 2
                    queque.add(
                        intArrayOf(i, j - 1)
                    )
                }
                if (isFreshOrange(grid, i + 1, j)) {
                    grid[i + 1][j] = 2
                    queque.add(
                        intArrayOf(i + 1, j)
                    )
                }
                if (isFreshOrange(grid, i - 1, j)) {
                    grid[i-1][j] = 2
                    queque.add(
                        intArrayOf(i - 1, j)
                    )
                }
            }
        }
    }
    var isFreshOrangeStillAVailble = false
    for (i in 0..< grid.size) {
        for (j in 0..< grid[0].size - 1) {
            if (grid[i][j] == 1) {
                isFreshOrangeStillAVailble = true
                break
            }
        }
    }
    if (isFreshOrangeStillAVailble) {
        println("Fresh Orange is still available so -1")
    } else {
        println("Days taken = $day")
    }
}
fun isFreshOrange(graph: Array<IntArray>, i :Int, j:Int) :Boolean{
    return ((i >= 0 && i < graph.size) && (j >= 0 && j < graph[0].size) && graph[i][j] == 1)
}