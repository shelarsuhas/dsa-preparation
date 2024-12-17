// https://takeuforward.org/arrays/implement-lower-bound-bs-2/
fun main() {
    val lowerBound = findLowerBound(
        3,
        intArrayOf(1,2,2,3,3,4,5,6,7,8,8,9,9,9,10)
    )

    println("Lower Bound is $lowerBound")
}

fun findLowerBound(target: Int, arr: IntArray): Int {
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
