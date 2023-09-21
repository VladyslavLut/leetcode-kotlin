class TwoSum {
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val map = HashMap<Int, Int>(nums.size)
            for (index in nums.indices) {
                val number = nums[index]
                val storedIndex = map[number]
                if (storedIndex != null) {
                    return intArrayOf(storedIndex, index)
                }
                map[target - number] = index
            }
            return IntArray(0)
        }
    }
}