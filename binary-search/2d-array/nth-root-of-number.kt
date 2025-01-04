// https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/

import kotlin.math.pow

fun main() {
    val ans = findNthRootOfNumber(4,255)
    println("$ans")
}

fun findNthRootOfNumber(
    n: Int,
    m: Int
): Int {
    var low = 1
    var high = n

    var ans = -1

    while(low <= high) {
        var mid = (low+high)/2
        val nthPower = (mid.toFloat().pow(n)).toInt()

        if(nthPower == m) {
            ans = mid
            break
        }

        if(nthPower > m) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return ans
}
