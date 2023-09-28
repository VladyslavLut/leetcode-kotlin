import kotlin.math.min

class LongestCommonPrefix {
    class Solution {
        fun longestCommonPrefix(strings: Array<String>): String {
            return longestCommonPrefix(strings, 0, strings.lastIndex)
        }

        private fun longestCommonPrefix(strings: Array<String>, left: Int, right: Int): String {
            if (left == right) return strings[left]
            val middle = (left + right) / 2
            val leftPrefix = longestCommonPrefix(strings, left, middle)
            val rightPrefix = longestCommonPrefix(strings, middle + 1, right)
            return commonPrefix(leftPrefix, rightPrefix)
        }

        private fun commonPrefix(left: String, right: String): String {
            val max = min(left.length, right.length)
            for (index in 0 until max) {
                if (left[index] != right[index]) {
                    return left.substring(0 until index)
                }
            }
            return left.substring(0 until max)
        }
    }
}