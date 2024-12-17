fun main() {
    countNumbers(100)
    countNumbers(43928)
    println()
    countNumberOptimally(100)
    countNumberOptimally(23123)
    println()
    reverseNumber(54321)
    reverseNumber(0)
    println()
    isPalindrome(123)
    isPalindrome(121212121)
    println()
    gcdOfNumber(9, 12)
    println()
    gcdUsingEuclidean(25, 75)
    println()
    isArmstrongNumber(153)
    println()
    findAllDivisors(12)
    println()
    println()
    isPrime(21)
}

fun countNumbers(input: Long) {
    var count = 0
    var localInput = input
    while(localInput > 0) {
        count++
        localInput = localInput/10
    }
    
    println("Count = $count")
}

fun countNumberOptimally(input: Long) {
    // The expression (int)(Math.log10(n) + 1)
    // calculates the number of digits in 'n'
    // and casts it to an integer.

    // Adding 1 to the result accounts
    // for the case when 'n' is a power of 10,
    // ensuring that the count is correct.

    // Finally, the result is cast
    // to an integer to ensure it is rounded
    // down to the nearest whole number.

    // Return the count of digits in 'n'.
    val count = (Math.log10(input.toDouble()) + 1).toInt()
    println("Count = $count")
}

fun reverseNumber(input: Long) {
    var localInput = input
    var output: Long = 0L
    while(localInput > 0) {
        output = (output * 10) + (localInput % 10)
        localInput = localInput/10
    }
    println("Number = $input Reverse = $output")
}

fun isPalindrome(input: Int) {
    var localInput = input
    var reverse = 0
    while(localInput > 0) {
        reverse = (reverse * 10) + (localInput % 10)
        localInput = localInput/10
    }

    println("Input = $input isPalindrome = ${input == reverse}")
}

fun gcdOfNumber(input1: Int, input2: Int) {
    val minNum = Math.min(input1, input2)
    var gcd = 1
    for(i in 1..minNum) {
        if((input1%i == 0) && (input2%i == 0)) {
            gcd = i
        }
    }
    println("Input 1 = $input1 Input 2 = $input2 GCD = $gcd")
}

// The Euclidean Algorithm is a method for finding the greatest common divisor of two numbers. 
// It operates on the principle that the GCD of two numbers remains the same even if the smaller number is subtracted from the larger number.
fun gcdUsingEuclidean(input1: Int, input2: Int) {
    var localInput1 = input1
    var localInput2 = input2

    while(localInput1 > 0 && localInput2 > 0) {
        if(localInput1 > localInput2) {
            localInput1 = localInput1 % localInput2
        } else {
            localInput2 = localInput2 % localInput1
        }
    }

    if (localInput1 == 0) {
        println("Input 1 = $input1 Input 2 = $input2 GCD = $localInput2")
    } else {
        println("Input 1 = $input1 Input 2 = $input2 GCD = $localInput1")
    }
}

// An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
fun isArmstrongNumber(input: Int) {
    val count = (Math.log10(input.toDouble()) + 1).toInt()
    var localInput = input
    var sum = 0
    while(localInput > 0) {
        sum = (sum + Math.pow((localInput % 10).toDouble(), count.toDouble())).toInt()
        localInput = localInput/10
    }
    println("Input: $input isArmstrong: ${sum == input}")
}

// We can optimise the previous approach by using the property that for any non-negative integer n, if d is a divisor of n then n/d is also a divisor of n.
// This property is symmetric about the square root of n by traversing just the first half we can avoid redundant iteration and 
// computations improving the efficiency of the algorithm.
fun findAllDivisors(input: Int) {
    val divisors = ArrayList<Int>()
    for(i in 1..Math.sqrt(input.toDouble()).toInt()) {
        if(input%i == 0) {
            divisors.add(i)

            if(i != input/i) {
                divisors.add(input/i)
            }
        }
    }

    print("Divisors of $input are: ")
    for(i in divisors) {
        print("$i ")
    }
}

// Given an integer N, check whether it is prime or not. 
// A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.
fun isPrime(input: Int) {
    val divisors = ArrayList<Int>()
    for(i in 1..Math.sqrt(input.toDouble()).toInt()) {
        if(input % i == 0) {
            divisors.add(i)

            if(input/i != i) {
                divisors.add(input/i)
            }
        }
    }

    println("Input: $input isPrime: ${divisors.size == 2}")
}