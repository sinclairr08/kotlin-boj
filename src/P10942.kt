import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val cnt: Int = br.readLine().toInt()
    val values = br.readLine().split(" ").map { it.toInt() }

    val iteration = br.readLine().toInt()
    val idxPairs =
        Array(iteration) {
            val (sidx, eidx) = br.readLine().split(" ").map { it.toInt() }
            sidx to eidx
        }

    // val values = List(cnt) { br.readLine().toInt() }
    val result = p10942(values, idxPairs)

    bw.write(result)
    bw.flush()
    bw.close()
}

fun p10942(
    values: List<Int>,
    idxPairs: Array<Pair<Int, Int>>,
): String {
    val n = values.size
    val dp = Array(n + 1) { IntArray(n + 1) { -1 } }

    for (pair in idxPairs) {
        dfs(pair, dp, values)
    }

    return idxPairs.joinToString("\n") { idxPair -> dp[idxPair.first][idxPair.second].toString() }
}

fun dfs(
    pair: Pair<Int, Int>,
    dp: Array<IntArray>,
    values: List<Int>,
): Int {
    val sIdx = pair.first
    val eIdx = pair.second

    if (sIdx > eIdx) {
        return 1
    }

    if (dp[sIdx][eIdx] != -1) {
        return dp[sIdx][eIdx]
    }

    if (sIdx == eIdx) {
        dp[sIdx][eIdx] = 1
        return 1
    }

    val isInnerPalindrome = dfs(sIdx + 1 to eIdx - 1, dp, values)

    if (isInnerPalindrome == 0) {
        dp[sIdx][eIdx] = 0
        return 0
    }

    dp[sIdx][eIdx] = if (values[eIdx - 1] == values[sIdx - 1]) 1 else 0
    return dp[sIdx][eIdx]
}
