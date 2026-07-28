package com.example.dsaproblems.leetCodeProblem

/**
 * 56. Merge Intervals
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * Example 3:
 *
 * Input: intervals = [[4,7],[1,4]]
 * Output: [[1,7]]
 * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 */
fun main(){
    val array : Array<IntArray> = arrayOf(
        intArrayOf(15,18),
        intArrayOf(8,10),
        intArrayOf(1,3),
        intArrayOf(2,6),
    )
    println(array.joinToString{
        "[${it.joinToString()}]"
    })

    array.sortBy {
        it[0]
    }

    println(array.joinToString{
        "[${it.joinToString()}]"
    })
    val result  = mutableListOf<IntArray>()
    result.add(array[0])
    for (i in 1..<array.size){
        val current = array[i]
        val last = result.last()
        if (current[0] < last[1]){
            result.last()[1] = current[1]
        }else{
            result.add(array[i])
        }
    }

    println(
        result.joinToString {
            "[${it.joinToString()}]"
        }
    )
}