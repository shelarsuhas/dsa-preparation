fun main() {
    val n = 3

    val sqrt = findSquareRoot(n)

    println("Square Root of $n is $sqrt")
}

fun findSquareRoot(n: Int): Int {
    var low = 1
    var high = n
    
    while(low <= high) {
        val mid = (low+high)/2

        if((mid*mid) <= n) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return high
}
