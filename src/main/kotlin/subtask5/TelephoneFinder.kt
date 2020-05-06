package subtask5

import java.util.Arrays.asList

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.isEmpty() || number.contains("-")) return null else {
            var result = mutableListOf<String>()
            var isSingle = number.length == 1
            number.forEachIndexed { i, k ->
                if (isSingle) {
                    getNgb(Character.getNumericValue(k)).forEach {
                        result.add("$it")
                    }
                } else {
                    getNgb(Character.getNumericValue(k)).forEach {
                        result.add(number.replaceRange(i..i, "$it"))
                    }
                }
            }
            return result.toTypedArray()
        }

    }

    fun getNgb(value: Int): MutableList<Int> {
        var neigb = mutableListOf<Int>()
        when (value) {
            0 -> neigb.addAll(0, asList(8))
            1 -> neigb.addAll(0, asList(2, 4))
            2 -> neigb.addAll(0, asList(1, 3, 5))
            3 -> neigb.addAll(0, asList(2, 6))
            4 -> neigb.addAll(0, asList(1, 5, 7))
            5 -> neigb.addAll(0, asList(2, 4, 6, 8))
            6 -> neigb.addAll(0, asList(3, 5, 9))
            7 -> neigb.addAll(0, asList(4, 8))
            8 -> neigb.addAll(0, asList(5, 7, 9, 0))
            9 -> neigb.addAll(0, asList(6, 8))
        }
        return neigb
    }
}
