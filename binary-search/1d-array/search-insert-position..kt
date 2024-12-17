fun main() {
    val position = searchInsertPosition(
        5,
        intArrayOf(1,2,3,4,5,7,8,9,10)
    )

    println("Insert Position = $position")
}

fun searchInsertPosition(target: Int, arr: IntArray): Int {
    var ans = arr.size
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        var mid = (low+high) / 2
        if(arr[mid] >= target) {
            ans = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return ans
}