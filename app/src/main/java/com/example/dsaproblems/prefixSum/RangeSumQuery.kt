package com.example.dsaproblems.prefixSum

/**
 * 303. Range Sum Query - Immutable
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given an integer array nums, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 */
fun main(){
    println("Prefix Sum")
    val nums = intArrayOf(-2, 0, 3, -5, 2, -1)
    println("Given Array [${nums.joinToString()}]")
    prefixSum(nums)
    println("Prefix Sum [${nums.joinToString()}]")
    println("Range 0->2 =${findRange(0, 2, nums)}")
    println("Range 2->5 = ${findRange(2, 5, nums)}")
    println("Range 0->5 = ${findRange(0, 5, nums)}")
}
fun prefixSum(nums: IntArray){
    for (i in 1..<nums.size) {
        nums[i] += nums[i - 1]
    }
}

fun findRange(start: Int, end: Int, nums: IntArray): Int {
    return if (start == 0) {
        nums[end]
    } else {
        nums[end] - nums[start - 1]
    }
}