package com.example.dsaproblems.graph


fun main(){
    val graph : LinkedHashMap<Int,List<Int>> = LinkedHashMap()
    graph[1] = listOf(3)
    graph[3] = listOf()
    graph[0] = listOf(1,2)
    graph[2] = listOf(3,4)
    graph[4] = listOf(0)
    println("\n\nisDirectedGraphCycle --> \"${isDirectedGraphCycle(graph)}\"")
    graph[4] = listOf() // remove the 4->0 edge to check non cycle graph
    println("\n\nisDirectedGraphCycle --> \"${isDirectedGraphCycle(graph)}\"")

}


fun dfsFindCycle(
    graph: HashMap<Int, List<Int>>,
    visited: HashSet<Int>,
    cycleList: HashSet<Int>,
    current: Int
): Boolean {
    if (cycleList.contains(current)) {
        return true
    }
    //To avoid unnecessary search edge is been visited Already
    // And it's not cycle so we can ignore and move to next vertex
    if (visited.contains(current))
        return false

    visited.add(current)
    cycleList.add(current)
    println("=============================")
    println("Current $current")
    println("Visited $visited")
    println("CycleList $cycleList")
    for (edge in graph[current]!!) {
        println("Next edge $edge")
        val hasCycle = dfsFindCycle(graph, visited, cycleList, edge)
        println("Has cycle $hasCycle edge $edge current $current")
        if (hasCycle) {
            return true
        }
    }
    cycleList.remove(current)
    println("Removing $current updated Cycle List $cycleList")
    return false
}

fun isDirectedGraphCycle(
    graph: HashMap<Int, List<Int>>,
    visited: LinkedHashSet<Int> = LinkedHashSet(),
    cycleList: LinkedHashSet<Int> = LinkedHashSet()
): Boolean {
    for (vertex in graph.keys) {
        if (visited.contains(vertex).not()) {
            if (dfsFindCycle(graph, visited, cycleList, vertex)) {
                return true
            }
        }
    }
    return false
}
