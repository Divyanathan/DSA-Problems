package com.example.dsaproblems.leetCodeProblem

fun main(){

    val arr = intArrayOf(-4,-1,0,3,10)
    val result = sortedSquares(arr)
    println(result.contentToString())

}

fun sortedSquares(nums: IntArray): IntArray {

    val result = IntArray(nums.size)
    var h= 0
    var t= nums.size-1

    for(i in nums.size-1 downTo 0 ){
        if(Math.abs(nums[h]) > Math.abs(nums[t])){
            result[i] = nums[h] * nums[h]
            h++
        } else {
            result[i] = nums[t] * nums[t]
            t--
        }
    }
    return result

}