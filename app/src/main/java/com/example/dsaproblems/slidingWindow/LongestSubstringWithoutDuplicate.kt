package com.example.dsaproblems.slidingWindow


/**
 * Longest Substring Without Repeating Characters
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

fun main(){
    println("Hi")
//    val string = "abcabcbb"
    val string = "pwwkew"
    val hashSet : ArrayList<Char> = ArrayList()
    var i=0
    var j=0
    var max = 0

    while (i < string.length - 1 && j<string.length) {
        if (hashSet.contains(string[j]).not()){
            hashSet.add(string[j])
            j +=1
        }else{
            hashSet.removeAt(0)
            i+=1
        }
        if (hashSet.size>max) {
            max = hashSet.size
            println(hashSet)
        }
    }

    println(max)

}