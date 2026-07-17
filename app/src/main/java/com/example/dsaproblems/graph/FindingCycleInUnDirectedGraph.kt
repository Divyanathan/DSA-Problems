package com.example.dsaproblems.graph

fun main(){
    println("Finding Cycle In UnDirected Graph")
    val graph : MutableMap<Int,List<Int>> = mutableMapOf(
        0 to listOf(1,4),
        1 to listOf(0,5),
        2 to listOf(3,4,6),
        3 to listOf(2,6),
        4 to listOf(0,2),
        5 to listOf(1),
        6 to listOf(2,3)

    )
    println("Is Graph Cycle ${isGraphIsCycle(graph)}")
    graph[2] =  listOf(3,4)
    graph[6] = listOf(3)
    println("After removing Cycle 2->3 6->3 edges")
    println("Is Graph Cycle ${isGraphIsCycle(graph)}")
}

fun isGraphIsCycle(graph: Map<Int, List<Int>>): Boolean {
    val visited: HashSet<Int> = HashSet()
    for (vertex in graph.keys) {
        if (visited.contains(vertex).not()) {
            if (dfs(graph,visited,vertex,-1)){
                return true
            }
        }
    }
    return false
}

fun dfs(
    graph: Map<Int, List<Int>>,
    visited: HashSet<Int>,
    current: Int,
    parent: Int
): Boolean {
    if (visited.contains(current)) {
        return true
    }
    visited.add(current)
    for (vertex in graph[current]!!) {
        if (vertex != parent) {
            if (dfs(graph, visited, vertex, current)) {
                return true
            }
        }
    }
    return false
}