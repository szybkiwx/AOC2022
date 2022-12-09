package day01

fun part1() : Int {
    val lines = common.readLines("/day01/input.txt")

    val elves = mutableListOf<MutableList<Int>>()
    var elf = mutableListOf<Int>()
    for(line in lines) {
        if (line != "") {
            elf.add(line.toInt())
        }
        else {
            elves.add(elf)
            elf = mutableListOf()
        }
    }

    val calories = elves.map { elf -> elf.sum()}

    return calories.max()

}


fun part2() : Int {
    val lines = common.readLines("/day01/input.txt")

    val elves = mutableListOf<MutableList<Int>>()
    var elf = mutableListOf<Int>()
    for(line in lines) {
        if (line != "") {
            elf.add(line.toInt())
        }
        else {
            elves.add(elf)
            elf = mutableListOf()
        }
    }

    val calories = elves.map { elf -> elf.sum()}

    return calories.sortedDescending().take(3).sum()

}