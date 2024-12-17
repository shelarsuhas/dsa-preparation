// https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/

fun main() {
    val arr = intArrayOf(6,5,4,3,2,1)
    val timesRotated = findNumberOfTimesArrayRotated(
        arr = arr
    )

    println("Times ${arr.contentToString()} is rotated = $timesRotated")
}

private fun findNumberOfTimesArrayRotated(
    arr: IntArray
): Int {
    var rotation = 0

    // find the smallest element in array

    // find the position of the smallest element

    // this position will be the number of times its rotated

    var low = 0
    var high = arr.size - 1

    var minElement = Int.MAX_VALUE
    var minElementPosition = -1

    while(low <= high) {
        var mid = (low + high) / 2

        if(arr[low] <= arr[high]) {
            if(arr[low] < minElement) {
                minElement = arr[low]
                minElementPosition = low
            }
            break
        }

        if(arr[low] <= arr[mid]) {
            if(arr[low] < minElement) {
                minElement = arr[low]
                minElementPosition = low
            }
            high = mid - 1
        } else {
            if(arr[mid] < minElement) {
                minElement = arr[mid]
                minElementPosition = mid
            }
            low = mid + 1
        }
    }

    println("Min Element = $minElement and Min Element Position = $minElementPosition")
    return minElementPosition
}
