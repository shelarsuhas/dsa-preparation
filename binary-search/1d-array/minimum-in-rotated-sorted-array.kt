// https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/
// modifying this problem to incluce duplicate values as well

fun main() {
    val arr = intArrayOf(4,5,1,2,3)
    val smallestElement = minimumInRotatedSortedArray(arr = arr)
    println("The smallest element in ${arr.contentToString()} is $smallestElement")
}

private fun minimumInRotatedSortedArray(
    arr: IntArray
): Int {
    var low = 0
    var high = arr.size - 1
    var smallestElement = Integer.MAX_VALUE

    while(low <= high) {
        var mid = (low + high) / 2

        // this optimisation can be used when there are not duplicates in the array

        /*if(arr[low] <= arr[high]) {
            smallestElement = Math.min(smallestElement, arr[low])
            break
        }*/

        while(low <= high && arr[low] == arr[mid] && arr[mid] == arr[high]) {
            low += 1
            high -= 1
        }

        if(arr[low] <= arr[mid]) {
            smallestElement = Math.min(smallestElement, arr[low])
            low = mid + 1
        } else {
            smallestElement = Math.min(smallestElement, arr[mid])
            high = high - 1
        }
    }

    return smallestElement
}
