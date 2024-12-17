import java.util.*;
fun main() {
    val obj = ArrayMediumProblem()
    obj.twoSum()
    obj.twoSumUsingPointers()
    obj.sortArray012()
    obj.majorityElementInArray()
    obj.majorityElementInArrayOptimal()
    obj.majoritySumSubArrayKadane()
    obj.stockBuyAndSell()
}

class ArrayMediumProblem() {
    fun twoSum() {
        val arr = intArrayOf(2,6,5,8,11)
        val target = 14

        val map = HashMap<Int,Int>()

        var rIndexOne = -1
        var rIndexTwo = -1
        for(i in 0 until arr.size) {
            val rem = target - arr[i]
            if(map.containsKey(rem)) {
                rIndexOne = map.get(rem)!!
                rIndexTwo = i
                break
            } else {
                map.put(arr[i], i)
            }
        }

        println(map)
        println("Two sum indexes = $rIndexOne $rIndexTwo")
    }

    fun twoSumUsingPointers() {
        val arr = intArrayOf(2,6,5,8,11)
        val target = 14

        var left = 0
        var right = arr.size - 1

        var rIndexOne = -1
        var rIndexTwo = -1

        while(left < right) {
            val sum = arr[left]+arr[right]
            if(sum == target) {
                rIndexOne = left
                rIndexTwo = right
                break
            } else if(sum < target) {
                left++
            } else {
                right--
            }
        }

        println("Two sum indexes with pointers = $rIndexOne $rIndexTwo")
    }

    fun sortArray012() {
        val arr = intArrayOf(2,2,1,0,0,0,1,1,2)
        var low = 0
        var mid = 0
        var high = arr.size-1

        while(mid <= high) {
            if(arr[mid] == 0) {
                val temp = arr[mid]
                arr[mid] = arr[low]
                arr[low] = temp
                low++
                mid++
            } else if(arr[mid] == 1) {
                mid++
            } else {
                val temp = arr[mid]
                arr[mid] = arr[high]
                arr[high] = temp
                high--
            }
        }

        println("Sorted - ${arr.contentToString()}")
    }

    fun majorityElementInArray() {
        val arr = intArrayOf(1,1,1,1,2,2,2,2)
        val target = arr.size/2
        val map = HashMap<Int, Int>()

        for(i in arr) {
            val count = map.get(i)?.let{
                it + 1
            } ?: 1

            map.put(i, count)
        }

        for(element in map) {
            if(element.value > target) {
                println(element.key)
                return
            }
        }

        println("Not Found")
    }

    fun majorityElementInArrayOptimal() {
        val arr = intArrayOf(3,1,1,3,2,2,3,3,3)
        var count = 0
        var element = -1

        for(i in arr) {
            if(count == 0) {
                element = i
                count++
            } else {
                if(i == element) {
                    count++
                } else {
                    count--
                }
            }
        }

        println("Majority Element = $element")
    }

    fun majoritySumSubArrayKadane() {
        val arr = intArrayOf(2,3,-3,-1,-1,4,2,-2,1)
        var sum = 0
        var max = Int.MIN_VALUE

        var start = 0
        var ansStart = -1
        var ansEnd = -1
        for(i in arr.indices) {
            
            if (sum == 0) start = i;
            
            sum += arr[i]

            if(sum > max) {
                max = sum

                ansStart = start;
                ansEnd = i;
            }
            
            if(sum < 0) {
                sum = 0
            }
        }
        println("majoritySumSubArrayKadane $max || start = $ansStart end = $ansEnd")
    }

    fun stockBuyAndSell() {
        val arr = intArrayOf(7,1,5,3,6,4,10, 12)

        var maxProfit = 0
        var minValue = Int.MAX_VALUE

        arr.forEach {
            minValue = Math.min(minValue, it)
            maxProfit = Math.max(maxProfit, it - minValue)
        }

        println("Max profit = $maxProfit")
    }
}
