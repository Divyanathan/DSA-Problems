package com.example.dsaproblems.graph

import java.util.HashMap
import java.util.Stack

fun main(){
    println("Topological Sort")
    val graph : HashMap<Int, List<Int>> = linkedMapOf(
        4 to listOf(1,0),
        5 to listOf(2,0),
        0 to listOf(),
        1 to listOf(),
        2 to listOf(3),
        3 to listOf(1)
    )
    topologicalSort(graph)
}

/**
 * TopologicalSort Can be performed only on non-cyclic Directed Graph
 */
fun topologicalSort(graph : Map<Int,List<Int>>){
    val visited : HashSet<Int> = HashSet()
    val stackVertex : Stack<Int> = Stack()
    for (vertex in graph.keys){
        if (visited.contains(vertex).not())
            dfsTropo(graph,vertex,visited,stackVertex)
    }
    while (stackVertex.isNotEmpty()){
        print("${stackVertex.pop()} ")
    }
}

fun dfsTropo(
    graph: Map<Int, List<Int>>,
    current: Int,
    visited: HashSet<Int>,
    stackVertex: Stack<Int>
)  {
    if (visited.contains(current)){
        return
    }
    visited.add(current)
    for (vertex in graph[current]!!){
        dfsTropo(graph,vertex,visited,stackVertex)
    }
    stackVertex.push(current)
}
