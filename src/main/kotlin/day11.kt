package day11

import common.readLines


fun getOp(op: String, operand: String) : (Long) -> Long {
    if(op == "*") {
        if(operand == "old")
            return { x -> x * x }
        else {
            return { x -> x * operand.toLong()}
        }
    }
    else {
        if(operand == "old")
            return { x -> x + x }
        else {
            return { x -> x + operand.toLong()}
        }
    }
}

class Monkey(
    val no: Int,
    var items: MutableList<Long>,
    val operation: (Long) -> Long,
    val test: Long,
    val ifTrue: Int,
    val ifFalse: Int,
    var inspections: Long)


fun part1() : Long {
    val monkeys = getMonkeys()

    for(round in 1..20) {
        for((n, monkey) in monkeys) {
            val toInspect = monkey.items.size

            for(item in monkey.items) {
                val newItem =  monkey.operation(item) / 3
                if(newItem % monkey.test == 0L)
                    monkeys[monkey.ifTrue]!!.items.add(newItem)
                else
                    monkeys[monkey.ifFalse]!!.items.add(newItem)
            }

            monkey.items = mutableListOf()
            monkey.inspections += toInspect
        }
    }

    val (m1, m2) = monkeys.map { (n, m) -> m.inspections }.sortedDescending().take(2)

    return m1 * m2
}

fun part2() : Long {
    val monkeys = getMonkeys()

    val factor = monkeys.values.map { m -> m.test }.fold(1L) { acc, next -> acc * next}

    for(round in 1..10000) {
        for((n, monkey) in monkeys) {
            val toInspect = monkey.items.size

            for(item in monkey.items) {
                val newItem =  monkey.operation(item) % factor
                if(newItem % monkey.test == 0L)
                    monkeys[monkey.ifTrue]!!.items.add(newItem)
                else
                    monkeys[monkey.ifFalse]!!.items.add(newItem)
            }

            monkey.items = mutableListOf()
            monkey.inspections += toInspect
        }
    }

    val (m1, m2) = monkeys.map { (n, m) -> m.inspections }.sortedDescending().take(2)

    return m1 * m2
}

private fun getMonkeys(): MutableMap<Int, Monkey> {
    var lines = readLines("/day11/input.txt")

    val monkeys = hashMapOf<Int, Monkey>().toMutableMap()

    for (j in lines.indices step 7) {
        var monkeyNo = "Monkey (\\d+):".toRegex().find(lines[j])!!.groups[1]!!.value.toInt()
        var items =
            "  Starting items: (.+)".toRegex().find(lines[j + 1])!!.groups[1]!!.value.split(", ").map { it.toLong() }

        val (op, b) = "  Operation: new = old (.) (.+)".toRegex().find(lines[j + 2])!!.destructured

        val operation = getOp(op, b)

        val test = "  Test: divisible by (\\d+)".toRegex().find(lines[j + 3])!!.groups[1]!!.value.toLong()

        val monkeyToIfTrue = "If true: throw to monkey (\\d+)".toRegex().find(lines[j + 4])!!.groups[1]!!.value.toInt()
        val monkeyToIfFalse =
            "If false: throw to monkey (\\d+)".toRegex().find(lines[j + 5])!!.groups[1]!!.value.toInt()

        monkeys[monkeyNo] = Monkey(monkeyNo, items.toMutableList(), operation, test, monkeyToIfTrue, monkeyToIfFalse, 0)
    }

    return monkeys
}