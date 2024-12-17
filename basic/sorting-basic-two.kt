import java.util.*;

fun main() {
    val sorting = SortingBasicTwo()
    sorting.q()
    println(sorting.arr.contentToString())
}

class SortingBasicTwo() {
    val arr = intArrayOf(2,1,3,7,6,5,4,3)
    
    fun mergeSort() {
        println("Performing merge sort...")
        doMergeSort(arr, 0, arr.size-1)
    }

    private fun doMergeSort(arr: IntArray, low: Int, high: Int) {
        if(low >= high) return
        val mid: Int = (low+high) / 2
        doMergeSort(arr, low, mid)
        doMergeSort(arr, mid+1, high)
        doMerge(arr, low, mid, high)
    }

    private fun doMerge(arr: IntArray, low: Int, mid: Int, high: Int) {
        val tempArr = mutableListOf<Int>()
        var left = low
        var right = mid+1
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                tempArr.add(arr[left++])
            } else {
                tempArr.add(arr[right++])
            }
        }

        while(left <= mid) {
            tempArr.add(arr[left++])
        }

        while(right <= high) {
            tempArr.add(arr[right++])
        }

        for(i in low..high) {
            arr[i] = tempArr[i-low]
        }
    }

    fun recursiveBubbleSort() {
        println("Performing recursive bubble sort...")
        doRecursiveBubbleSort(arr, arr.size-1)
    }

    private fun doRecursiveBubbleSort(arr: IntArray, max: Int) {
        if(max == 1) return

        var didSwap = false
        for(i in 0..max-1) {
            if(arr[i] > arr[i+1]) {
                // val temp = arr[i]
                // arr[i] = arr[i+1]
                // arr[i+1] = temp

                swapNumbers(arr, i, i+1)
                didSwap = true
            }
        }

        if(didSwap.not()) return

        doRecursiveBubbleSort(arr, max-1)
    }

    fun quickSort() {
        println("Performing quick sort...")
        doQuickSort(arr, 0, arr.size-1)
    }

    private fun doQuickSort(arr: IntArray, low: Int, high: Int) {
        if(low < high) {
            val partitionIndex = quickSortPartition(arr, low, high)
            doQuickSort(arr, low, partitionIndex - 1)
            doQuickSort(arr, partitionIndex + 1, high)
        }
    }

    private fun quickSortPartition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = low
        var i = low
        var j = high

        while(i < j) {
            while(arr[pivot] > arr[i] &&  i <= high - 1) {
                i++
            }

            while(arr[pivot] <= arr[j] && j >= low + 1) {
                j--
            }

            if(i < j) {
                swapNumbers(arr, i, j)
            }
        }
        swapNumbers(arr, pivot, j)
        return j
    }

    private fun swapNumbers(arr: IntArray, index1: Int, index2: Int) {
        val temp = arr[index1]
        arr[index1] = arr[index2]
        arr[index2] = temp
    }
}
