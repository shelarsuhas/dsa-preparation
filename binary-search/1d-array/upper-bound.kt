// https://takeuforward.org/arrays/implement-upper-bound/


fun main() {
    val lowerBound = upperBound(
        3,
        intArrayOf(1,2,2,3,3,4,5,6,7,8,8,9,9,9,10)
    )

    println("Upper Bound is $lowerBound")
}

fun upperBound(target: Int, arr: IntArray): Int {
    var ans = 0
    var low = 0
    var high = arr.size - 1

    while(low <= high) {
        var mid = (low + high) / 2

        // eliminate right side
        if(arr[mid] > target) {
            ans = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return ans
}
