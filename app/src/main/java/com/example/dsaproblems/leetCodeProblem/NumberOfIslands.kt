package com.example.dsaproblems.leetCodeProblem

fun main() {
    println("Number of islands")
    val graph: Array<CharArray> = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    var island = 0
    for (i in 0..3) {
        for (j in 0..4) {
            if (graph[i][j] != '0') {
                dfs(graph, i, j)
                island++
            }
        }
    }
    println("Island 1 Using CharArray Result = \"$island\"")


    val graph2: Array<CharArray> = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '1', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '1', '1', '1')
    )
    var island2 = 0
    for (i in 0..3) {
        for (j in 0..4) {
            if (graph2[i][j] != '0') {
                dfs(graph2, i, j)
                island2++
            }
        }
    }

    println("Island 2 Using CharArray with different input Result = \"$island2\"")

    val rows = 4
    val cols = 5

    val graph3: Array<IntArray> = Array(rows) {
        IntArray(cols)
    }
    graph3[0] = intArrayOf(1, 1, 0, 0, 0)
    graph3[1] = intArrayOf(1, 1, 0, 0, 0)
    graph3[2] = intArrayOf(0, 0, 1, 0, 0)
    graph3[3] = intArrayOf(0, 0, 0, 1, 1)


    var island3 = 0
    for (i in 0..3) {
        for (j in 0..4) {
            if (graph3[i][j] != 0) {
                dfs(graph3, i, j, rows, cols)
                island3++
            }

        }
    }

    println("Island 3 Using Array<IntArray > Result = \"$island3\"")

    val graph4 = arrayOf(
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(0, 0, 1, 0, 0),
        arrayOf(0, 0, 0, 1, 1)
    )

    var island4 = 0
    for (i in 0..3) {
        for (j in 0..4) {
            if (graph4[i][j] != 0) {
                dfs(graph4, i, j, rows, cols)
                island4++
            }

        }
    }
    println("Island 4 Using Array<Array<Int> > Result = \"$island4\"")


}

fun dfs(graph: Array<CharArray>, i: Int, j: Int) {
    if ((i in 0..3 && j in 0..4).not() || graph[i][j] == '0') {
        return
    }
    graph[i][j] = '0'
    dfs(graph, i, j + 1)
    dfs(graph, i, j - 1)
    dfs(graph, i + 1, j)
    dfs(graph, i - 1, j)
}

fun dfs(graph: Array<IntArray>, i: Int, j: Int, row: Int, cols: Int) {
    if ((i in 0..<row && j in 0..<cols).not() || graph[i][j] == 0) {
        return
    }
    graph[i][j] = 0
    dfs(graph, i, j + 1, row, cols)
    dfs(graph, i, j - 1, row, cols)
    dfs(graph, i + 1, j, row, cols)
    dfs(graph, i - 1, j, row, cols)
}

fun dfs(graph: Array<Array<Int>>, i: Int, j: Int, row: Int, cols: Int) {
    if ((i in 0..<row && j in 0..<cols).not() || graph[i][j] == 0) {
        return
    }
    graph[i][j] = 0
    dfs(graph, i, j + 1, row, cols)
    dfs(graph, i, j - 1, row, cols)
    dfs(graph, i + 1, j, row, cols)
    dfs(graph, i - 1, j, row, cols)
}