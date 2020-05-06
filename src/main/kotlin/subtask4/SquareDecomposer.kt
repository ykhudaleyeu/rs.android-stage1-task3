package subtask4

import java.util.*
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.math.sqrt

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        var result = LinkedList<Int>()
        when (isNumbNegative(number)) {
            0 -> return null
            else -> {
                var lastElement = number - 1
                result.addLast(lastElement)
                var sq1 = sqrtTwo(number)
                var sq2 = sqrtTwo(lastElement)
                var diff = sq1 - sq2
                decompose(diff, result)
                while (!isCorrect(number, result)) {
                    var it = result.lastIndex
                    for (i in it downTo 1) {
                        if (result[i] == 1 || result[i] == 0) {
                            result.removeLast()
                            continue
                        }
                        if (it > 0 && result[i] >= result[i - 1]) {
                            result.removeLast()
                        }
                    }
                    if (result.isEmpty()) break
                    val last = result.removeLast()
                    result.addLast(last - 1)
                    var sumOfSqr = 0
                    result.forEach {
                        sumOfSqr += sqrtTwo(it)
                    }
                    decompose(sqrtTwo(number) - sumOfSqr, result)
                }
                return if (result.isEmpty()) null else result.sorted().toTypedArray()

            }
        }
    }

    fun isNumbNegative(numb: Int): Int {
        if (numb < 3) return 0 else return 1
    }

    fun decompose(value: Int, numbers: LinkedList<Int>) {
        if (value == 0) return
        if (value == 1) {
            numbers.addLast(1); return
        }
        var last = numbers.last - 1
        var next = min(sqrt(value.toDouble()).toInt(), last)
        if (sqrtTwo(next) > value) next--
        numbers.addLast(next)
        if (next > 0) decompose(value - Math.pow(next.toDouble(), 2.0).roundToInt(), numbers)
    }

    fun isCorrect(number: Int, result: LinkedList<Int>): Boolean {
        var startValue = result.first
        var endValue = sqrtTwo(startValue)
        for (i in 1..result.size - 1) {
            if (startValue <= result[i]) return false
            endValue += sqrtTwo(result[i])
            startValue = result[i]
        }
        return sqrtTwo(number) == endValue
    }

    fun sqrtTwo(number: Int): Int {
        return Math.pow(number.toDouble(), 2.0).roundToInt()
    }
}
