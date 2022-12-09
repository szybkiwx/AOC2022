package day04

data class Elf(val start: Int, val end: Int)

fun part1() : Int {
    val lines = common.readLines("/day04/input.txt")

    var shifts = lines.map { val (a1, a2, b1, b2) = "(\\d+)-(\\d+),(\\d+)-(\\d+)".toRegex().find(it)!!.destructured
                            Pair(Elf(a1.toInt(), a2.toInt()), Elf(b1.toInt(), b2.toInt()))
    }

    return shifts.count {
        (it.first.start >= it.second.start && it.first.end <= it.second.end)
                || (it.second.start >= it.first.start && it.second.end <= it.first.end)
    }
}

fun part2() : Int {
    val lines = common.readLines("/day04/input.txt")

    var shifts = lines.map { val (a1, a2, b1, b2) = "(\\d+)-(\\d+),(\\d+)-(\\d+)".toRegex().find(it)!!.destructured
        Pair(Elf(a1.toInt(), a2.toInt()), Elf(b1.toInt(), b2.toInt()))
    }

    //18-49,17-19
    return shifts.count {
        val elf1Sections = (it.first.start..it.first.end).toSet()
        val elf2Sections = (it.second.start..it.second.end).toSet()
        elf1Sections.intersect(elf2Sections).isNotEmpty()
    }
}