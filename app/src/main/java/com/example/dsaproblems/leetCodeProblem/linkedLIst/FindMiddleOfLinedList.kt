package com.example.dsaproblems.leetCodeProblem.linkedLIst

import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.Node
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.generateList
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.printNode

fun main() {

    println("\n=============Linked List ==============\n ")
    val list = generateList()
    list.printNode()
    val middle = findMiddleOfLinkedList(list)
    println(" middle Node is  ${middle?.data}")

    val list2 = generateList(1, 6)
    list2.printNode()
    val middle2 = findMiddleOfLinkedList(list2)
    println(" middle Node is  ${middle2?.data}")
    println("\n==========================\n")

}

internal fun findMiddleOfLinkedList(head: Node?): Node? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}
