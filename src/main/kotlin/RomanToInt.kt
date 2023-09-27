import java.util.HashMap

class RomanToInt {
    class Solution {
        private val romans = HashMap<Char, Int>(7).apply {
            put('I', 1)
            put('V', 5)
            put('X', 10)
            put('L', 50)
            put('C', 100)
            put('D', 500)
            put('M', 1000)
        }

        fun romanToInt(s: String): Int {
            var result = 0
            var lastNumber = 0
            for (index in s.indices.reversed()) {
                val number = romans[s[index]]!!
                // true.compareTo(true) -> 0
                // true.compareTo(false) -> 1
                // false.compareTo(true) -> -1
                // false.compareTo(false) -> 0
                result += number * (number >= lastNumber).compareTo(number < lastNumber)
                lastNumber = number
            }
            return result
        }
    }
}
