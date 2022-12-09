package day05

import common.Stack

data class Operation(val amount: Int, val from: Int, val to: Int)

fun part1() : Int {

    val lines = common.readLines("/day05/input.txt")
    val stacks = extracted(lines)

    //move 19 from 8 to 6
    val regex = "move (\\d+) from (\\d+) to (\\d+)".toRegex()
    val instructions = lines.drop(10).map { val (amount, from, to) = regex.find(it)!!.destructured
                                                Operation(amount.toInt(), from.toInt(), to.toInt())
    }

    for(op in instructions) {
        for(i in 0 until op.amount) {
            stacks[op.to -1].push( stacks[op.from - 1].pop()!!)
        }
    }

    val x = stacks.map { it.peek()!! }.toCharArray()

    val z = String(x)

    return 0
}

fun part2() : Int {

    val lines = common.readLines("/day05/input.txt")
    val stacks = extracted(lines)

    //move 19 from 8 to 6
    val regex = "move (\\d+) from (\\d+) to (\\d+)".toRegex()
    val instructions = lines.drop(10).map { val (amount, from, to) = regex.find(it)!!.destructured
        Operation(amount.toInt(), from.toInt(), to.toInt())
    }

    for(op in instructions) {
        val midStack = Stack<Char>()
        for(i in 0 until op.amount) {
            midStack.push(stacks[op.from - 1].pop()!!)
            //stacks[op.to -1].push( stacks[op.from - 1].pop()!!)
        }
        for(i in 0 until op.amount) {
            stacks[op.to - 1].push(midStack.pop()!!)
        }
    }

    val x = stacks.map { it.peek()!! }.toCharArray()

    val z = String(x)

    return 0
}

private fun extracted(lines: List<String>): List<Stack<Char>> {
    val stacks = mutableListOf<Stack<Char>>()

    for (i in 1..9) {
        stacks.add(Stack())
    }

    for (i in 7 downTo 0) {
        val line = lines[i].padEnd(35)
        for (j in 0 until 9) {
            if (line[j * 4 + 1] != ' ') {
                stacks[j].push(line[j * 4 + 1])
            }
        }
    }

    return stacks.toList()
}