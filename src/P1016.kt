import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val line = br.readLine()
    val result = p1016(line)

    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun p1016(line: String): Int {
    val (minVal, maxVal) = line.split(" ").map { it.toLong() }
    val isSquares = BooleanArray((maxVal - minVal + 1).toInt())

    val maxValSqrt = ceil(sqrt(maxVal.toDouble())).toInt()
    val isPrimes = BooleanArray(maxValSqrt + 1) { true }

    for (prime in 2..maxValSqrt) {
        if (!isPrimes[prime]) continue

        for (primeMultiple in 2 * prime..maxValSqrt step prime) {
            isPrimes[primeMultiple] = false
        }

        val primeSquare = (prime.toLong()) * (prime.toLong())

        val startMultiplier: Long = ceil(minVal / primeSquare.toDouble()).toLong()
        val endMultiplier: Long = floor(maxVal / primeSquare.toDouble()).toLong()

        for (multiplier in startMultiplier..endMultiplier) {
            val primeSquareMultiplier = multiplier * primeSquare
            val primeSquareIdx: Int = (primeSquareMultiplier - minVal).toInt()

            isSquares[primeSquareIdx] = true
        }
    }

    return isSquares.count { !it }
}
