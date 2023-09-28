class LongestCommonPrefix {
    class Solution {
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
}