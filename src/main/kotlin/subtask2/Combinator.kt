package subtask2

import java.math.BigInteger

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        var result = 0
        var color = array[1]
        var value = 0
        for (i in 1..array[0]) {
            if (result != array[0]) {
                result = findBiCoef(i, color).toInt()
                value = i
            }
        }
        if(result!=array[0]){
            return null
        }
        return value
    }
    fun findBiCoef(palletColorsCount: Int, postersCount: Int): BigInteger {
        var postersFact = factorial(postersCount)
        var colorsFact = factorial(palletColorsCount)
        var diff = postersCount - palletColorsCount
        var difFact = factorial(diff)
        var res = postersFact / (colorsFact * difFact)
        return res
    }

    fun factorial(num: Int): BigInteger {
        var factorial = BigInteger.ONE
        for (i in 1..num) {
            factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        }
        return factorial
    }
}



