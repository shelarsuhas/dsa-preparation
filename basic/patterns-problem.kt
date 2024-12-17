/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    printSimpleStarPattern(height = 4)
    println()
    printSimpleNumberPattern(height = 4)
    println()
    printRepeatingNumberPattern(height = 4)
    println()
    printInvertedSimpleStarPattern(height = 4)
    println()
    printInvertedSimpleNumberPattern(height = 4)
    println()
    printSimplePyramidPattern(height = 4)
    println()
    printInverseSimplePyramidPattern(height = 4)
    println()
    printHalfDiamondPattern(height = 4)
    println()
    printBinaryTriangle(height = 4)
    println()
    printVshapeNumbers(height = 4)
    println()
    printNumericTriangle(height = 4)
    println()
    printAlphabetTriangle(height = 4)
    println()
    printInsideDiamondPattern(height = 4)
}


/**
 *  this will print simple pattern
 * 	#
 * 	# #
 *  # # #
**/ 
fun printSimpleStarPattern(height: Int) {
    for(i in 0..height-1) {
        for(j in 0..i) {
            print("* ")
        }
        println()
    }
}

/**
 *  this will print simple pattern
 * 	1
 * 	1 2
 *  1 2 3
**/ 
fun printSimpleNumberPattern(height: Int) {
    for(i in 1..height) {
        for(j in 1..i) {
            print("$j ")
        }
        println()
    }
}

/**
 *  this will print simple pattern
 * 	1
 * 	2 2
 *  3 3 3
**/
fun printRepeatingNumberPattern(height: Int) {
    for(i in 1..height) {
        for(j in 1..i) {
            print("$i ")
        }
        println()
    }
}

/**
 *  this will print inverted simple pattern
 * 	# # #
 * 	# #
 *  #
**/ 
fun printInvertedSimpleStarPattern(height: Int) {
    for(i in height-1 downTo 0) {
        for(j in 0..i) {
            print("* ")
        }
        println()
    }
}

/**
 *  this will print inverted simple pattern
 * 	1 2 3
 * 	1 2
 *  1
**/ 
fun printInvertedSimpleNumberPattern(height: Int) {
    for(i in height downTo 1) {
        for(j in 1..i) {
            print("$j ")
        }
        println()
    }
}

/**
 * this will print simple pyramid pattern
 *    #
 *   ###
 *  #####
 * #######
**/ 
fun printSimplePyramidPattern(height: Int) {
    for(i in 0..height-1) {
        for(j in 0..height-i-1) {
            print(" ")
        }
        
        for(j in 0 until (i*2)+1) {
        	print("*")
        }
        println()
    }
}

/**
 * this will print inverted simple pattern
 * 	#######
 * 	 #####
 * 	  ###
 * 	   #
**/ 
fun printInverseSimplePyramidPattern(height: Int) {
    for(i in height-1 downTo 0) {
        for(j in 0..height-i-1) {
            print(" ")
        }
        
        for(j in 0 until (i*2)+1) {
            print("*")
        }
        
        println()
    }
}

/**
 * this will print simple diamond pattern
 * #
 * ##
 * ###
 * ####
 * ###
 * ##
 * #
**/
fun printHalfDiamondPattern(height: Int) {
    for(i in 0 until 2*height+1) {
        val stars = if(i>height) 2*height-i else i
        for(j in 0..stars) {
            print("*")
        }
        println()
    }
}

/**
 * this will print binary triangle
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
**/

fun printBinaryTriangle(height: Int) {
    for(i in 0 until height) {
        var number = if(i%2 == 0) 1 else 0
        for(j in 0..i) {
            print(number)
            number = 1 - number
        }
        println()
    }
}

/**
 * this will print binary triangle
 * 1      1
 * 12    21
 * 123  321
 * 12344321
**/
fun printVshapeNumbers(height: Int) {
    for(i in 1 until height+1) {
        for(j in 1..i) {
            print(j)
        }
        
        if(i != height) {
            for(j in 1..(height*2 - 2*i)) {
                print(" ")
            }
        }

        for(j in i downTo 1) {
            print(j)
        }
        
       println()
    }
}

/**
 * this will print numeric triangle
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
**/
fun printNumericTriangle(height: Int) {
    var number = 0
    for(i in 0 until height) {
        for(j in 0..i) {
            print("${++number} ")
        }
        println()
    }
}

/**
 * this will print alphabet triangle
 * A
 * A B
 * A B C
 * A B C D
**/
fun printAlphabetTriangle(height: Int) {
    for(i in 0 until height) {
        for(j in 'A'..'A'+i) {
            print("$j ")
        }
        println()
    }
}

/**
 * this will print inside diamond pattern
 * ########
 * ### 	###
 * ##    ##
 * #      #
 * #      #
 * ##    ##
 * ###  ###
 * ########
**/
fun printInsideDiamondPattern(height: Int) {
    var space = 0
    for(i in 0 until ((height*2))) {
        val range = if(i > height) {
            i+1 - height
        } else if (i == height) {
            1
        } else {
            height - i
        }
        
        for(j in 0 until range) {
            print("*")
        }
        for(j in 0 until space*2) {
            print(" ")
        }
        
        for(j in 0 until range) {
            print("*")
        }
        println()
        
        if(i < height-1) {
            space++
        } else if(i == height-1) {
            // do nothing
        } else {
            space--
        }
    }
}












