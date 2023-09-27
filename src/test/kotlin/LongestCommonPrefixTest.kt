import org.testng.annotations.Test

class LongestCommonPrefixTest {
    @Test
    fun `LongestCommonPrefixTest test 1`() {
        val solution = LongestCommonPrefix.Solution()
        val strings = arrayOf("flower","flow","flight")

        val prefix = solution.longestCommonPrefix(strings)

        assert(prefix == "fl") {
            "\nExpected: ${strings.joinToString()} prefix='fl'\nActual: prefix=$prefix"
        }
    }

    @Test
    fun `LongestCommonPrefixTest test 2`() {
        val solution = LongestCommonPrefix.Solution()
        val strings = arrayOf("dog","racecar","car")

        val prefix = solution.longestCommonPrefix(strings)

        assert(prefix == "") {
            "\nExpected: ${strings.joinToString()} prefix=''\nActual: prefix=$prefix"
        }
    }

    @Test
    fun `LongestCommonPrefixTest test 3`() {
        val solution = LongestCommonPrefix.Solution()
        val strings = arrayOf("apple","applepie","pineapple")

        val prefix = solution.longestCommonPrefix(strings)

        assert(prefix == "") {
            "\nExpected: ${strings.joinToString()} prefix=''\nActual: prefix=$prefix"
        }
    }

    @Test
    fun `LongestCommonPrefixTest test 4`() {
        val solution = LongestCommonPrefix.Solution()
        val strings = arrayOf("apple","applepie","applejam")

        val prefix = solution.longestCommonPrefix(strings)

        assert(prefix == "apple") {
            "\nExpected: ${strings.joinToString()} prefix='apple'\nActual: prefix=$prefix"
        }
    }

    @Test
    fun `LongestCommonPrefixTest test 5`() {
        val solution = LongestCommonPrefix.Solution()
        val strings = arrayOf("")

        val prefix = solution.longestCommonPrefix(strings)

        assert(prefix == "") {
            "\nExpected: ${strings.joinToString()} prefix=''\nActual: prefix=$prefix"
        }
    }
}