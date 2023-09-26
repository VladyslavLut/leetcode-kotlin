import org.testng.annotations.Test

class PalindromeTest {
    @Test
    fun `Palindrome test 1`() {
        val solution = Palindrome.Solution()
        val number = 121

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 2`() {
        val solution = Palindrome.Solution()
        val number = -121

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 3`() {
        val solution = Palindrome.Solution()
        val number = 10

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 4`() {
        val solution = Palindrome.Solution()
        val number = 55555

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 5`() {
        val solution = Palindrome.Solution()
        val number = -1678988761

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 6`() {
        val solution = Palindrome.Solution()
        val number = -567898765

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 7`() {
        val solution = Palindrome.Solution()
        val number = 0

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 8`() {
        val solution = Palindrome.Solution()
        val number = Int.MAX_VALUE

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 9`() {
        val solution = Palindrome.Solution()
        val number = Int.MIN_VALUE

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 10`() {
        val solution = Palindrome.Solution()
        val number = 1000021

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 11`() {
        val solution = Palindrome.Solution()
        val number = 1000001

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 12`() {
        val solution = Palindrome.Solution()
        val number = 1

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 13`() {
        val solution = Palindrome.Solution()
        val number = 9

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 14`() {
        val solution = Palindrome.Solution()
        val number = 11

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 15`() {
        val solution = Palindrome.Solution()
        val number = 12

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 16`() {
        val solution = Palindrome.Solution()
        val number = 55

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 17`() {
        val solution = Palindrome.Solution()
        val number = 28

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 18`() {
        val solution = Palindrome.Solution()
        val number = 1001

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 19`() {
        val solution = Palindrome.Solution()
        val number = 10001

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == true) {
            "\nExpected: $number isPalindrome=true\nActual: $number isPalindrome=$isPalindrome"
        }
    }

    @Test
    fun `Palindrome test 20`() {
        val solution = Palindrome.Solution()
        val number = 100

        val isPalindrome = solution.isPalindrome(number)

        assert(isPalindrome == false) {
            "\nExpected: $number isPalindrome=false\nActual: $number isPalindrome=$isPalindrome"
        }
    }
}

//567898765
//500000000