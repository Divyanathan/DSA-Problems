package com.example.dsaproblems.graph

import java.util.PriorityQueue


data class Edge(
    val source: Int,
    val destination: Int,
    val weight: Int
)

var mShortestPath = Int.MAX_VALUE
var mShortestPathList :ArrayList<Int> = ArrayList()


data class ShortestPath(
    var weight: Int = Int.MAX_VALUE,
    val path: MutableList<Int> = mutableListOf()
)


data class ShortestDistance(
    val vertex: Int,
    var weight: Int = Int.MAX_VALUE
)


fun main() {
    println("Finding Shortest path in Graph\n\n")

    val unDirectedGraph: HashMap<Int, List<Edge>> = HashMap()
    unDirectedGraph[0] = listOf(
        Edge(0, 1, 2),
        Edge(0, 2, 4)
    )
    unDirectedGraph[1] = listOf(
        Edge(1, 0, 2),
        Edge(1, 3, 7)
    )
    unDirectedGraph[2] = listOf(
        Edge(2, 0, 4),
        Edge(2, 4, 3)
    )
    unDirectedGraph[3] = listOf(
        Edge(3, 1, 7),
        Edge(3, 4, 4),
        Edge(3, 5, 1)
    )
    unDirectedGraph[4] = listOf(
        Edge(4, 2, 3),
        Edge(4, 3, 2),
        Edge(4, 5, 5)
    )
    unDirectedGraph[5] = listOf(
        Edge(5, 3, 1),
        Edge(5, 4, 5),
        Edge(5, 6, 3)
    )
    unDirectedGraph[6] = listOf(
        Edge(6, 5, 3),
    )
    val source = 0
    val target = 6

    val visitedEdge: HashSet<Int> = HashSet()

    findSmallestPathBrutForce(unDirectedGraph,visitedEdge,source,target, mutableListOf(0), mutableListOf())
    println("Shortest paht Using Global variable" +
            "\n Distance $mShortestPath  Shortest List $mShortestPathList")

    val  shortestPath = findSmallestPathBrutForce(
        unDirectedGraph,
        visitedEdge,
        source,
        target,
        mutableListOf(source),
        mutableListOf(),
        ShortestPath()
    )
    println()
    println("Shortest path using ShortestPath class\n $shortestPath")

    val directedGraph: HashMap<Int, List<Edge>> = HashMap()
    directedGraph[0] = listOf(
        Edge(0, 1, 2),
        Edge(0, 2, 4)
    )
    directedGraph[1] = listOf(
        Edge(1, 2, 1),
        Edge(1, 3, 7)
    )
    directedGraph[2] = listOf(
        Edge(2, 4, 3)
    )
    directedGraph[3] = listOf(
        Edge(3, 5, 1)
    )
    directedGraph[4] = listOf(
        Edge(4, 3, 2),
        Edge(4, 5, 5)
    )
    directedGraph[5] = listOf()
    println()
    println("Shortest path using Dijkstra Algo UnDirected graph from Source 0 ")
    dijkstraAlgoForFindingShortestPath(unDirectedGraph)

    println()
    println("Shortest path using Dijkstra Algo Directed graph from Source 0 ")
    dijkstraAlgoForFindingShortestPath(directedGraph)

    println()
    println("Shortest path using Dijkstra Algo UnDirected graph from Source 3 ")
    dijkstraAlgoForFindingShortestPath(unDirectedGraph,3)

    println()
    println("Shortest path using Dijkstra Algo Directed graph from Source 1 ")
    dijkstraAlgoForFindingShortestPath(directedGraph,1)
    println("If Any vertex has Int.MAX_VALUE then it's not reachable")
}


fun dijkstraAlgoForFindingShortestPath(
    graph2 : HashMap<Int,List<Edge>>,
    source: Int = 0
) {
    val priorityQueue: PriorityQueue<ShortestDistance> = PriorityQueue(
        compareByDescending {
            it.weight
        }
    )


    val distance : HashMap<Int,Int> = HashMap()
    for (vertex in graph2.keys) {
        distance[vertex] = Int.MAX_VALUE
    }
    distance[source] = 0
    val visited: HashSet<Int> = HashSet()
    priorityQueue.add(
        ShortestDistance(
            source,
            0
        )
    )
    while (priorityQueue.isNotEmpty()) {
//        println("Priority Queue $priorityQueue")
        val current = priorityQueue.remove()
        if (visited.contains(current.vertex).not()) {
            for (edge in graph2[current.vertex]!!) {
                val v = distance[edge.destination]
                val u = distance[current.vertex]!! + edge.weight
                if (u < v!!) {
                    distance[edge.destination] = u
                    priorityQueue.add(ShortestDistance(edge.destination, u))
                } else if (u != v) {
                    distance[edge.destination] = v
                    priorityQueue.add(ShortestDistance(edge.destination, v))
                }
            }
        }
        visited.add(current.vertex)
    }

    println("Distance $distance")
}



/**
 * Finding Shortest by using Global variable
 */
fun findSmallestPathBrutForce(
    graph: HashMap<Int, List<Edge>>,
    visitedEdgs: HashSet<Int>,
    current: Int,
    taget: Int,
    path: MutableList<Int>,
    weight: MutableList<Int>,
) {
    if (current == taget){
        val pathLengh = weight.sum()
        if (pathLengh < mShortestPath){
            mShortestPath = pathLengh
            mShortestPathList.clear()
            mShortestPathList.addAll(path)
        }
        return
    }
    if (visitedEdgs.contains(current).not()) {
        for (edge in graph[current]!!) {
            visitedEdgs.add(current)
            path.add(edge.destination)
            weight.add(edge.weight)
            findSmallestPathBrutForce(graph,visitedEdgs,edge.destination,taget,path,weight)
            visitedEdgs.remove(current)
            path.removeAt(path.lastIndex)
            weight.removeAt(weight.lastIndex)
        }
    }
}



/**
 * Finding Shortest by returning ShortestPath class instead os storing in global variable
 */
fun findSmallestPathBrutForce(
    graph:Map<Int,List<Edge>>,
    visited : HashSet<Int>,
    source:Int,
    target: Int,
    path: MutableList<Int>,
    weight : MutableList<Int>,
    shortestPath: ShortestPath
) : ShortestPath {

    if (source == target) {
        val wt = weight.sum()
        if (wt < shortestPath.weight) {
            shortestPath.weight = wt
            shortestPath.path.clear()
            shortestPath.path.addAll(path)
        }
        return shortestPath
    }

    if (visited.contains(source).not()){
        for (edge in graph[source]!!){
            visited.add(source)
            weight.add(edge.weight)
            path.add(edge.destination)
            findSmallestPathBrutForce(graph,visited,edge.destination,target,path,weight,shortestPath)
            visited.remove(source)
            weight.removeAt(weight.lastIndex)
            path.removeAt(path.lastIndex)
        }
    }

    return shortestPath
}

