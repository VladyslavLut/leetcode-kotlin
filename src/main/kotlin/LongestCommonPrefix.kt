class LongestCommonPrefix {
    class Solution {
        fun longestCommonPrefix(strings: Array<String>): String {
            val minLength = strings.minOf { it.length }
            var low = 1
            var high = minLength
            while (low <= high) {
                val middle = (low + high) / 2
                if (isCommonPrefix(strings, middle))
                    low = middle + 1
                else
                    high = middle - 1
            }
            return strings.first().substring(0, (low + high) / 2)
        }

        private fun isCommonPrefix(strings: Array<String>, length: Int): Boolean {
            val string = strings.first().substring(0, length)
            for (index in 1 until strings.size) {
                if (!strings[index].startsWith(string)) return false
            }
            return true
        }
    }
}