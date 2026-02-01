object ClimbingStairs {
    class Solution {
        fun climbStairs(n: Int): Int {
            if (n == 0) return 0
            if (n == 1) return 1

            var first = 0
            var second = 1

            repeat(n) {
                val steps = first + second
                first = second
                second = steps
            }
            return second
        }
    }
}
