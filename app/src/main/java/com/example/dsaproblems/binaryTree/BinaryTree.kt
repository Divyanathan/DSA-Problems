package com.example.dsaproblems.binaryTree


fun main(){

    val lBinaryTree = BinaryTree()
    val rootNode = lBinaryTree.buildTree()
    lBinaryTree.preOrderTravers(rootNode)
    println()
    lBinaryTree.inOrderTravers(rootNode)
    println()
    lBinaryTree.postOrderTravers(rootNode)

}

class Node(val data:Int, var leftNode: Node? = null, var rightNode: Node?=null)


class BinaryTree{
    private val nodes = intArrayOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1)
    private var idx  = -1

    fun buildTree(): Node?{
        idx++
        if (nodes[idx] == -1 ){
            return null
        }
        val newNode = Node(nodes[idx])
        newNode.leftNode = buildTree()
        newNode.rightNode = buildTree()
        return newNode
    }

    fun preOrderTravers(root: Node?){
        if (root==null){
//            print("-1")
            return
        }
        print(" "+root.data)
        preOrderTravers(root.leftNode)
        preOrderTravers(root.rightNode)
    }

    fun inOrderTravers(node: Node?){
        if (node == null){
            return
        }
        inOrderTravers(node.leftNode)
        print(" "+ node.data)
        inOrderTravers(node.rightNode)
    }

    fun postOrderTravers(node: Node?){
        if (node==null){
            return
        }
        postOrderTravers(node.leftNode)
        postOrderTravers(node.rightNode)
        print(" "+node.data)
    }


}
