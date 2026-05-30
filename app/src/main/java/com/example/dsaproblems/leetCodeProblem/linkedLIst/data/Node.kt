package com.example.dsaproblems.leetCodeProblem.linkedLIst.data

data class Node(
    val data: Int,
) {
    var next: Node? = null
}

fun Node?.printNode() {
    var thisNode = this
    while (thisNode != null) {
        print(" ${thisNode.data} ${if (thisNode.next != null) "->" else ""}")
        thisNode = thisNode.next
    }
    println()
}

fun generateList(start:Int =1, end:Int = 5) : Node?{
    var head : Node? = Node(0)
    var next : Node? =  head
    for (i in start..end){
        next?.next  = Node(i)
        next = next?.next
    }
    return head?.next
}