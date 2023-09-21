import org.testng.annotations.Test

class TwoSumTest {

    @Test
    fun `TwoSum test 1`() {
        val solution = TwoSum.Solution()
        val numbers = intArrayOf(2, 7, 11, 15)
        val target = 9
        val correct = intArrayOf(0, 1)

        val indices = solution.twoSum(numbers, target)

        assert(indices.contentEquals(correct)) {
            "\nExpected: [${correct.joinToString()}]\nActual: [${indices.joinToString()}]"
        }
    }

    @Test
    fun `TwoSum test 2`() {
        val solution = TwoSum.Solution()
        val numbers = intArrayOf(3, 2, 4)
        val target = 6
        val correct = intArrayOf(1, 2)

        val indices = solution.twoSum(numbers, target)

        assert(indices.contentEquals(correct)) {
            "\nExpected: [${correct.joinToString()}]\nActual: [${indices.joinToString()}]"
        }
    }

    @Test
    fun `TwoSum test 3`() {
        val solution = TwoSum.Solution()
        val numbers = intArrayOf(3, 3)
        val target = 6
        val correct = intArrayOf(0, 1)

        val indices = solution.twoSum(numbers, target)

        assert(indices.contentEquals(correct)) {
            "\nExpected: [${correct.joinToString()}]\nActual: [${indices.joinToString()}]"
        }
    }

    @Test
    fun `TwoSum test 4`() {
        val solution = TwoSum.Solution()
        val numbers = intArrayOf(-2, 9, -1, 8, -4)
        val target = -5
        val correct = intArrayOf(2, 4)

        val indices = solution.twoSum(numbers, target)

        assert(indices.contentEquals(correct)) {
            "\nExpected: [${correct.joinToString()}]\nActual: [${indices.joinToString()}]"
        }
    }

    @Test
    fun `TwoSum test 5`() {
        val solution = TwoSum.Solution()
        val numbers = intArrayOf(-1, 1, -2, 9, -4)
        val target = 7
        val correct = intArrayOf(2, 3)

        val indices = solution.twoSum(numbers, target)

        assert(indices.contentEquals(correct)) {
            "\nExpected: [${correct.joinToString()}]\nActual: [${indices.joinToString()}]"
        }
    }

    @Test
    fun `TwoSum test 6`() {
        val solution = TwoSum.Solution()
        val numbers = intArrayOf(-1, 1, 9, 0, -4)
        val target = 5
        val correct = intArrayOf(2, 4)

        val indices = solution.twoSum(numbers, target)

        assert(indices.contentEquals(correct)) {
            "\nExpected: [${correct.joinToString()}]\nActual: [${indices.joinToString()}]"
        }
    }

}