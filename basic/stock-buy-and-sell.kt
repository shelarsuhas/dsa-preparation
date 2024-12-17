fun main() {
    stockBuySell(prices = intArrayOf(2,5,1,8))
    stockBuySell(prices = intArrayOf(7,1,5,3,6,4))
    stockBuySell(prices = intArrayOf(7,6,4,3,1))
}

fun stockBuySell(
    prices: IntArray,
) {
    var minPrice: Int = Int.MAX_VALUE
    var maxPrice: Int = 0

    for(i in prices.indices) {
        minPrice = Math.min(minPrice, prices[i])
        maxPrice = Math.max(maxPrice, prices[i] - minPrice)
    }

    println("Highest Profit = $maxPrice")
}
