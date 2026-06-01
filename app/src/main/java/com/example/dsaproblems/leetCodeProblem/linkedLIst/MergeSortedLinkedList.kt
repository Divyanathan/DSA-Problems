package com.example.dsaproblems.leetCodeProblem.linkedLIst

import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.Node
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.generateList
import com.example.dsaproblems.leetCodeProblem.linkedLIst.data.printNode


fun main() {
    println("\n============= MergeSortedLinkedList ==============\n ")
    val list1 = generateList(6, 9)
    val list2 = generateList(1, 4)
    print("List 1  ")
    list1.printNode()
    print("List 2  ")
    list2.printNode()
    val sList = mergeSortedLinkedList(list1, list2)
    print("sorted List")
    sList?.printNode()
    println("\n===================================================\n")
}

internal fun mergeSortedLinkedList(list1: Node?, list2: Node?): Node? {
    val dummy = Node(0)
    var head: Node? = dummy
    var linkedList1 = list1
    var linkedList2 = list2
    while (linkedList1 != null || linkedList2 != null) {
        if (linkedList1 == null) {
            head?.next = linkedList2
            linkedList2 = linkedList2?.next
        }
        if (linkedList2 == null) {
            head?.next = linkedList1
            linkedList1 = linkedList1?.next
        }
        if (linkedList1 != null && linkedList2 != null) {
            if (linkedList1.data < linkedList2.data) {
                head?.next = linkedList1
                linkedList1 = linkedList1.next
            } else {
                head?.next = linkedList2
                linkedList2 = linkedList2.next
            }
        }
        head = head?.next
    }
    return dummy.next
}
