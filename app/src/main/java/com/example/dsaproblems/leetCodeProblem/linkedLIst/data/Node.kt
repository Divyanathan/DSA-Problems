package com.example.dsaproblems.leetCodeProblem.linkedLIst.data

internal data class Node(
    val data: Int,
) {
    var next: Node? = null
}

internal fun Node?.printNode() {
    var thisNode = this
    while (thisNode != null) {
        print(" ${thisNode.data} ${if (thisNode.next != null) "->" else ""}")
        thisNode = thisNode.next
    }
    println()
}

internal fun generateList(start:Int =1, end:Int = 5) : Node?{
    var head : Node? = Node(0)
    var next : Node? =  head
    for (i in start..end){
        next?.next  = Node(i)
        next = next?.next
    }
    return head?.next
}

internal fun generateLinkedList(list: IntArray = intArrayOf(1,2,3,4,5)) :Node?{
    val head = Node(0)
    var next :Node? = head
    for (i in list){
        next?.next = Node(i)
        next = next?.next
    }
    return head.next
}

internal fun generateListInReverse(list :Node?,start:Int =3, end:Int = 1) : Node?{
    val head = list
    var next : Node? = head
    while (next!=null){
        if (next?.next ==null)
            break
        next = next?.next
    }
    for (i in start downTo end) {
        next?.next = Node(i)
        next = next?.next
    }
    return head
}

internal fun Node?.printCycleNode(count :Int) {
    var thisNode = this
    var i = 1
    while (i<=count) {
        print(" ${thisNode?.data} ${if (thisNode?.next != null) "->" else ""}")
        thisNode = thisNode?.next
        i++
    }
    println()
}