package com.example.dsaproblems.heap

fun main(){
    println("Welcome to \"Heap\" Data structure")
    val list = mutableListOf(8,6,3,10,4,9)
    val maxHeap = buildMaxHeapByCreatingNewList(list)
    println("Max Heap HeapifyUP = $maxHeap")
    println("Max Heap HeapifyDown = ${buildMaxWithExistingList(list)}")
    println("Delete Heap")
    deleteHeap(maxHeap)
}



fun buildMaxHeapByCreatingNewList(list:MutableList<Int>) : MutableList<Int>{
    val maxHeap = mutableListOf<Int>()

    for (index in list.indices){
        maxHeap.add(list[index])
        heapifyUp(maxHeap,index)
    }
    return maxHeap
}

fun heapifyUp(heapList: MutableList<Int>, index : Int) {
    var childIndex = index
    while (childIndex>0){
        val parentIndex = (childIndex-1)/2
        if (heapList[childIndex] < heapList[parentIndex]){
            break
        }
        heapList.swap(childIndex,parentIndex)
        childIndex = parentIndex
    }
}

fun MutableList<Int>.swap(child:Int,parent:Int){
    if (this[child] > this[parent]){
        val temp = this[child]
        this[child] = this[parent]
        this[parent] = temp
    }
}

fun buildMaxWithExistingList(list: MutableList<Int>) : List<Int> {
    var parent = (list.size - 1) / 2
    for (i in parent downTo 0){
        heapiFyDown(list,i)
    }
    return list
}

fun heapiFyDown(list: MutableList<Int>,index : Int) {

    var parent = index
    while (true) {
        var leftChild = parent * 2 + 1
        var rightChild = parent * 2 + 2
        var largest = parent
        if (leftChild < list.size && list[largest] < list[leftChild]) {
            largest = leftChild
        }
        if (rightChild < list.size && list[largest] < list[rightChild]) {
            largest = rightChild
        }

        if (parent == largest){
            break
        }

        list.swap(largest,parent)
        parent = largest
    }
}

fun deleteHeap(list:MutableList<Int>){
    while (list.isNotEmpty()) {
        print("${list[0]} ")
        if (list.size==0)
            break
        list.swap(0, list.size - 1)
        list.removeAt(list.size - 1)
        heapiFyDown(list,0)
    }
}

