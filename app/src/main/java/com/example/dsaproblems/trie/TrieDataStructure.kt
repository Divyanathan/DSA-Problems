package com.example.dsaproblems.trie

fun main() {
    println("TRIE Data Structure")
    val words: Array<String> = arrayOf(
        "the", "a", "there", "their", "any", "any", "the"
    )
    val node = Node()
    for (word in words) {
        buildTree(node, word, 0, word.length == 1)
    }
    val word = "any"
    println("\n is \"$word\" exist in Trie ${isWordExist(node, word, 0, word.length - 1 == 0)}")
}

data class Node(
    var isEndOFWord: Boolean = false,
    val node: HashMap<Char, Node> = HashMap()
)

fun buildTree(node: Node, word: String, index: Int, isEndOfWord: Boolean) {
    if (node.node.contains(word[index])) {
        if (isEndOfWord) {
            node.node[word[index]]!!.isEndOFWord = true
        }
    } else {
        // Add new new letter and pass next letter to added
        node.node[word[index]] = Node(isEndOfWord)
    }
    if (isEndOfWord.not())
        buildTree(node.node[word[index]]!!, word, index + 1, index + 1 == word.length - 1)
}

fun isWordExist(node: Node, word: String, index: Int, eow: Boolean): Boolean {
    if (node.node.contains(word[index])) {
        if (eow) {
            return node.node[word[index]]!!.isEndOFWord
        } else {
            if (isWordExist(
                    node.node[word[index]]!!,
                    word,
                    index + 1,
                    index + 1 == word.length - 1
                )
            )
                return true
        }
    }
    return false
}
