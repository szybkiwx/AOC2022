package day02

fun round(acc: Int, pair: Pair<String, String>) : Int {
    val roundResult = when (pair) {
        Pair("A", "X"), Pair("B", "Y"), Pair("C", "Z")  -> 3
        //Pair("A", "Z"), Pair("B", "X"), Pair("C", "Y")  -> 0
        Pair("A", "Y"), Pair("B", "Z"), Pair("C", "X")  -> 6
        else -> 0
    }

    val score = when(pair.second) {
        "X" -> 1
        "Y" -> 2
        "Z" -> 3
        else -> 0
    }

    return acc + roundResult + score
}

fun part1() : Int {
    val lines = common.readLines("/day02/input.txt")
    val strategy = lines.map { line -> val (x, y) = line.split(' ')
                        Pair(x, y)
    }

    return strategy.fold(0, ::round)

}


fun round2(acc: Int, pair: Pair<String, String>) : Int {
    val roundResult = when (pair.second) {
        "Y" -> 3
        "Z" -> 6
        else -> 0
    }

    val score = when(pair) {
        Pair("A", "X") -> 3
        Pair("A", "Y") -> 1
        Pair("A", "Z") -> 2
        Pair("B", "X") -> 1
        Pair("B", "Y") -> 2
        Pair("B", "Z") -> 3
        Pair("C", "X") -> 2
        Pair("C", "Y") -> 3
        Pair("C", "Z") -> 1
        else -> 0
    }

    return acc + roundResult + score
}

fun part2() : Int {
    val lines = common.readLines("/day02/input.txt")
    val strategy = lines.map { line -> val (x, y) = line.split(' ')
        Pair(x, y)
    }

    return strategy.fold(0, ::round2)

}

