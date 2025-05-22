import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val cnt = br.readLine().toInt()
    val lines = Array(cnt) { br.readLine() }
    val result = p1032(lines)

    bw.write(result)
    bw.flush()
    bw.close()
}

fun p1032(lines: Array<String>): String {
    val sb = StringBuilder()
    val textLength = lines.first().length

    for (idx in 0..<textLength) {
        val idxCharacters = lines.map { it[idx] }
        val indicateCharacter = idxCharacters.first()
        val isAllSame = idxCharacters.all { it == indicateCharacter }

        sb.append(if (isAllSame) indicateCharacter else '?')
    }

    return sb.toString()
}
