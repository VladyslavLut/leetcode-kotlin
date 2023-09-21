class TwoSum {
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            for (index in 0 until (nums.size - 1)) {
                val first = nums[index]
                for (nextIndex in (index + 1) until nums.size) {
                    val second = nums[nextIndex]
                    if (first + second == target) {
                        return intArrayOf(index, nextIndex)
                    }
                }
            }
            return IntArray(0)
        }
    }
}