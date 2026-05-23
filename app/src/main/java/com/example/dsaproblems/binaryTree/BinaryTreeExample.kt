package com.example.dsaproblems.binaryTree

fun main(){

}

data class Nodes(val data:Int?, var left: Nodes?=null, var right: Nodes?=null)

class BinaryTreeExample {
    val nodes = intArrayOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1)
        var idx = -1

    fun buildTrees(): Nodes?{
        idx++
        if (nodes[idx] == -1){
            return null
        }
        val newNode = Nodes(nodes[idx])
        newNode.left = buildTrees()
        newNode.right = buildTrees()
        return newNode

    }

    fun preOrderTravers(root: Nodes?){
        if (root?.data == null){
            return
        }
        preOrderTravers(root.left)
        preOrderTravers(root.right)

    }
}