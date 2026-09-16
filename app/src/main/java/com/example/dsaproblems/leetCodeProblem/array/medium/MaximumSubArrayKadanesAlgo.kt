package com.example.dsaproblems.leetCodeProblem.array.medium

/**
 * 53. Maximum Subarray
 * Kadane's Algorithm
 */
fun main(){
    println("/**\n" +
            " *  Always use Int.MIN_VALUE and Int.MAX_VALUE for Int type it will fail if you have only negative value intArrayOf(-2)\n" +
            " *  Try Avoiding initializing with 0\n" +
            " *  Try Avoiding the first index value array[0] it will Fail for intArrayOf(-2,1)\n" +
            " */\n")
    maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    maxSubArray(intArrayOf(-2))
    maxSubArray(intArrayOf(-2,1))
}

/**
 *  Always use Int.MIN_VALUE and Int.MAX_VALUE for Int type it will fail if you have only negative value intArrayOf(-2)
 *  Try Avoiding initializing with 0
 *  Try Avoiding the first index value array[0] it will Fail for intArrayOf(-2,1)
 */
fun maxSubArray(nums: IntArray) {
    var max = Int.MIN_VALUE //Always use Int.MIN_VALUE and Int.MAX_VALUE for Int type
//    var max = 0 //
    var subArraySum = 0
    for(num in nums){
        subArraySum +=num
        if(subArraySum>max){
            max = subArraySum
        }
        if(subArraySum<0){
            subArraySum = 0
        }
    }
    println("Given Array ${nums.joinToString()}")
    println("Max Sub Array Sum $max\n\n")
}