fun main() {
    findTarget(
        3,
        intArrayOf(1,2,3,4,5,6,7,8,9)
    )

    findTargetRecurssive(
        3,
        intArrayOf(1,2,3,4,5,6,7,8,9)
    )
}

fun findTarget(target: Int, arr: IntArray) {
    if(arr.size == 0) return

    var low = 0
    var high = arr.size-1
    var isFound = false

    while(low < high) {
        val mid = (low + high)/2

        if(arr[mid] == target) {
            isFound = true
            break
        } else {
            if(target < arr[mid]) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
    }

    println("findTarget Target $target found? -> $isFound")
}

fun findTargetRecurssive(target: Int, arr: IntArray) {
    var low = 0
    var high = arr.size-1
    var isFound = recurssive(target, arr, high, low)
    println("findTargetRecurssive Target $target found? -> $isFound")
}

fun recurssive(target: Int, arr: IntArray, high: Int, low: Int): Boolean {
    return if(low < high) {
        val mid = (low + high) / 2
        if(arr[mid] == target) {
            true
        } else {
            if(target < arr[mid]) {
                recurssive(target, arr, mid - 1, low)
            } else {
                recurssive(target, arr, high, mid + 1)
            }
        }
    } else {
        false
    }
}
