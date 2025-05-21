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
    val textLength = lines[0].length

    for (textIdx in 0..<textLength) {
        var currentText = lines[0][textIdx]
        for (line in lines) {
            if (line[textIdx] != currentText) {
                currentText = '?'
                break
            }
        }
        sb.append(currentText)
    }

    return sb.toString()
}
