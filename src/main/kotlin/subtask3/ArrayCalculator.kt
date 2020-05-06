package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var result = 1
        var negativeCount = 0
        var containsSringArray = false
        var neg = false
        var stringCount = 0
        itemsFromArray.forEach {
            if (it is String) true
        }
        var arraySize = itemsFromArray.size
        if (numberOfItems == arraySize && !containsSringArray) {
            itemsFromArray.forEach { it ->
                if (it is Int) {
                    result *= it
                } else {
                    result = 0
                }
            }
        }

        if (numberOfItems < arraySize && !containsSringArray) {
            itemsFromArray.forEach {
                if (it.toString().contains("-")) neg = true
                if (it is String) stringCount++
            }
            if (neg && numberOfItems < itemsFromArray.size - stringCount) {
                val dest: IntArray = itemsFromArray.toList()
                    .map { i -> i.toString().toInt() }
                    .toIntArray()
                var sortedArray = bubbleSort(dest).reversedArray()
                println(sortedArray.contentToString())
                for (i in 0..(numberOfItems - 1)) {
                    if (sortedArray.get(i).toString().contains("-")) {
                        negativeCount++
                    }
                }
                if (negativeCount % 2 == 0) {
                    for (i in 0..(numberOfItems - 1)) {
                        result *= sortedArray.get(i)!!
                    }
                    return result
                }
                var positiveArray = arrayListOf<Int?>()
                if (negativeCount % 2 != 0) {
                    sortedArray.forEach {
                        if (!it.toString().contains("-")) {
                            positiveArray.add(it)
                        }
                    }
                    for (i in 0..numberOfItems - 1) {
                        println(positiveArray[i].toString())
                        result *= positiveArray[i]!!
                    }
                    return result
                }
            }

            itemsFromArray.forEach {
                if (it is Int) {
                    result *= it
                }
            }
        }
        if (numberOfItems > arraySize && !containsSringArray) {
            itemsFromArray.forEach {
                if (it is Int) {
                    result *= it
                }
            }
        }
        return result
    }

    fun bubbleSort(arr: IntArray): Array<Int?> {
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until arr.size - 1) {
                if (arr[i].absoluteValue > arr[i + 1].absoluteValue) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp

                    swap = true
                }
            }
        }
        val array: Array<Int?> = arrayOfNulls(arr.size)
        for (i in arr.indices) {
            array[i] = Integer.valueOf(arr[i])
        }
        return array
    }
}
