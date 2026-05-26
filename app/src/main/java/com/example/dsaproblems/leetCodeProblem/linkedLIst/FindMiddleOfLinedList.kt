package com.example.dsaproblems.leetCodeProblem.linkedLIst

fun main(){



    println("\n=============Linked List ==============\n ")

    println("\n===========================\n  Reverse Sublist ")

    var reverseSublist  = reverseSublist(genenateList(),3,5)
    println(" reverseSublist 3,5")
    reverseSublist.printNode()

    var reverse = reverseLinkedList(genenateList())
    println("\n==========================\n reverse linked list ")
    reverse.printNode()

    val middle = findMiddleOfLinkedList(genenateList())
    println("\n===========================\n  middle Node  ${middle?.data}")

    println("\n==========================\n Remove Element 3")
    var remove = removeElements(genenateList(),3)
   remove.printNode()
    println("\n==========================\n")

}

fun genenateList() : Node?{
    var head :Node? = Node(1)
    var next :Node? =  head
    for (i in 2..7){
        next?.next = Node(i)
        next = next?.next
    }
    return head
}


fun reverseSublist(head: Node?,left :Int,right :Int): Node? {

    var dummy = Node(0)
    dummy.next = head
    var preNode: Node?  = dummy
    var currentNode = head

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
    subListHead?.next = currentNode

    return dummy?.next
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

fun removeElements(head: Node?, data: Int): Node? {
    var dummy :Node? = Node(0)
    dummy?.next = head
    var start :Node? = dummy

    while(dummy?.next!=null){
        while(dummy?.next?.data == data){
            dummy?.next = dummy?.next?.next
        }
        dummy = dummy?.next
    }
    return start?.next
}


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