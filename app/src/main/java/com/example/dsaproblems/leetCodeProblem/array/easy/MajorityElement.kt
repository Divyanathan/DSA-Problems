package com.example.dsaproblems.leetCodeProblem.array.easy

/**
 *169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
fun main(){
    println(findMajorityElement(
//        intArrayOf(2, 2, 1, 1, 1, 2, 2)
        intArrayOf(3, 3, 2, 2, 2, 3, 3, 1)
    ))
}


fun findMajorityElement(array:IntArray) : Int {
    var majority = 0
    var count = 0
    for (num in array){
        if(count == 0){
            majority = num
        }
        if (majority == num){
            count++
        }else{
            count --
        }
    }
    return majority
}