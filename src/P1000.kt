import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val line = br.readLine()
    val result = p1000(line)

    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun p1000(line: String): Int {
    val (a, b) = line.split(" ").map { it.toInt() }
    return a + b
}
