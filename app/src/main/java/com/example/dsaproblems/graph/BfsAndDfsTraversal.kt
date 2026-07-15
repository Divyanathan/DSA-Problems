package com.example.dsaproblems.graph

import java.util.LinkedList
import java.util.Queue


/**
 *
 * Map representation
 1 ---  3
/      |  \
0      |   5 -- 6
\      |  /
 2 ---- 4
*/



fun main(){
    println("Welcome to Graph\n")
    val graph : HashMap<Int,List<Int>> = HashMap()
    graph[0] = listOf(1,2)
    graph[1] = listOf(0,3)
    graph[2] = listOf(0,4)
    graph[3] = listOf(1,4,5)
    graph[4] = listOf(2,3,5)
    graph[5] = listOf(3,4,6)
    graph[6] = listOf(5)
    val visitedSet : HashSet<Int> = HashSet()
    val queue : Queue<Int> = LinkedList()
    queue.add(0)
    println("BFS Recursive")
    bfsTraversal(graph,queue,visitedSet)
    println("\n\nBFS Loop")
    visitedSet.clear()
    bsf2(graph)
    visitedSet.clear()
    println("\n\n DFS traversal ")
    dfsTraversal(graph,visitedSet,0)
    println("\n\nFind All Path")
    visitedSet.clear()
    findAllPath(graph,visitedSet,0,5, mutableListOf(0))

}

fun bfsTraversal(graph: HashMap<Int, List<Int>>, queue: Queue<Int>, visitedVertex: HashSet<Int>) {
    if (queue.isEmpty()) {
        return
    }
    val vertex = queue.remove()
    if (!visitedVertex.contains(vertex)) {
        print(" $vertex -->")
        visitedVertex.add(vertex)

        for (nexVertex in graph[vertex]!!) {
            if (!visitedVertex.contains(nexVertex)) {
                queue.add(nexVertex)
            }
        }
    }
    bfsTraversal(graph, queue, visitedVertex)

}


fun bsf2(graph: HashMap<Int, List<Int>>){
    val visitedSet : HashSet<Int> = HashSet()
    val queue : Queue<Int> = LinkedList()
    queue.add(0)
    while (queue.isNotEmpty()){
        val vertex = queue.remove()
        if (visitedSet.contains(vertex).not()) {
            print("$vertex ->")
            visitedSet.add(vertex)
            for (nextEdge in graph[vertex]!!) {
                queue.add(nextEdge)
            }
        }
    }
}

fun dfsTraversal(graph:Map<Int,List<Int>>, visitedSet: HashSet<Int>, vertex :Int){
    if (visitedSet.contains(vertex)){
        return
    }
    print("$vertex ->")
    visitedSet.add(vertex)
    for (edge in graph[vertex]!!){
        dfsTraversal(graph,visitedSet,edge)
    }
}

fun findAllPath(
    graph: Map<Int, List<Int>>,
    visitedSet: HashSet<Int>,
    current: Int,
    target: Int,
    path: MutableList<Int>
) {
    if (current == target) {
        println(path)
        return
    }
    for (edge in graph[current]!!) {
        if (visitedSet.contains(edge).not()) {
            visitedSet.add(current)
            path.add(edge)
            findAllPath(graph, visitedSet,edge,target,path)
            path.removeAt(path.size-1)
            visitedSet.remove(current)
        }
    }
}

