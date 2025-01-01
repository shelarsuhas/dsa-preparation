// https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/

fun main() {
    val arr = intArrayOf(1,1,2,2,3,4,4,5,5,6,6)
    val singleElement = findSingleElementInSortedArray(arr = arr)
    println("Single element in ${arr.contentToString()} is $singleElement")
}

fun findSingleElementInSortedArray(
    arr: IntArray
): Int {
    val size = arr.size
    if(size == 1) {
        return arr[0]
    } else if (arr[0] != arr[1]) {
        return arr[0]
    }else if (arr[size-1] != arr[size-2]) {
        return arr[size-1]
    }

    var low = 1
    var high = size - 2

    while(low <= high) {
        var mid = (low + high) / 2

        if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
            return arr[mid]
        }

        if((mid%2 == 0 && arr[mid] == arr[mid+1]) || (mid%2 == 1 && arr[mid] == arr[mid-1])) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return -1
}
