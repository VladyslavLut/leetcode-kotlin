class RomanToInt {
    class Solution {
        enum class Roman(val value: Int) {
            I(1),
            V(5),
            X(10),
            L(50),
            C(100),
            D(500),
            M(1000),
        }

        fun romanToInt(s: String): Int {
            var result = 0
            var lastNumber = 0
            for (index in s.indices.reversed()) {
                val number = Roman.valueOf(s[index].toString()).value

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