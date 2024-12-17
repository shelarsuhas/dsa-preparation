import java.util.*;

fun main() {
    val sortingBasicOne = SortingBasicOne()
    sortingBasicOne.insertionSort()
}

class SortingBasicOne() {
    /**
     * Selection sort works like this -
     * Two loops -
     * Outer loop points to the left element 
     * Inner loop runs from n-1 to outer loop index
     * Compare both indices and move the number to correct position
     *
     *  O(N2), (where N = size of the array), for the best, worst, and average cases.
    **/
    fun selectionSort() {
        val arr = intArrayOf(9,8,7,6,5,4,3,2,1)
        for(i in 0..arr.size-2) {
            for(j in (arr.size-1) downTo (i+1)) {
                if(arr[i] > arr[j]) {
                    var temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                }
            }
        }

        println(arr.contentToString())
    }

    /** 
     * loop runs from size - 1 to 1
     * inner loop run from 0 to outer loop
     * inner loop index is compared with index + 1 and highest is moved to right
     * at end of each iteration the array is sorted at last position
     *
     * O(N2), (where N = size of the array), for the worst, and average cases.
     * Bubble can be good if array is sorted and can complete in O(n)
     * this can be checked using a boolean inside inner loop - if condition is never true then exit loops
    **/
    fun bubbleSort() {
        val arr = intArrayOf(9,8,7,6,5,4,3,2,1)
        for(i in arr.size-1 downTo 1) {
            for(j in 0..i-1) {
                if(arr[j] > arr[j+1]) {
                    var temp = arr[j]
                    arr[j] = arr[j+1]
                    arr[j+1] = temp
                }
            }
        }

        println(arr.contentToString())
    }

    /**
     * Select an element in each iteration from the unsorted array(using a loop).
     * Place it in its corresponding position in the sorted part and shift the remaining elements accordingly (using an inner loop and swapping).
     * The “inner while loop” basically shifts the elements using swapping.
    **/
    fun insertionSort() {
        val arr = intArrayOf(9,8,7,6,5,4,3,2,1)
        for(i in 0..arr.size-1) {
            for(j in i downTo 1) {
                if(arr[j] < arr[j-1]) {
                    val temp = arr[j]
                    arr[j] = arr[j-1]
                    arr[j-1] = temp
                }
            }
        }
        println(arr.contentToString())
    }
}
