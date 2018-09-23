package hackerearth.trustingsocial

class DetermineTheWinner {
}

fun main(args: Array<String>) {
    fun readInts() = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }

    (0 until readLine()!!.toInt()).forEach { _ ->
        val initialScoresLine = readInts()
        val decreaseRatesLine = readInts()
        val flashSubmissionsLine = readInts()
        val ciscoSubmissionsLine = readInts()

        val sp = initialScoresLine[0]
        val sq = initialScoresLine[1]
        val sr = initialScoresLine[2]
        val ss = initialScoresLine[3]

        val dp = decreaseRatesLine[0]
        val dq = decreaseRatesLine[1]
        val dr = decreaseRatesLine[2]
        val ds = decreaseRatesLine[3]

        val fp = flashSubmissionsLine[0]
        val fq = flashSubmissionsLine[1]
        val fr = flashSubmissionsLine[2]
        val fs = flashSubmissionsLine[3]

        val cp = ciscoSubmissionsLine[0]
        val cq = ciscoSubmissionsLine[1]
        val cr = ciscoSubmissionsLine[2]
        val cs = ciscoSubmissionsLine[3]

        val msp = sp / 2
        val msq = sq / 2
        val msr = sr / 2
        val mss = ss / 2

        val rsfp = sp - (dp * fp)
        val rsfq = sq - (dq * fq)
        val rsfr = sr - (dr * fr)
        val rsfs = ss - (ds * fs)

        val rscp = sp - (dp * cp)
        val rscq = sp - (dp * cq)
        val rscr = sp - (dp * cr)
        val rscs = sp - (dp * cs)

        val rsf = (if (rsfp > msp) rsfp else msp) + (if (rsfq > msq) rsfq else msq) + (if (rsfr > msr) rsfr else msr) + (if (rsfs > mss) rsfs else mss)
        val rsc = (if (rscp > msp) rscp else msp) + (if (rscq > msq) rscq else msq) + (if (rscr > msr) rscr else msr) + (if (rscs > mss) rscs else mss)
        val tsf = fp + fq + fr + fs
        val tsc = cp + cq + cr + cs

        if (rsf != rsc) {
            if (rsf > rsc) {
                println("Flash")
            } else {
                println("Cisco")
            }
        } else if (tsf != tsc) {
            if (tsf > tsc) {
                println("Flash")
            } else {
                println("Cisco")
            }
        } else {
            println("Tie")
        }
    }
}