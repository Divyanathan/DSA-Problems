package com.example.dsaproblems.linkedLIst

import com.example.dsaproblems.linkedLIst.data.Node
import com.example.dsaproblems.linkedLIst.data.generateList
import com.example.dsaproblems.linkedLIst.data.generateListInReverse
import com.example.dsaproblems.linkedLIst.data.printNode

fun main(){

    println("\n=============  GivenListIsPalindrome  ==============\n ")
    var list1 = generateList(1,3)
    list1 = generateListInReverse(list1,3,1)

    println("list1 with with size Even number ")
    list1.printNode()
    println("is Palindrome ${findPalindrome(list1)}")

    var list2 = generateList(1,3)
    list2 = generateListInReverse(list2,2,1)

    println("\n\nlist2 size Odd number ")
    list2.printNode()
    println("is Palindrome ${findPalindrome(list2)}")

    var list3 = generateList(1,5)

    println("\n\nlist3 Not palindrome ")
    list3.printNode()
    println("is Palindrome ${findPalindrome(list3)}")
    println("\n==========================\n")

}

internal fun findPalindrome(list: Node?): Boolean {

    var fast: Node? = list
    var slow: Node? = list
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    var reverseNode: Node? = null
    fast = list

    while (slow != null) {
        val temp = slow.next
        slow.next = reverseNode
        reverseNode = slow
        slow = temp
    }

    while (reverseNode != null) {
        if (fast?.data == reverseNode.data) {
            fast = fast.next
            reverseNode = reverseNode.next
        } else {
            return false
        }
    }

    return true
}
