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
    println("Sliding Window ")
    val string = "abcabcbb"
//    val string = "pwwkew"
    println("Given String $string")
    println("Longest Substring Without Repeating Characters \"${lengthOfLongestSubstring(string)}\"")

}

fun lengthOfLongestSubstring(s: String): Int {
    var i = 0
    var j = 0
    var max = 0
    val hashSet:HashSet<Char> = HashSet()
    while(j<s.length){
        if(hashSet.contains(s[j])){
            hashSet.remove(s[i])
            i++
        }
        hashSet.add(s[j])
        j++
        max = Math.max(max, hashSet.size)
    }
    return max
}