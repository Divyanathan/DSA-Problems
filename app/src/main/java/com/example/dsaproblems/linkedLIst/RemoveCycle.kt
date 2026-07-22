package com.example.dsaproblems.linkedLIst

import com.example.dsaproblems.linkedLIst.data.Node
import com.example.dsaproblems.linkedLIst.data.printCycleNode
import com.example.dsaproblems.linkedLIst.data.printNode

fun main(){
    val list = Node(1)
    var head : Node? = list
    var next : Node? = list
    next?.next = Node(2)
    next = next?.next
    var node3 = Node(3)
    next?.next = node3
    next = next?.next
    next?.next = Node(4)
    next = next?.next
    next?.next = Node(5)
    next = next?.next
    next?.next = node3
    println("\n============= RemoveCycle ==============\n ")
    println("Is Given List is cycle -> ${isCycle(head) !=null}\n")
    println("Since it's has cycle it will print as much as the count you give her i gave 15 but the length is only 5\n")
    head.printCycleNode(15)
    println()
    head = removeCycle(head)
    head.printNode()
    println()
    println("Is Given List is cycle ->  ${isCycle(head) !=null}")

    println("\n===================================================\n")
}

internal fun removeCycle(node: Node?): Node?{
    val head = node
    var slow : Node?  = isCycle(node)  ?: return null

    var fast : Node? = node
    var prevNode : Node? = null
    while (slow !=fast){
        prevNode = slow
        slow = slow?.next
        fast = fast?.next
    }
    prevNode?.next = null
    return head
}

internal fun isCycle(node : Node?) : Node?{
    var slow : Node? = node
    var fast : Node? = node
    while (fast!=null){
        slow = slow?.next
        fast = fast?.next?.next
        if (slow == fast){
            return slow
        }
    }
    return null
}