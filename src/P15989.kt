import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val cnt: Int = br.readLine().toInt()
    val values = List(cnt) { br.readLine().toInt() }
    val result = p15989(values)

    bw.write(result)
    bw.flush()
    bw.close()
}

fun p15989(values: List<Int>): String {
    val maxN = values.max()
    val dp = Array(maxOf(maxN + 1, 4)) { IntArray(4) }

    dp[1] = intArrayOf(0, 1, 0, 0)
    dp[2] = intArrayOf(0, 1, 1, 0)
    dp[3] = intArrayOf(0, 1, 1, 1)

    for (i in 4..maxN) {
        dp[i][1] = dp[i - 1][1]
        dp[i][2] = dp[i - 2][1] + dp[i - 2][2]
        dp[i][3] = dp[i - 3].sum()
    }

    return values.joinToString("\n") { value -> dp[value].sum().toString() }
}
