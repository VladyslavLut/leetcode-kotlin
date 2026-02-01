object Tribonacci {
    class Solution {
        fun tribonacci(n: Int): Int {
            if (n == 0) return 0
            if (n == 1 || n == 2) return 1

            var first = 0
            var second = 1
            var third = 1
            var number = 2

            repeat(n - 2) {
                number = first + second + third
                first = second
                second = third
                third = number
            }
            return number
        }
    }
}