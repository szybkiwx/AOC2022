package day10

import common.readLines

fun part1() : Int {
    val lines = readLines("/day10/input.txt")
        .flatMap { line -> val newInstructions = mutableListOf<String>()
                            if( line != "noop")
                                newInstructions.add("noop")
                            newInstructions.add(line)
                            newInstructions
    }

    var registry = 1

    var signal = 0

    for((i, line) in lines.withIndex()) {
        val cycle = i + 1

        if((cycle + 20) % 40 == 0) {
            signal += cycle * registry
        }

        if(line.startsWith("addx")) {
            registry += line.split(' ')[1].toInt()
        }
    }

    return signal
}

fun part2() : Int {
    val lines = readLines("/day10/input.txt")
        .flatMap { line -> val newInstructions = mutableListOf<String>()
            if( line != "noop")
                newInstructions.add("noop")
            newInstructions.add(line)
            newInstructions
        }

    var screen = Array(6) { CharArray(40) { ' ' } }

    var registry = 1

    var row = 0
    var column = 0

    for((i, line) in lines.withIndex()) {
        screen[row][column] = if(registry >= column - 1 && registry <= column +1)
             '#'
        else
            '.'

        if(line.startsWith("addx")) {
            registry += line.split(' ')[1].toInt()
        }

        column++
        if(column == 40) {
            column = 0
            row++
        }
    }

    for(row in screen.indices) {
        println(screen[row].concatToString())
    }

    return 0
}