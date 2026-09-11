package com.example.dsaproblems.backtracking

// Generate all the subset from using recursion  array return all the possible subset of the given
// given array (int)  each element form the array is unique also when you return it can be in any
// order
//input [1 2 3], out - [1] [2] [3] [1,2] [1,3] [2,3] [1,2,3]

fun main() {
    println("Subset with normal approach")
    println(
        generateSubset(
            listOf(1, 2, 3),
        )
    )
    println("Subset with optimal solution")
    println(
        generateSubsetOptimal(
            listOf(1, 2, 3),
        )
    )
}

fun generateSubset(
    input: List<Int>,
    subset: ArrayList<List<Int>> = ArrayList(),
    currentArray: ArrayList<Int> = ArrayList(),
    index: Int = 0,
): List<List<Int>>{

//    println("Current Array $currentArray  subset $subset")
    if (subset.contains(currentArray).not()){
        subset.add(ArrayList(currentArray))
    }

    for (i in index until input.size){
        for (j in i until input.size){
            if (currentArray.contains(input[i]).not())
                currentArray.add(input[i])
            generateSubset(input, subset, currentArray, i + 1)
        }
        currentArray.clear()
    }

    return subset
}


fun generateSubsetOptimal(
    input: List<Int>,
    subset: ArrayList<List<Int>> = ArrayList(),
    currentArray: ArrayList<Int> = ArrayList(),
    index: Int = 0,
): List<List<Int>> {

    // Every current state is a valid subset
    subset.add(currentArray.toList())

    for (i in index until input.size) {

        println("Index -> $index i ->$i")

        // Choose
        currentArray.add(input[i])

        // Explore
        generateSubsetOptimal(input,subset,currentArray,i + 1)

        // Undo choice / Backtrack
        currentArray.removeAt(currentArray.lastIndex)
    }

    return subset
}