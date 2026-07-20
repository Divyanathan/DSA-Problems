package com.example.dsaproblems.leetCodeProblem

fun main(){

    val arr = intArrayOf(-4,-1,0,3,10)
    val result = sortedSquares(arr)
    println("Given Sorted Array ")
    println(arr.contentToString())
    println("Square sorted")
    println(result.contentToString())

}

fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var head= 0
    var tail= nums.size-1

    for(i in nums.size-1 downTo 0 ){
        if(Math.abs(nums[head]) > Math.abs(nums[tail])){
            result[i] = nums[head] * nums[head]
            head++
        } else {
            result[i] = nums[tail] * nums[tail]
            tail--
        }
    }
    return result

}