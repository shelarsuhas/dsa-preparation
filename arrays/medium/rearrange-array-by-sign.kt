import java.util.Arrays

// https://takeuforward.org/arrays/rearrange-array-elements-by-sign/
fun main() {
    rearrangeArrayBySign(intArrayOf(1,-2,2,-3,5,-4))
    rearrangeArrayBySign(intArrayOf(1,2,3,-1,-2,-3))
}

fun rearrangeArrayBySign(
    arr: IntArray
) {
    var posIndex = 0
    var negIndex = 1
    val result = IntArray(arr.size)

    for(i in arr.indices) {
        if(arr[i] > 0) {
            result[posIndex] = arr[i]
            posIndex += 2
        } else {
            result[negIndex] = arr[i]
            negIndex += 2
        }
    }

    println("result = ${Arrays.toString(result)}")
}
