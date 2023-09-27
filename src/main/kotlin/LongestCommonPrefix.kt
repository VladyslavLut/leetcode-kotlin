class LongestCommonPrefix {
    class Solution {
        fun longestCommonPrefix(strings: Array<String>): String {
            var commonPrefix = strings.first()
            var index = commonPrefix.length
            for (string in strings) {
                if (string.isEmpty()) {
                    return ""
                }
                val delta = index - string.length
                if (delta > 0) {
                    commonPrefix = commonPrefix.dropLast(delta)
                    index = string.length
                }
                var prefix = string.substring(0, index)
                while (prefix != commonPrefix && index > 0) {
                    index--
                    prefix = prefix.dropLast(1)
                    commonPrefix = commonPrefix.dropLast(1)
                }
                if (index == 0) return ""
            }
            return commonPrefix
        }
    }
}