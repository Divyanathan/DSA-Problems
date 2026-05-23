package com.example.dsaproblems.leetCodeProblem

/**1. Two Sum
Easy
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.


You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?*/

fun main() {
    val arr = intArrayOf(2,7,11,15)
    val target = 18
    var res = twoSumBruteForce(arr, target)
    println(" ${res[0]} ${res[1]}")
//    res = twoSum(arr, target)
//    println(" ${res[0]} ${res[1]}")
}

/**
 * This will take only O(n) time complexity
 */
private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int,Int>()
    for (i in nums.indices){
        if (map.containsKey(target - nums[i])){
            return intArrayOf(map[target - nums[i]]!!,i)
        }
        else{
            map[nums[i]] = i
        }
    }
    return intArrayOf()
}

/**
This is a brute force approach.
time complexity is O(n^2)
 */
private fun twoSumBruteForce(nums: IntArray, target: Int): IntArray{
    for (i in nums.indices){
        for (j in 1..<nums.size){
            if (nums[i] + nums[j] == target){
                return intArrayOf(i,j)
            }
        }
    }
    return intArrayOf()
}