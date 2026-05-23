package com.example.dsaproblems

import java.util.TreeSet

fun main(){
    println("Hi")

    val arrayList: ArrayList<Int> = arrayListOf(2,3,6,6,5)

    val treeSet : TreeSet<Int> = TreeSet()
    treeSet.addAll(arrayList)
    println(treeSet.elementAt(treeSet.size-2))
}