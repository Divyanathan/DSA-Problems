package com.example.dsaproblems.leetCodeProblem.linkedLIst

fun main(){

    var head = Node(1)
    var next :Node? =  head
    for (i in 2..5){
        next?.next = Node(i)
        next = next?.next
    }
    val middle = findMiddleOfLinkedList(head)
    println("\n===========================\n  middle Node "+middle?.data)
    var reverse = reverseLinkedList(head)
    println("\n==========================\n reverse linked list ")
    while (reverse != null) {
        print(" ${reverse.data} ${if(reverse.next !=null) "->" else ""}")
        reverse= reverse.next
    }
    println("\n==========================\n")
}

fun findMiddleOfLinkedList(head: Node?): Node? {
    var slow = head
    var fast = head
    while (fast?.next != null ) {
        slow = slow?.next
        fast = fast?.next?.next
    }
    return slow
}


fun reverseLinkedList(head: Node?) : Node?{
    var current = head
    var node : Node?  = null
    while (current != null) {
        val temp = current.next
        current.next = node
        node = current
        current = temp
    }
    return node
}


data class Node(
    val data: Int,
) {
    var next: Node? = null
}