// https://takeuforward.org/data-structure/peak-element-in-array/

fun main() {
    val arr = intArrayOf(-4,-3,-2,1,1,2,1)
    val peakElementPosition = peakElementInArray(arr = arr)
    println("Peak element in array: ${arr.contentToString()} is at position $peakElementPosition")
}

fun peakElementInArray(
    arr: IntArray
): Int {
    // what is peak element?
    // greater than previous and next element

    val size = arr.size
    if(size == 1) {
        return 0
    } else if (arr[0] > arr[1]) {
        return 0
    } else if (arr[size - 1] > arr[size - 2]) {
        return size-1
    }

    var low = 1
    var high = size - 2

    while(low <= high) {
        val mid = (low + high) / 2

        if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
            return mid
        }

        if(arr[mid - 1] > arr[mid] && arr[mid] > arr[mid+1]) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return -1
}
