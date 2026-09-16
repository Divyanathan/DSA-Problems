package com.example.dsaproblems.leetCodeProblem.array

/**
 * 136. Single Number
 * Easy
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
fun main(){
//    val array = intArrayOf(2,2,1)
    val array = intArrayOf(4,1,2,2,1)
    var ans = 0
    for(num in array){
        ans = ans xor num
    }
    println("Given Array  ${array.joinToString()}\n")
    println("Single Number $ans")
}