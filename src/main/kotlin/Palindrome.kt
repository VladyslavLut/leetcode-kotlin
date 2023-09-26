import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.log10

class Palindrome {

    class Solution1 {
        fun isPalindrome(x: Int): Boolean {
            if (x < 0) {
                return false
            } else if (x < 10) {
                return true
            } else if (x < 100) {
                return x % 11 == 0
            } else if (x % 10 == 0) {
                return false
            }

            var number = x
            val size = ceil(log10(number.toDouble())).toInt()
            val halfSize = size / 2
            val digits = IntArray(halfSize + 1) { -1 }

            for (i in -halfSize..halfSize) {
                if (i == 0 && size % 2 == 0) {
                    continue
                }
                val index = abs(i)
                val digit = number % 10
                val saved = digits[index]
                if (saved != -1 && saved != digit) {
                    return false
                }
                digits[index] = digit
                number /= 10
            }

            return true
        }
    }

    class Solution {
        fun isPalindrome(x: Int): Boolean {
            if (x < 0) {
                return false
            } else if (x < 10) {
                return true
            }

            var number = x
            val size = log10(number.toDouble()).toInt()
            val halfSize = size / 2
            val digits = IntArray(halfSize + 1) { -1 }

            for (i in 0..size) {
                val digit = number % 10
                val index = if (i <= halfSize) i else size - i
                val saved = digits[index]
                if (saved != -1 && saved != digit) {
                    return false
                }
                digits[index] = digit
                number /= 10
            }

            return true
        }
    }
}