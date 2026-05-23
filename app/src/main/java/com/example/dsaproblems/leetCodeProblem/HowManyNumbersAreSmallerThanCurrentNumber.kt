package com.example.dsaproblems.leetCodeProblem

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 *
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 *
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
fun main() {

    val arr = intArrayOf(8, 1, 2, 2, 3)
    val result = smallerNumbersThanCurrent(arr)
    println(result.contentToString())
}

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val array = IntArray(50)
    for (num in nums) {
        array[num]++
    }

    for (i in 1..<array.size) {
        array[i] = array[i - 1] + array[i]
    }

    val result = IntArray(nums.size)
    for (i in nums.indices) {
        result[i] = array[nums[i] - 1]
    }
    return result

}