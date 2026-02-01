object Fibonacci {
    class BottomUpSolution {
        fun fib(n: Int): Int {
            if (n == 0) return 0
            if (n == 1) return 1

            val numbers = IntArray(n + 1)
            numbers[1] = 1
            for (index in 2 .. n) {
                numbers[index] = numbers[index - 1] + numbers[index - 2]
            }
            return numbers.last()
        }
    }

    class RecursiveSolution {
        fun fib(n: Int): Int {
            return when (n) {
                0 -> 0
                1 -> 1
                else -> fib(n - 1) + fib(n - 2)
            }
        }
    }

    class RecursiveCacheSolution {
        fun fib(n: Int): Int {
            val numbers = IntArray(n + 1) { -1 }
            return when (n) {
                0 -> 0
                1 -> 1
                else -> {
                    numbers[0] = 0
                    numbers[1] = 1
                    fib(n, numbers)
                }
            }
        }

        private fun fib(n: Int, numbers: IntArray): Int {
            val first = numbers[n - 1].takeIf { it >= 0 } ?: fib(n - 1, numbers)
            val second = numbers[n - 2].takeIf { it >= 0 } ?: fib(n - 1, numbers)
            val number = first + second
            numbers[n] = number
            return number
        }
    }
}