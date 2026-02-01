object DivideArrayInSubarrays {
    class Solution {
        fun minimumCost(nums: IntArray): Int {
            var (a, b, c) = nums
            for (index in 3 until nums.size) {
                val number = nums[index]
                if (number <= c || number <= b) {
                    if (c <= b) {
                        b = c
                    }
                    c = number
                }
            }
            return a + b + c
        }
    }
}