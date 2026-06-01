package com.example.dsaproblems.leetCodeProblem.linkedLIst

import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.Node
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.generateList
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.printNode


fun main(){

    println("\n============= ReverseSubList.kt ==============\n ")
    val list = generateList(1,9)
    list.printNode()
    var reverseSublist  = reverseSublist(list,3,7)
    println(" reverseSublist 3,5")
    reverseSublist.printNode()
    println("\n===================================================\n")
}


internal fun reverseSublist(list: Node?, left :Int, right :Int): Node? {

    var dummy = Node(0)
    dummy.next = list
    var preNode: Node?  = dummy
    var currentNode = list

    for (i in 1..<left){
        preNode = preNode?.next
        currentNode = currentNode?.next
    }

    var subListHead = currentNode

    var node : Node? = null
    for (i in 0.. right-left){
        var temp = currentNode?.next
        currentNode?.next = node
        node = currentNode
        currentNode = temp
    }

    preNode?.next = node
    subListHead?.next = currentNode
    return dummy?.next
}