package com.example.dsaproblems.leetCodeProblem.linkedLIst

import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.Node
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.generateList
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.printNode

fun main(){

    println("\n============= RemoveElementFromLinkedList.kt ==============\n ")

    val list = generateList()
    list.printNode()
    println("\n Remove Element 3")
    var remove = removeElements(list,3)
   remove.printNode()
    println("\n===================================================\n")
}

fun removeElements(head: Node?, data: Int): Node? {
    var dummy : Node? = Node(0)
    dummy?.next = head
    var start : Node? = dummy

    while(dummy?.next!=null){
        while(dummy.next?.data == data){
            dummy.next = dummy.next?.next
        }
        dummy = dummy.next
    }
    return start?.next
}
