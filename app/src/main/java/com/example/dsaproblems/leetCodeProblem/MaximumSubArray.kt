package com.example.dsaproblems.leetCodeProblem

/**
 * 53. Maximum Subarray
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

fun main(){
    val array = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
//    val array = intArrayOf(1)
//    val array = intArrayOf(5,4,-1,7,8)
    println("Max sum N3 = ${`findMaximumSubArrayBruteForce-time-complexsity-N-Qube`(array)}")
    println("Max sum N2 = ${`findMaximumSubArrayBruteForce-time-complexsity-N-Sqaure`(array)}")
    println("Max sum N = ${`findMaximumSubArray-N-time`(array)}")
}

/**
 * this will take Big O(nQube)
 */
fun `findMaximumSubArrayBruteForce-time-complexsity-N-Qube`(array: IntArray) : Int {
    var maxSum = 0
    var sum = 0
    for (start in array.indices) {
        for (end in start ..<array.size) {
            for (i in start..end) {
                sum += array[i]
            }
            if (sum > maxSum) {
                maxSum = sum
            }
            sum = 0
        }
    }
    return maxSum
}

/**
 * this will take Big O(nSquare)
 */
fun `findMaximumSubArrayBruteForce-time-complexsity-N-Sqaure`(array: IntArray): Int {
    var maxSum = 0
    for (i in array.indices) {
        var currentSum = 0
        for (j in i..<array.size) {
            currentSum += array[j]
            if (currentSum > maxSum  ) {
                maxSum = currentSum
            }
        }
    }
    return maxSum
}

/**
 * This is kadane's algorithm which is O(n)
 */
fun `findMaximumSubArray-N-time`(array: IntArray): Int {
    var maxSum = 0
    var currentSum = 0
    for (i in array.indices) {
        currentSum += array[i]
        if (currentSum>maxSum){
            maxSum = currentSum
        }
        if (currentSum<0){
            currentSum = 0
        }
    }
    return maxSum
}





