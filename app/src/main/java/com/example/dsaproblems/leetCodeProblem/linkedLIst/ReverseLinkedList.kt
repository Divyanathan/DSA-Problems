package com.example.dsaproblems.leetCodeProblem.linkedLIst

import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.Node
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.generateList
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.printNode


fun main(){

    println("\n============= ReverseLinkedList.kt ==============\n ")
    val list = generateList()
    list.printNode()
    println(" reverse linked list ")
    var reverse = reverseLinkedList(list)
    reverse.printNode()
    println("\n===================================================\n")
}


internal fun reverseLinkedList(list: Node?) : Node?{
    var current = list
    var node : Node?  = null
    while (current != null) {
        val temp = current.next
        current.next = node
        node = current
        current = temp
    }
    return node
}
