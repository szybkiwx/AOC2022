package day06

fun addToBuffer(buffer: CharArray, n: Char): CharArray {
    for(i in 0 until buffer.size - 1) {
        buffer[i] = buffer[i + 1]
    }

    buffer[buffer.size - 1] = n

    return buffer
}

fun part1() : Int {
    val signal = common.readLines("/day06/input.txt").first()
    var buffer = signal.take(4).toCharArray()
    for(c in 4 until signal.length) {
        if(isMarker(buffer)) {
            return c
        }
        buffer = addToBuffer(buffer, signal[c])
    }

    return -1
}

fun part2() : Int {
    val signal = common.readLines("/day06/input.txt").first()
    var buffer = signal.take(14).toCharArray()
    for(c in 14 until signal.length) {
        if(isMarker(buffer)) {
            return c
        }
        buffer = addToBuffer(buffer, signal[c])
    }

    return -1
}

fun isMarker(buffer: CharArray): Boolean {
    return buffer.toSet().size == buffer.size
}
