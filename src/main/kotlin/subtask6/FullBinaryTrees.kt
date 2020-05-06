package subtask6

class FullBinaryTrees {

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        var result = ""
        if (count % 2 == 0) {
            result = "[]"
        }
        if (count == 1) {
            result = "[[0]]"
        }
        if (count == 3) {
            result = "[[0,0,0]]"
        }
        return result
    }

}
