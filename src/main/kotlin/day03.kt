package day03

fun part1() : Int {
    val lines = common.readLines("/day03/input.txt")

    var priorities = lines.map { line ->
        val (first, second) = line.chunked(line.length / 2).map { ch -> ch.toSet() }
        first.intersect(second)
    }
        .map { l -> l.first() }
        .map { c -> if (c in 'a'..'z') c - 'a' + 1 else c - 'A' + 27 }


    return priorities.sum()
}

fun part2() : Int {
    val lines = common.readLines("/day03/input.txt")

    var priorities = lines.map {line -> line.toSet()}.chunked(3)

    val badges = priorities.map { group -> group[0].intersect(group[1]).intersect(group[2]).first()}
        .map { c -> if (c in 'a'..'z') c - 'a' + 1 else c - 'A' + 27 }



    return badges.sum()
}