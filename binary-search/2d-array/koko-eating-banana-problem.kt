// https://takeuforward.org/binary-search/koko-eating-bananas/

fun main() {
    val arr = intArrayOf(805306368,805306368,805306368)
    val hours = 1000000000
    val ans = findRateOfEatingBanana(arr, hours)
    println("Koko should eat at least " + ans + " bananas/hr.");
}

fun findRateOfEatingBanana(
    arr: IntArray,
    hours: Int
): Int {
    val maxElement = findMaxElement(arr = arr)

    var low = 1
    var high = maxElement
    var ans = maxElement

    while(low <= high) {
        val mid = (low+high) / 2
        val totalHours = findTotalHourEatingRate(arr, mid)
        println("mid = $mid totalHours = $totalHours")
        if(totalHours <= hours) {
            if(totalHours > 1) {
                ans = mid
            }
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return ans
}

// get the max element from the array
fun findMaxElement(
    arr: IntArray
): Int {
    var maxE = -1

    arr.forEach {
        maxE = Math.max(maxE, it)
    }

    return maxE
}

// calculate total hours required for the given eating rate
fun findTotalHourEatingRate(
    arr: IntArray,
    eatingRate: Int
): Int {
    var totalHours = 0

    arr.forEach {
        totalHours += (Math.ceil(it.toDouble()/eatingRate.toDouble())).toInt()
    }

    return totalHours
}
