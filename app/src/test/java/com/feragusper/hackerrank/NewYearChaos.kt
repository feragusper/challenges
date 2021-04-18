import java.util.*

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
    var ans = 0
    for (i in q.size - 1 downTo 0) {
        val ch_pos: Int = q[i] - (i + 1)
        if (ch_pos > 2) {
            println("Too chaotic")
            return
        } else {
            //find starting index
            //range[num-2, arr.length] or 0 to length
            val st = Math.max(0, q[i] - 2)
            for (j in st until i) {
                if (q[j] > q[i]) ans++
            }
        }
    }
    println(ans)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
