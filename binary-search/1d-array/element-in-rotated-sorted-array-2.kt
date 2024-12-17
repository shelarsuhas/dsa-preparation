// array is sorted - rotated - and can have duplicate values
// edge case here - arr[low] == arr[mid] == arr[high]

fun main() {
    val target = 2
    var arr = intArrayOf(3,1,2,3,3,3,3)

    val isTargetFound = findTargetInRotatedSortedArray(
        target = target,
        arr = arr
    )

    println("Target $target isFound = $isTargetFound")
}

private fun findTargetInRotatedSortedArray(
    target: Int,
    arr: IntArray
): Boolean {
    var low = 0
    var high = arr.size - 1
    var isFound = false

    while (low <= high) {
        var mid = (low + high) / 2

        while(arr[low] == arr[mid] && arr[mid] == arr[high] && low <= high) {
            low = low + 1
            high = high - 1
        }

        if(arr[mid] == target) {
            isFound = true
        }

        if(arr[mid] >= arr[low]) {
            if(target >= arr[low] && target <= arr[mid]) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        } else {
            if(target >= arr[mid] && target <= arr[high]) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
    }

    return isFound
}
