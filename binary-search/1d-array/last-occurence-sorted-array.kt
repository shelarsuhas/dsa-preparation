fun main() {
    val target = 3
    val findLastOccurence = findLastOccurence(
        target,
        intArrayOf(1,2,2,3,3,4,5,6,7,8,8,9,9,9,10)
    )

    println("Last occurence of $target is $findLastOccurence")
}

fun findLastOccurence(target: Int, arr: IntArray): Int {
    var low = 0
    var high = arr.size - 1
    var ans = -1

    while(low <= high) {
        var mid = (low + high) / 2

        // eliminate left side
        if(arr[mid] == target) {
            ans = mid
            low = mid + 1
        } else if(target < arr[mid]) {
            high = mid - 1
        }
         else {
            low = mid + 1
        }
    }

    return ans
}