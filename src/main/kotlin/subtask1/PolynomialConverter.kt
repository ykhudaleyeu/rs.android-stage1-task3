package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (!numbers.isEmpty()) {
            val arrayLast = numbers
            val array = ArrayList<String>()
            val last = numbers.get(numbers.size - 1)
            var endStr = ""
            var index = numbers.size - 1
            var i = 0
            arrayLast.forEach {
                if (i != arrayLast.lastIndex)
                    array.add("${it}x^${index}")
                index--
                i++
            }
            array.forEach {
                if (!it.contains("0x^")) {
                    endStr += "$it + "
                }
            }
            return "$endStr$last".replace("+ -1", "- ").replace("^1", "").replace("+ -", "- ")
        } else {
            return null
        }
    }
}
