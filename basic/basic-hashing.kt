import java.util.*;

fun main() {
    val sh = SimpleHashing()
    sh.findHighestLowestFrequencyElement()
}

class SimpleHashing() {

    fun integerHashing() {
        val n = 5
        val arr = intArrayOf(1, 1, 1, 3 , 5, 7, 9, 5, 6, 1)

        val hash = IntArray(10)
        for(i in 0 until arr.size) {
            hash[arr[i]] += 1
        }

        println(hash.joinToString())

        val query = intArrayOf(1, 7, 5)
        for(i in query) {
            println(" $i appears ${hash[i]} times")
        }
    }

    fun charHashing() {
        val testString = "abcabcdefhgiabc"
        val hash = IntArray(26)
        for(i in 0 until testString.length) {
            hash[testString[i] - 'a']++
        }

        println(hash.joinToString())

        val query = "abcxyz"
        for(i in query) {
            println("$i appears ${hash[i-'a']}")
        }
    }

    fun hashingUsingHashMap() {
        val testString = "abcabcxyzdefmnoabc"
        val hash = HashMap<Char, Int>()
        for(i in testString) {
            // hash.get(i)?.let {
            //     hash.put(i, it + 1)
            // } ?: run {
            //     hash.put(i, 1)
            // }

            // or

            var count = hash.get(i) ?: 0
            hash.put(i, ++count)
        }
        val query = " abcfm"
        for(i in query) {
            if(hash.containsKey(i)) {
                println("$i appears ${hash.get(i)}")
            }
        }
    }

    // Count frequency of each element in the array
    fun frequencyOfElement() {
        val arr = intArrayOf(10, 10, 10, 4, 5, 6, 7, 8, 4, 5, 6, 4, 3, 2, 4, 0 , 0, 32)
        val hashMap = HashMap<Int, Int>()

        for(i in arr) {
            var count = hashMap.get(i) ?: 0
            hashMap.put(i, ++count)
        }

        for(element in hashMap) {
            println("${element.key} appears ${element.value} times")
        }
    }

    // Find the highest/lowest frequency element
    fun findHighestLowestFrequencyElement() {
        val arr = intArrayOf(1, 1, 2, 1, 1, 3, 3, 2)
        val hash = HashMap<Int, Int>()

        for(i in arr) {
            var count = hash.get(i) ?: 0
            hash.put(i, ++count)
        }

        /*
            1 -> 3
            2 -> 1
            3 -> 2
         */
        var low = Int.MAX_VALUE
        var lowValue = -1
        var high = 0
        var highValue = -1

        for(element in hash) {
            if(element.value < low) {
                low = element.value
                lowValue = element.key
            }

            if(element.value > high) {
                high = element.value
                highValue = element.key
            }
        }

        println("Highest: $highValue and Lowest: $lowValue")
    }
}
