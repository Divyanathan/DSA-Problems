package com.example.dsaproblems


    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        map[0] = 1

        var count = 0
        var sum = 0
        for (num in nums) {
            sum += num
            count += map[sum-k] ?: 0
            map[sum] = (map[sum] ?: 0) + 1
            println("$sum")
        }

        return count
    }

fun main(){
    println(subarraySum(intArrayOf(1,2,3,4,5,6,7,8),7))
}