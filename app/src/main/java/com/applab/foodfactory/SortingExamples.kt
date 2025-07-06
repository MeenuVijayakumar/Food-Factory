package com.applab.foodfactory

fun main(){
val inputs = listOf("Orange,Banana","Berry","Apple","Grapes","Ice cream","Elephant","Road")
    println(sortList(inputs))
    val map = HashMap<String,Int>()
    map["key1"] = 22
    map["key2"] = 44
    //println(map["key1"])
    val list = listOf(10,22,22,33,4,22)
   // print(list.toSet()) //remove duplicate nums
   /* val set = HashSet<String>()
    set.add("Apple")
    println(set.add("Apple"))//return false
    println(set.add("Bag"))//true
    println(firstNonRepeatingCharUsingLinkedHashMap("scissorics"))
    println(firstNonRepeatingCharUsingHashMap("scissorics"))
    println(isAnagram("palm","lkmp")) // LinkedHashMap
    println(findDuplicates(list)) // using hash set
    println(hasDuplicates(list))*/
    val a = "AGGTAB"
    val b = "GAXXXBYB"
    println(longestCommonSubsequence(a, b))  // Output: 4 (for "GTAB")
}

fun longestCommonSubsequence(s1: String, s2: String): Int {
    val m = s1.length
    val n = s2.length
    // dp[i][j] = length of LCS of s1[0..i), s2[0..j)
    val dp = Array(m + 1) { IntArray(n + 1) }

    for (i in 1..m) {
        for (j in 1..n) {
            dp[i][j] = if (s1[i - 1] == s2[j - 1]) {
                dp[i - 1][j - 1] + 1
            } else {
                maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[m][n]
}

fun <T> findDuplicates(list:List<T>):List<T>{
    val set = HashSet<T>()
    return list.filter { !set.add(it) }

}

fun <T> hasDuplicates(list:List<T>):Boolean{
   val hash = HashSet<T> ()
    for (i in list)
        if (!hash.add(i)) return true
    return false
}

fun sortList(list:List<String>):List<String>{
    val vowels = listOf('a','e','i','o','u')
    val (vowelList,consonantList) = list.partition { it.isNotEmpty() && vowels.contains(it.first().lowercaseChar())    }
    return vowelList.sorted().plus(consonantList.sorted())

}
fun firstNonRepeatingCharUsingLinkedHashMap(s: String): Char? {
    val countMap = LinkedHashMap<Char, Int>()
    for (c in s) {
        countMap[c] = countMap.getOrDefault(c, 0) + 1
    }
    println("$"+countMap.entries)
    return countMap.entries.firstOrNull { it.value == 1 }?.key
}
fun firstNonRepeatingCharUsingHashMap(s: String): Char? {
    val countMap = HashMap<Char, Int>()
    for (c in s) {
        countMap[c] = countMap.getOrDefault(c, 0) + 1
    }
    println(countMap.entries)
    return countMap.entries.firstOrNull { it.value == 1 }?.key
}
fun isAnagram(str1:String,str2:String):Boolean{
    if (str1.length!=str2.length) return false
    val hmap = LinkedHashMap<Char,Int>()
    for (c in str1){
        hmap[c] = hmap.getOrDefault(c,0)+1
    }
    for (c in str2){
        val count = hmap.getOrDefault(c,0)
        if (count==0) return false
        hmap[c] = hmap.getOrDefault(c,0)-1
    }
    return true
}