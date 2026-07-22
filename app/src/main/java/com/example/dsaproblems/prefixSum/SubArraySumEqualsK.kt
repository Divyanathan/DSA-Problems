package com.example.dsaproblems.prefixSum

/**
 * 560. Subarray Sum Equals K
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
fun main() {
    println("Sub Array SumEquals K\n")
    val array = intArrayOf(
        1, 1, 1
    )
   subarraySum(array, 2)
    val array2 = intArrayOf(
        1, 2, 3
    )
    subarraySum(array2, 3)
    val array3 = intArrayOf(
        2, 3, -5, 5, -5, 1, 4
    )
    subarraySum(array3, 5)
}

fun subarraySum(nums: IntArray, target: Int) {
    var count = 0
    val freMap : HashMap<Int,Int> = HashMap()
    val prefixSum : ArrayList<Int> = ArrayList()
    var sum = 0
    for(num in nums){
        sum +=num
        prefixSum.add(sum)
        if(freMap.contains(sum)){
            freMap[sum] = freMap[sum]!!+1
        }else {
            freMap[sum] = 1
        }
        if(sum==target){
            count++
        }
        if(freMap.contains(sum-target)){
            count += freMap[sum-target]!!
        }
    }
    println("Given Array")
    println("[${nums.joinToString()}]")
    println("Prefix Sum $prefixSum")
    println("Frequency Map $freMap")
    println("Answer Given for Target \"$target\" = $count")
    println()
}