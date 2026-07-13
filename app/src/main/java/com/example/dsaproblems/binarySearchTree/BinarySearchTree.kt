

fun main(){
//    val array = intArrayOf(5,1,3,4,2,7)
//    val array = intArrayOf(4,5,6,2,1,3)
    val array = intArrayOf(8,5,10,11,14,3,6,1,4,7)
    var root : BSTNode? = null
    for (i in array){
        root = buildTree(root,i)
    }
    println("PreOrder")
    preOrder(root)
    println()
    println("InOrder")
    inOrder(root)
    println()
    println("PostOrder")
    postOrder(root)
    println()
    println("DescendingOrder")
    descendingOrder(root)
    println()
    println("Find Range 6 to 10")
    findRange(root,6,10)
    println()
    println("Root to leaf path")
    rootToLeafPath(root, arrayListOf())
    println()
    println("Delete BSTNode 3")
    root = deleteNode(root,3)
    println("After Deleting InOrder")
    inOrder(root)
    println()


}

private data class BSTNode(
    var data : Int,
    var leftNode : BSTNode? = null,
    var rightNode : BSTNode? = null
)

private fun buildTree (
    root : BSTNode?,
    data : Int
) : BSTNode {

    if (root == null){
        return  BSTNode(data)
    }

    if (data< root.data){
        root.leftNode = buildTree(root.leftNode,data)
    } else{
        root.rightNode = buildTree(root.rightNode,data)
    }

    return root
}


private fun preOrder(root:BSTNode?){
    if (root==null){
        return
    }
    print("${root.data} ")
    preOrder(root.leftNode)
    preOrder(root.rightNode)
}

private fun inOrder(root:BSTNode?){
    if (root==null){
        return
    }
    inOrder(root.leftNode)
    print("${root.data} ")
    inOrder(root.rightNode)
}

private fun postOrder(root:BSTNode?){
    if (root==null){
        return
    }
    postOrder(root.leftNode)
    postOrder(root.rightNode)
    print("${root.data} ")
}
private fun descendingOrder(root:BSTNode?){
    if (root==null){
        return
    }
    descendingOrder(root.rightNode)
    print("${root.data} ")
    descendingOrder(root.leftNode)
}


private fun deleteNode(root:BSTNode? , data:Int) : BSTNode?{

    if (root == null){
        return  null
    }

    if (data< root.data){
        root.leftNode = deleteNode(root.leftNode,data)
    } else if ( data > root.data){
        root.rightNode = deleteNode(root.rightNode,data)
    }else {
        //Root is equal to data
        //Case 1 leaf BSTNode
        if (root.leftNode == null && root.rightNode == null) {
            return null
        }

        //Case 2 root has one BSTNode
        if (root.leftNode == null) {
            return  root.rightNode
        } else if (root.rightNode == null) {
            return  root.leftNode
        } else {
            //Case 3 find inorder successor
            val iSNode = inOrderSuccessor(root.rightNode!!)

            root.data = iSNode.data
            root.rightNode = deleteNode(root.rightNode, iSNode.data)
        }
    }

    return root

}

private fun inOrderSuccessor(root:BSTNode) : BSTNode{
    var inOrderSuccessorNode : BSTNode = root
    while (true) {
        inOrderSuccessorNode.leftNode?.let {
            inOrderSuccessorNode = inOrderSuccessorNode.leftNode!!
        } ?: break
    }
    return inOrderSuccessorNode
}

private fun  findRange(root:BSTNode? , start:Int, end:Int ){

    if (root==null){
        return
    }

    if (root.data in start..end){

        findRange(root.leftNode,start,end)
        print("${root.data} ")
        findRange(root.rightNode,start,end)

    } else if (start >= root.data){
        //find right subtree
        findRange(root.rightNode,start,end)

    }else{
        //find left subtree
        findRange(root.leftNode,start,end)
    }
}

private fun rootToLeafPath(root: BSTNode?, list: ArrayList<Int>) {
    if (root == null) {
        return
    }

    list.add(root.data)
    if (root.leftNode == null && root.rightNode == null) {
        println(list)
    } else {
        rootToLeafPath(root.leftNode, list)
        rootToLeafPath(root.rightNode, list)
    }
    list.removeAt(list.size - 1)
}