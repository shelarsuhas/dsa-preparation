fun main() {
    val target = 3
    val arr = intArrayOf(1,2,3,3,3,4,5,6,7)
    countOccuranceInSortedArrayBruteForce(
        target = target,
        arr = arr
    )

    countOccuranceInSortedArrayOptimised(
        target = target,
        arr = arr
    )
}

fun countOccuranceInSortedArrayBruteForce(
    target: Int,
    arr: IntArray
) {
    var count = 0
    run loop@ {
        arr.forEach {
            if(it > target) {
                return@loop
            }

            if(it == target) {
                count++
            }
        }
    }

    println("Count of $target is $count")
}

fun countOccuranceInSortedArrayOptimised(
    target: Int,
    arr: IntArray
) {
    val lowerBound = findLowerBound(
        target = target,
        arr = arr
    )
    
    val upperBound = findUpperBound(
        target = target,
        arr = arr
    )

    println("lb = $lowerBound || ub = $upperBound")
    if(lowerBound > -1 && upperBound > -1) {
        println("Count is ${upperBound - lowerBound + 1}")
    } else {
        println("Not found")
    }
}

private fun findLowerBound(
    target: Int,
    arr: IntArray
): Int {
    var low = 0
    var high = arr.size - 1
    var index = -1

    while(low <= high) {
        var mid = (low + high) / 2

        if(arr[mid] == target) {
            index = mid
            high = mid - 1
        } else {
            if(arr[mid] < target) {
                low = mid + 1
            }

            if(arr[mid] > target) {
                high = mid - 1
            }
        }
    }
    return index
}

private fun findUpperBound(
    target: Int,
    arr: IntArray
): Int {
    var low = 0
    var high = arr.size - 1
    var index = -1

    while(low <= high) {
        var mid = (low + high) / 2

        if(arr[mid] == target) {
            index = mid
            low = mid + 1
        } else {
            if(arr[mid] < target) {
                low = mid + 1
            }

            if(arr[mid] > target) {
                high = mid - 1
            }
        }
    }
    return index
}
