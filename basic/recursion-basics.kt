fun main() {
    println("** This is Recursion Flow **")
    val r1 = RecurssionToPrintNumber(maxNum = 5)
    r1.recurssionToPrintNumber()
    println()
    printNameNtimes(0, 5)
    println()
    printNumbersToN(1, 10)
    println()
    printNumberNto1(5)
    println()
    print("Sum of numbers upto 3 is ${printSumOfFirstNNumbers(3)}")
    println()
    print("5! is ${factorialOfNumber(5)}")
    println()
    val testArray = arrayListOf(1, 2, 3, 4, 5)
    println("Test Array = $testArray")
    reverseTheArray(testArray, 0, testArray.size-1)
    println("Reversed Array = $testArray")
    println()
    val str = "ababab"
    println("String = $str isPalindrome = ${isPalindrome(str, 0)}")
    println()
    val nThFibo = 10
    print("${nThFibo}th fibonacci number is ${findNthFibonacciNumber(nThFibo)}")
}


class RecurssionToPrintNumber(val maxNum: Int) {
    var count: Int = 1
    fun recurssionToPrintNumber() {
        if(count <= maxNum) {
            print("$count ")
            count++
            recurssionToPrintNumber()
        } else {
            return
        }
    }
}

fun printNameNtimes(i: Int, n: Int) {
    if (i < n) {
        print("NAME ")
        printNameNtimes(i = i + 1, n = n)
    } else {
        return
    }
}

fun printNumbersToN(i: Int, n: Int) {
    if(i <= n) {
        print("$i ")
        printNumbersToN(i = i+1, n = n)
    } else {
        return
    }
}

fun printNumberNto1(n: Int) {
    if(n < 1) return

    print("$n ")
    printNumberNto1(n-1)
}

fun printSumOfFirstNNumbers(n: Int): Int {
    if(n < 1) return 0

    return n + printSumOfFirstNNumbers(n-1)
}

fun factorialOfNumber(n: Int): Int {
    if(n < 1) return 1

    return n * factorialOfNumber(n-1)
}

fun reverseTheArray(array: ArrayList<Int>, start: Int, end: Int) {
    if(start < end) {
        val temp = array[start]
        array[start] = array[end]
        array[end] = temp

        reverseTheArray(array, start+1, end-1)
    }
}

fun isPalindrome(str: String, position: Int): Boolean {
    if(position < str.length/2) return true

    if(str.get(position) == str.get(str.length-position-1)) {
        return isPalindrome(str = str, position = position+1)
    } else {
        return false
    }
}

// Intuition:
// In this approach, instead of printing the Fibonacci series till N, we’re going to print the Nth Fibonacci number using functional recursion with multiple function calls.
// One may wonder how multiple-function calls work. Let’s understand through an illustration below:

// Similar kinds of multiple-function calls would be used in implementing the Fibonacci series where any Nth Fibonacci number can be written as a sum of (N-1)th and (N-2)th Fibonacci numbers. So, the function result would look like this:
// Fibonacci(N) = Fibonacci(N-1) + Fibonacci(N-2)
// Results from both the function calls would be summed and returned to the main function call.

// Approach:
// Similar to all the recursion problems we’ve seen before, we need a base case in this problem too in order for recursion to not go infinitely. Here, we notice that the Fibonacci series start from N = 1, where we initialize its value as 1. 
// Assume Fibonacci(0) = 0. So, Fibonacci(2) = 1+0 = 1 as the Nth Fibonacci number is the sum of the previous two Fibonacci numbers.
// Similarly, we call Fibonacci(N-1) and Fibonacci(N-2) and return their sum. Both the function calls Fibonacci(N-1) and Fibonacci(N-2) would be computed individually one by one until the base condition is reached for both and then they return back to the main function.


fun findNthFibonacciNumber(number: Int): Int {
    if(number <= 1) {
        return number
    }

    val last = findNthFibonacciNumber(number - 1)
    val sLast = findNthFibonacciNumber(number - 2)

    return last + sLast
}