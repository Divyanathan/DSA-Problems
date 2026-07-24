package com.example.dsaproblems.slidingWindow


fun main(){
    val s = "ADOBECODEBANC"
    val t = "ABC"
    println("Given String $s")
    println("Target String $t")
    println("Substring which contains all characters of target string \"${minWindow(s,t)}\"")
}

fun minWindow(s: String, t: String): String {
    if(s == t){
        return s
    }
    val tFre : HashMap<Char,Int> = HashMap()
    val sFre : HashMap<Char,Int> = HashMap()
    for(i in 0..<t.length){
        tFre[t[i]] = tFre.getOrDefault(t[i],0)+1
    }
    var subString =""
    var subSringLength = Int.MAX_VALUE
    var i=0
    for(j in 0..<s.length){
        sFre[s[j]] = sFre.getOrDefault(s[j],0)+1
        while(isMatch(sFre,tFre)){
            val sStr = s.substring(i,j+1)
            if(sStr.length <subSringLength){
                subString = sStr
                subSringLength = sStr.length
            }
            sFre[s[i]] = sFre.getOrDefault(s[i],1) - 1
            i++
        }
    }
    return subString
}

fun isMatch(sFre:HashMap<Char,Int>,tFre:HashMap<Char,Int>): Boolean {
    for(char in tFre.keys){
        val tFreCount : Int = tFre.getOrDefault(char,0)
        val sFreCount : Int = sFre.getOrDefault(char,0)
        if(sFreCount<tFreCount)
            return false
    }
    return true
}
