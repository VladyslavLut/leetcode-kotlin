import kotlin.math.min

class LongestCommonPrefix {
    class BinSearchSolution {
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

    class SplitAndConquerSolution {
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

    class VerticalScanSolution {
        fun longestCommonPrefix(strings: Array<String>): String {
            val firstString = strings.first()
            for (charIndex in firstString.indices) {
                val char = firstString[charIndex]
                for (index in 1 until strings.size) {
                    val string = strings[index]
                    if (charIndex == string.length || char != string[charIndex]) {
                        return string.substring(0 until charIndex)
                    }
                }
            }
            return firstString
        }
    }

    class HorizontalScanSolution {
        fun longestCommonPrefix(strings: Array<String>): String {
            var commonPrefix = strings.first()
            for (index in strings.indices) {
                val string = strings[index]
                while (string.indexOf(commonPrefix) != 0) {
                    commonPrefix = commonPrefix.dropLast(1)
                }
                if (commonPrefix.isEmpty()) return ""
            }
            return commonPrefix
        }
    }
}