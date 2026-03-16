import kotlin.math.max
import kotlin.math.min

class MaximalSquare {
    private val solution = CachedRecursiveSolution()

    fun maximalSquare(matrix: Array<CharArray>): Int {
        val size = solution.maximalSquare(matrix)
        return size
    }
}

private class SimpleRecursiveSolution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        return scan(matrix, 0, 0).maxSize.let { it * it }
    }

    fun scan(matrix: Array<CharArray>, x: Int, y: Int): Square {
        val topLeft = matrix[y][x].digitToInt()

        if (y == matrix.lastIndex && x == matrix[0].lastIndex) {
            return Square(topLeft)
        }

        val right =
            if (x == matrix[0].lastIndex) Square(0)
            else scan(matrix, x + 1, y)

        val below =
            if (y == matrix.lastIndex) Square(0)
            else scan(matrix, x, y + 1)

        val bottomRight = matrix[y + below.size][x + right.size].digitToInt()

        val size =
            if (topLeft == 0) 0
            else (min(right.size, below.size) + min(topLeft, bottomRight))

        return Square(
            size = size,
            maxSize = max(size, max(right.maxSize, below.maxSize))
        )
    }

    data class Square(
        val size: Int,
        val maxSize: Int = size,
    )
}

private class CachedRecursiveSolution {
    private var max = 0

    fun maximalSquare(matrix: Array<CharArray>): Int {
        val cache = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }
        scan(matrix, 0, 0, cache)
        return max * max
    }

    fun scan(matrix: Array<CharArray>, x: Int, y: Int, cache: Array<IntArray>): Int {
        if (y > matrix.lastIndex || x > matrix[0].lastIndex) {
            return 0
        }

        if (cache[y][x] != -1) {
            return cache[y][x]
        }

        val topLeft = matrix[y][x]
        val right = scan(matrix, x + 1, y, cache)
        val down = scan(matrix, x, y + 1, cache)

        cache[y][x] = when {
            topLeft == '0' -> 0
            else -> {
                val size = min(right, down)
                val bottomRight = matrix[y + size][x + size]
                if (bottomRight == '0') size
                else (size + 1)
            }
        }

        val result = cache[y][x]
        if (result > max) {
            max = result
        }
        return result
    }
}

private class CachedDiagonalRecursiveSolution {
    private var max = 0

    fun maximalSquare(matrix: Array<CharArray>): Int {
        val cache = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }
        scan(matrix, 0, 0, cache)
        return max * max
    }

    fun scan(matrix: Array<CharArray>, x: Int, y: Int, cache: Array<IntArray>): Int {
        if (y > matrix.lastIndex || x > matrix[0].lastIndex) {
            return 0
        }

        if (cache[y][x] != -1) {
            return cache[y][x]
        }

        val topLeft = matrix[y][x].digitToInt()
        val right = scan(matrix, x + 1, y, cache)
        val bottom = scan(matrix, x, y + 1, cache)
        val bottomRight = scan(matrix, x + 1, y + 1, cache)

        cache[y][x] = when {
            topLeft == 0 -> 0
            else -> minOf(right, bottom, bottomRight) + 1
        }

        val result = cache[y][x]
        max = max(max, result)
        return result
    }
}
