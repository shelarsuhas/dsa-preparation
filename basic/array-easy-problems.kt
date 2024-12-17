import java.util.*;`
fun main() {
    val unsortedArray = intArrayOf(4,3,2,5,6,7,10)
    val sortedArray = intArrayOf(1,2,3,3,4,5,6,7,8,9)
    val arrayEasy = ArrayEasyProblems()
    arrayEasy.findLargestElement()
    println()
    arrayEasy.findSecondLargestAndSmallest()
    println()
    println("${arrayEasy.isArraySorted(unsortedArray)}")
    println()
    println("${arrayEasy.isArraySorted(sortedArray)}")
    println()
    arrayEasy.removeDuplicatesFromSortedArray()
    println()
    arrayEasy.rightRotateArrayByOne()
    println()
    arrayEasy.rightRotateByK(5)
    println()
    arrayEasy.rightRotateByKOptimal(7)
    println()
    arrayEasy.moveZeroToEnd()
    println()
    arrayEasy.moveZeroToEndOptimised()
    arrayEasy.unionOfSortedArray()
    println()
    arrayEasy.missingNumberInArray()
    println()
    arrayEasy.maxOnesInArray()
    println()
    arrayEasy.findSingleNumber()
    println()
    arrayEasy.longestSubarraiWtihSumK(sum = 125)
    println()
    arrayEasy.longestSubarraiWtihSumKOptimal()
    println()
    arrayEasy.longestSubarrayWIthSumKUsingPresum()

}

class ArrayEasyProblems() {
    fun findLargestElement() {
        val arr = intArrayOf(5,4,21,7,3,9,10,3,5,12)
        var max = -1
        for(i in arr) {
            if(max < i) {
                max = i
            }
        }

        println("The largest element in array - ${arr.contentToString()} is $max")
    }

    fun findSecondLargestAndSmallest() {
        val arr = intArrayOf(5,4,21,7,3,9,10,3,5,12)
        var largest = -1
        var large = -1
        var smallest = Int.MAX_VALUE
        var small = Int.MAX_VALUE

        for(i in arr) {
            if(i > largest) {
                large = largest
                largest = i
            } else if(i > large && i != largest) {
                large = i
            }

            if(i < smallest) {
                small = smallest
                smallest = i
            } else if(i < small && i != smallest) {
                small = i
            }
        }

        println("Array: ${arr.contentToString()} Largest = $largest SLarge = $large Smallest = $smallest sSmall = $small")
    }

    fun isArraySorted(arr: IntArray): Boolean {
        for(i in 0..arr.size-2) {
            if(arr[i]>arr[i+1]) {
                return false
            }
        }
        return true
    }

    fun removeDuplicatesFromSortedArray() {
        val arr = intArrayOf(1,1,1,2,2,3,3,4)
        var i = 0
        for(j in 1..arr.size-1) {
            if(arr[i] != arr[j]) {
                arr[++i] = arr[j]
            }
        }
        println("${i+1}")
    }

    fun rightRotateArrayByOne() {
        val arr = intArrayOf(1,2,3,4,5)
        println("Original array - ${arr.contentToString()}")
        for(i in 0..arr.size-2) {
            var temp = arr[i]
            arr[i] = arr[i+1]
            arr[i+1] = temp
        }
        println("After left rotate array - ${arr.contentToString()}")
    }

    fun rightRotateByK(k: Int) {
        val arr = intArrayOf(1,2,3,4,5,6,7,8,9)

        if(k > arr.size) return

        val tempArr = mutableListOf<Int>()
        
        for(i in arr.size-k..arr.size-1) {
            tempArr.add(arr[i])
        }
        
        var i = arr.size-1
        var j = arr.size-1-k

        while(j >= 0) {
            arr[i--] = arr[j--]
        }

        for(i in 0..tempArr.size-1) {
            arr[i] = tempArr[i]
        }

        println("${arr.contentToString()}")
    }

    fun rightRotateByKOptimal(k: Int) {
        val arr = intArrayOf(1,2,3,4,5,6,7,8,9)

        reverse(arr, 0, arr.size-1-k)
        reverse(arr, arr.size-k, arr.size-1)
        reverse(arr, 0, arr.size-1)

        println("${arr.contentToString()}")
    }

    private fun reverse(arr: IntArray, start: Int, end: Int) {
        var lStart = start
        var lEnd = end
        while(lStart <= lEnd) {
            val temp = arr[lStart]
            arr[lStart] = arr[lEnd]
            arr[lEnd] = temp
            lStart++
            lEnd--
        }
    }

    fun moveZeroToEnd() {
        val arr = intArrayOf(1,2,3,4,0,0,0,5,6,0,7,8)
        println("Move Zero To End: ${arr.contentToString()}")
        val tempArr = mutableListOf<Int>()
        for (i in arr) {
            if(i > 0) {
                tempArr.add(i)
            }
        }

        for(i in 0..arr.size-1) {
            if(i < tempArr.size) {
                arr[i] = tempArr[i]
            } else {
                arr[i] = 0
            }
        }
        println("${arr.contentToString()}")
    }

    fun moveZeroToEndOptimised() {
        val arr = intArrayOf(0,0,0,0,1)
        println("Move Zero To End Optimised: ${arr.contentToString()}")
        var pointer = 0
        for(i in 0 until arr.size) {
            if(arr[i] > 0) {
                if(pointer < i) {
                    val temp = arr[i]
                    arr[i] = arr[pointer]
                    arr[pointer] = temp
                }
                pointer++
            }
        }

        println("${arr.contentToString()}")
    }

    // this is actually intersection and not union
    fun unionOfSortedArray() {
        println("\nUnion of sorted array")
        val arr1 = intArrayOf(1,2,3,4,5)
        val arr2 = intArrayOf(6,7,8)
        val hash = HashMap<Int,Int>()

        for(i in arr1) {
            val count = hash.get(i)?.let {
                it + 1
            } ?: run {
                1
            }
            hash.put(i, count)
        }

        for(i in arr2) {
            val count = hash.get(i)?.let {
                it + 1
            } ?: run {
                1
            }
            hash.put(i, count)
        }

        var didFindUnion = false
        for(element in hash) {
            if(element.value > 1) {
                didFindUnion = true
                print("${element.key} ")
            }
        }

        if(didFindUnion.not()) {
            print(-1)
        }
    }

    fun missingNumberInArray() {
        val arr = intArrayOf(1,2,3,4,5,6,7,8,10)
        val n = 10
        if(arr[arr.size-1] != n) {
            println(n)
            return
        }
        for(i in 0..arr.size-1) {
            if(arr[i] != i+1) {
                println(i+1)
                return
            }
        }
    }

    fun maxOnesInArray() {
        val arr = intArrayOf(0,1,1,1,1,0,0,1,1)
        var maxCount = 0
        var currentCount = 0

        for(i in arr) {
            if(i == 0) {
                currentCount = 0
            } else {
                currentCount++
                if(currentCount > maxCount) {
                    maxCount = currentCount
                }
            }
        }

        println("Max ones in array are: $maxCount")
    }

    fun findSingleNumber() {
        val arr = intArrayOf(4,1,1,2,2,3,3)
        var xorValue = 0
        for(i in arr) {
            xorValue = xorValue xor i
        }
        println("findSingleNumber: ${arr.contentToString()}")
        println(xorValue)
    }

    fun longestSubarraiWtihSumK(sum: Int) {
        val arr = intArrayOf(8,2,3,1,5,1,4,2,6,125)
        if(arr.size == 1) {
            if(arr[0] == sum) {
                println(arr.contentToString())
            }
        }
        var maxI = -1
        var maxJ = -1
        var i = 0
        var j = i

        var currentSum = 0
        while(i < arr.size && j < arr.size) {
            currentSum = currentSum + arr[j]
            if(currentSum < sum) {
                j++
            } else if(currentSum == sum) {
                if(maxJ-maxI < j-i) {
                    maxI = i
                    maxJ = j
                }
                i++
                j = i+1
                currentSum = arr[i]
            } else if(currentSum > sum) {
                i++
                j = i+1
                currentSum = arr[i]
            }
        }

        println("Sum Array i = $maxI || j = $maxJ")
    }

    fun longestSubarraiWtihSumKOptimal() {
        val arr = intArrayOf(1,2,3,-1,-1,1,1,0,0,0,1,1,1)
        val k = 3
        var left = 0
        var right = 0
        var maxLen = 0
        var sum = arr[0]

        while(right < arr.size) {
            while(left <= right && sum > k) {
                sum -= arr[left]
                left++
            }

            if(sum == k) {
                maxLen = Math.max(maxLen, right - left + 1)
            }

            right++
            if(right < arr.size) {
                sum = sum + arr[right]
            }
        }

        println("left = $left right = $right maxlen = $maxLen")
    }

    fun longestSubarrayWIthSumKUsingPresum() {
        val arr = intArrayOf(1,2,3,0,0,1,1,1)
        val map = HashMap<Int,Int>() 
        val k = 3
        var sum = 0
        var maxLen = 0
        for(i in 0 until arr.size) {
            sum += arr[i]

            if(sum == k) {
                maxLen = Math.max(maxLen, i+1)
            }

            val rem = sum - k

            if(map.containsKey(rem)) {
                val len: Int = i - map.get(rem)!!
                maxLen = Math.max(maxLen, len)
            }

            if(map.containsKey(sum).not()) {
                map.put(sum, i)
            }
        }

        println("longestSubarrayWIthSumKUsingPresum - ${arr.contentToString()}")
        println("Max Len = $maxLen")
    }
}
