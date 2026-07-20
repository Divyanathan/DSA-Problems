package com.example.dsaproblems.graph

import java.util.PriorityQueue


/**
 * Constructs the Minimum Spanning Tree (MST) of a connected, weighted,
 * undirected graph using Prim's Algorithm (naive implementation).
 *
 * The algorithm starts from an arbitrary vertex and repeatedly selects the
 * minimum-weight edge that connects a vertex already in the MST to a vertex
 * outside the MST. This process continues until all vertices are included
 * in the spanning tree.
 *

 *
 * Constraints:
 * - The graph must be connected.
 * - The graph must be undirected.
 * - Edge weights may be positive, zero, or negative.
 * - Multiple edges between the same vertices are allowed.
 * - Self-loops are ignored since they never improve the MST.
 * - The graph should not contain null adjacency lists.
 *
 * Time Complexity:
 *      O(V × E)
 *
 * Space Complexity:
 *      O(V + E)
 *
 * Note:
 * This is a straightforward implementation of Prim's algorithm that
 * linearly searches for the minimum crossing edge during each iteration.
 * A PriorityQueue-based implementation can reduce the time complexity
 * to O(E log V).
 */

fun main(){
    println("MST Using Prims Algo")
    val graph: Map<Char, List<MSTEdge>> = mapOf(
        'A' to listOf(
            MSTEdge('A', 'B', 7),
            MSTEdge('A', 'D', 5),
        ),
        'B' to listOf(
            MSTEdge('B', 'A', 7),
            MSTEdge('B', 'C', 8),
            MSTEdge('B', 'D', 9),
            MSTEdge('B', 'E', 7),
        ),
        'C' to listOf(
            MSTEdge('C', 'B', 8),
            MSTEdge('C', 'E', 5),
        ),
        'D' to listOf(
            MSTEdge('D', 'A', 5),
            MSTEdge('D', 'B', 9),
            MSTEdge('D', 'E', 15),
            MSTEdge('D', 'F', 6),
        ),
        'E' to listOf(
            MSTEdge('E', 'B', 7),
            MSTEdge('E', 'C', 5),
            MSTEdge('E', 'D', 15),
            MSTEdge('E', 'F', 8),
            MSTEdge('E', 'G', 9),
        ),
        'F' to listOf(
            MSTEdge('F', 'D', 6),
            MSTEdge('F', 'E', 8),
            MSTEdge('F', 'G', 11),
        ),
        'G' to listOf(
            MSTEdge('G', 'F', 11),
            MSTEdge('G', 'E', 9),
        )
    )
    val nonMSTSet: HashSet<Char> = HashSet()
    nonMSTSet.addAll(graph.keys)
    val mstMap: HashMap<Char, MutableList<MSTEdge>> = HashMap()
    val result = mst(graph, nonMSTSet, mstMap)
    var weigth = 0
    for (MSTEdges in result.values) {
        for (MSTEdge in MSTEdges) {
            println("${MSTEdge.source} -> ${MSTEdge.destination} weight ${MSTEdge.weight}")
            weigth += MSTEdge.weight
        }
    }
    println("total weight $weigth")
    println()
    println("MST Using Prims Algo with PriorityQueue")
    mstWithPriorityQueue(graph,current = 'A')
}

/**
 * Time complexity of this algorithm is O(E x V) which is equal to O(E Square)
 */
fun mst(
    graph: Map<Char, List<MSTEdge>>,
    nonMST: HashSet<Char>,
    mst: HashMap<Char, MutableList<MSTEdge>>
): HashMap<Char, MutableList<MSTEdge>> {

    val vertex = nonMST.first()
    nonMST.remove(vertex)
    mst[vertex] = mutableListOf()
    while (nonMST.isNotEmpty()) {
        var minimumMSTEdge: MSTEdge? = null
        var minimumWeight = Int.MAX_VALUE
        for (mstVertex in mst.keys) {
            for (MSTEdge in graph[mstVertex]!!) {
                if (nonMST.contains(MSTEdge.destination) && MSTEdge.weight < minimumWeight) {
                    minimumWeight = MSTEdge.weight
                    minimumMSTEdge = MSTEdge
                }
            }
        }
        minimumMSTEdge ?: throw Exception("Disconnected Graph ")

        if (mst.containsKey(minimumMSTEdge.source)) {
            mst[minimumMSTEdge.source]?.add(minimumMSTEdge)
        } else {
            mst[minimumMSTEdge.source] = mutableListOf(minimumMSTEdge)
        }
        mst[minimumMSTEdge.destination] = mutableListOf()
        nonMST.remove(minimumMSTEdge.destination)
    }
    return mst
}

data class MSTEdge(
    val source: Char,
    val destination: Char,
    val weight: Int
)


/**
 * Time complexity of this algorithm is O(E log V)
 */
fun mstWithPriorityQueue(
    graph: Map<Char, List<MSTEdge>>,
    visited : HashSet<Char> = HashSet(),
    current : Char
) {
    val priorityQueue: PriorityQueue<MSTEdge> = PriorityQueue(
        compareBy {
            it.weight
        }
    )
    val nonMSt :HashSet<Char> = HashSet()
    nonMSt.addAll(graph.keys)
    for (edges in graph[current]!!){
        priorityQueue.add(edges)
    }
    visited.add(current)
    var weight = 0
    while (priorityQueue.isNotEmpty()){
        val vertex = priorityQueue.remove()
        if (visited.contains(vertex.destination).not()) {
            for (edge in graph[vertex.destination]!!) {
                if (visited.contains(edge.destination).not()) {
                    priorityQueue.add(edge)
                }
            }
            weight += vertex.weight
            visited.add(vertex.destination)
            println("Path $vertex")
        }
    }
    println("Weight $weight")
}
