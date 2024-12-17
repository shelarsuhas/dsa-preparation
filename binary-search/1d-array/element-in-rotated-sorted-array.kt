fun main() {
    val target = 8
    val arr = intArrayOf(6,7,8,9,1,2,3,4,5)

    val result = findTargetInRotatedSortedArray(
        target = target,
        arr = arr
    )

    println("Position of $target is $result")
}

fun findTargetInRotatedSortedArray(
    target: Int,
    arr: IntArray,
): Int {
    var low: Int = 0
    var high: Int = arr.size - 1
    var index = -1

    while (low <= high) {
        var mid = (low + high) / 2

        if(arr[mid] == target) {
            index = mid
        }

        if(arr[low] <= arr[mid]) {
            if(arr[low] <= target && target <= arr[mid]) {
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

    return index
}
