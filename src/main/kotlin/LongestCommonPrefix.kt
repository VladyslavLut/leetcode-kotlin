class LongestCommonPrefix {
    class Solution {
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