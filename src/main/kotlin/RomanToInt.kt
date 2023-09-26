class RomanToInt {
    class Solution {
        private val romans = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )

        fun romanToInt(s: String): Int {
            var result = 0
            var lastNumber = 0
            for (index in s.indices.reversed()) {
                val number = romans.getValue(s[index])

                if (number < lastNumber) {
                    result -= number
                } else {
                    result += number
                }

                lastNumber = number
            }
            return result
        }
    }
}