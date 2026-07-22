
package com.example.dsaproblems.linkedLIst

import com.example.dsaproblems.linkedLIst.data.Node
import com.example.dsaproblems.linkedLIst.data.generateList
import com.example.dsaproblems.linkedLIst.data.printNode

/**
 * 25. Reverse Nodes in k-Group
 * Hard
 * Topics
 * premium lock icon
 * Companies
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 *
 * Example 2:
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */


fun main(){
    val head = generateList(1,6)
    println("Given List")
    head.printNode()
    val group = 2
    val reversList = reverse(head,2)
    println("Reverse List group \"$group\"" )

    reversList.printNode()

}

internal fun reverse(headNode: Node?, count: Int): Node? {
    val dummy = Node(0)
    dummy.next = headNode
    var prev: Node? = dummy
    var head: Node? = dummy.next
    var next: Node? = dummy.next
    var i = 1
    var node: Node? = null
    while (next != null) {
        val temp = next.next
        next.next = node
        node = next
        next = temp
        if (i % count == 0) {
            prev?.next = node
            head?.next = next
            node = null
            prev = head
            head = next
        }
        if (next != null)
            i++
    }
    if (i % count != 0) {
        node.printNode()
        prev?.next = node
    }

    return dummy.next

}