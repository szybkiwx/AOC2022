package day08

import common.readLines

fun part1() : Int {
    val trees = readInput()


    val visible = Array(trees.size) { IntArray(trees[0].size)}

    var highest = 0

    for(row in trees.indices) {
        highest = 0
        for(column in trees[0].indices) {
            if(column == 0 || column == trees[0].size - 1) {
                visible[row][column] = 1
            }

            if (trees[row][column] > highest) {
                visible[row][column] = 1
                highest = trees[row][column]
            }

        }
    }

    for(row in trees.indices) {
        highest = 0
        for(column in trees[0].size - 1 downTo 0) {
            if(column == 0 || column == trees[0].size - 1) {
                visible[row][column] = 1
            }

            if (trees[row][column] > highest) {
                visible[row][column] = 1
                highest = trees[row][column]
            }
        }
    }

    for(column in trees[0].indices) {
        highest = 0

        for(row in trees.indices) {
            if(row == 0 || row == trees.size - 1) {
                visible[row][column] = 1
            }

            if (trees[row][column] > highest) {
                visible[row][column] = 1
                highest = trees[row][column]
            }
        }
    }

    for(column in trees[0].indices) {
        highest = 0
        for(row in trees.size - 1 downTo 0) {
            if(row == 0 || row == trees.size - 1) {
                visible[row][column] = 1
            }
            if (trees[row][column] > highest) {
                visible[row][column] = 1
                highest = trees[row][column]
            }
        }
    }

    return visible.sumOf { row -> row.sum() }
}

private fun readInput(): Array<IntArray> {
    return readLines("/day08/input.txt")
        .map { line -> line.toCharArray().map { c -> c - '0' }.toIntArray() }
        .toTypedArray()
}


fun part2() : Int {
    val trees = readInput()

    val scores = mutableListOf<Int>()

    for(row in 1 until trees.size - 1) {
        for(column in 1 until trees[0].size - 1) {
            val score = countScore(trees, row, column)
            scores.add(score)
        }
    }

    return scores.max()
}

fun countScore(trees: Array<IntArray>, row: Int, column: Int): Int {
    return countLeft(trees, row, column) *
            countRight(trees, row, column) *
            countUp(trees, row, column) *
            countDown(trees, row, column)
}

fun countLeft(trees: Array<IntArray>, row: Int, column: Int): Int {
    var highest = trees[row][column]
    var score = 0
    for(i in column - 1 downTo 0) {
        score += 1
        if(trees[row][i] >= highest) {
            return score
        }
    }

    return score
}

fun countRight(trees: Array<IntArray>, row: Int, column: Int): Int {
    var highest = trees[row][column]
    var score = 0
    for(i in column + 1 until trees[0].size) {
        score += 1
        if(trees[row][i] >= highest) {
            return score
        }
    }

    return score
}

fun countUp(trees: Array<IntArray>, row: Int, column: Int): Int {
    var highest = trees[row][column]
    var score = 0
    for(i in row - 1 downTo 0) {
        score += 1
        if(trees[i][column] >= highest) {
            return score
        }
    }

    return score
}

fun countDown(trees: Array<IntArray>, row: Int, column: Int): Int {
    var highest = trees[row][column]
    var score = 0
    for(i in row + 1 until trees.size) {
        score += 1
        if(trees[i][column] >= highest) {
            return score
        }
    }

    return score
}




