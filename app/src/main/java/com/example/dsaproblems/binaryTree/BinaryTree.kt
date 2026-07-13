package com.example.dsaproblems.binaryTree

import java.util.LinkedList
import java.util.Queue

data class Node(
    val data:Int,
    var left:Node? = null,
    var righ:Node? = null
)

fun main(){
    println("Binary Tree Implementation")
//    val array = intArrayOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1)
    val array = intArrayOf(5,1,-1,3,2,-1,-1,4,-1,-1,7,-1,-1)
    val root = buildTree(null,array)
    println("InOrder")
    inOrder(root)
    println()
    println("PreOrder")
    preOrder(root)
    println()
    println("Level order")

    val queue: Queue<Node?> = LinkedList()
    queue.add(root)
    queue.add(null)
    levelOrder(queue)
    println("Count of nodes = ${countOfNodes(root)}" )
    println("Sum  of nodes =  ${sumOfNodes(root)}" )
    println("Height  of nodes =  ${heightOfNodes(root)}" )
    println("Diameter O(NSquare)  of nodes =  ${diaMeterOfNode(root)}" )
    println("Diameter2 O(N) of nodes = ${diameter2(root).diameter}" )
}


var index = -1

fun buildTree(rootNode: Node?,  array: IntArray): Node? {
    var root = rootNode
    index++
    if (array[index] == -1) {
        return null
    }
    if (root == null) {
        root = Node(array[index])
    }
    root.left = buildTree(root.left,  array)
    root.righ = buildTree(root.righ,  array)
    return root
}

fun inOrder(root:Node?){
    if (root ==null)
        return
    inOrder(root.left)
    print("${root.data} ")
    inOrder(root.righ)
}

fun preOrder(root:Node?){
    if (root ==null)
        return
    print("${root.data} ")
    preOrder(root.left)
    preOrder(root.righ)
}

fun levelOrder(queue: Queue<Node?>){

    if (queue.isEmpty()){
        return
    }
    val root = queue.remove()
    if (root == null){
        println()
        if (queue.isNotEmpty()){
            queue.add(null)
        }
    } else {
        print("${root.data} ")
        root.left?.let {
            queue.add(it)
        }
        root.righ?.let {
            queue.add(it)
        }
    }
    levelOrder(queue)
}

fun countOfNodes(root: Node?): Int {
    if (root == null) {
        return 0
    }
    return countOfNodes(root.left) + countOfNodes(root.righ) + 1
}

fun sumOfNodes(root:Node?): Int {
    if (root == null){
        return 0
    }
    return sumOfNodes(root.left) + sumOfNodes(root.righ) + root.data
}

fun heightOfNodes(root :Node?) :Int {

    if (root == null){
        return 0
    }

    var leftheight = heightOfNodes(root.left)
    var rightHeitht = heightOfNodes(root.righ)

    return Math.max(leftheight,rightHeitht) + 1

}

fun diaMeterOfNode(root:Node?) : Int{
    if (root==null){
        return 0
    }
    var leffST = diaMeterOfNode(root.left)
    var righST = diaMeterOfNode(root.righ)
    var height = heightOfNodes(root.left) + heightOfNodes(root.righ) + 1
    return Math.max(Math.max(leffST,righST),height)
}


data class DiameterTree(
    val height : Int,
    val diameter : Int
)

fun diameter2(root:Node?): DiameterTree {

    if (root==null){
        return DiameterTree(0,0)
    }
    val lST = diameter2(root.left)
    val rST = diameter2(root.righ)
    val hightOfRoot = Math.max(lST.height , rST.height) + 1


    val diam1 = lST.diameter
    val dim2 = rST.diameter
    val dim3 = lST.height + rST.height + 1

    val diam =  Math.max(Math.max(diam1,dim2),dim3)
    return DiameterTree(
        hightOfRoot,
        diam
    )
}