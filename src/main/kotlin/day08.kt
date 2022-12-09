package day08

fun part1() : Int {
    val trees = common.readLines("/day08/input.txt")
        .map { line -> line.toCharArray().map { c -> c - '0'}.toIntArray()}
        .toTypedArray()


    val visible = Array(trees.size) { IntArray(trees[0].size)}

    for(row in trees.indices) {
        for(column in trees[0].indices) {
            if(column == 0 || column == trees[0].size - 1) {
                visible[row][column] = 1
            }
            else if(trees[row][column] > trees[row][column - 1]) {
                visible[row][column] = 1
            }
            else {
                break
            }
        }
    }

    for(row in trees.indices) {
        for(column in trees[0].size - 1 downTo 0) {
            if(column == 0 || column == trees[0].size - 1) {
                visible[row][column] = 1
            }
            else if(trees[row][column] > trees[row][column + 1]) {
                visible[row][column] = 1
            }
            else {
                break
            }
        }
    }

    for(column in trees[0].indices) {
        for(row in trees.indices) {
            if(row == 0 || row == trees.size - 1) {
                visible[row][column] = 1
            }
            else if(trees[row][column] > trees[row - 1][column]) {
                visible[row][column] = 1
            }
            else {
                break
            }
        }
    }

    for(column in trees[0].indices) {
        for(row in trees.size - 1 downTo 0) {
            if(row == 0 || row == trees.size - 1) {
                visible[row][column] = 1
            }
            else if(trees[row][column] > trees[row + 1][column]) {
                visible[row][column] = 1
            }
            else {
                break
            }
        }
    }

    return visible.map {row -> row.sum() }.sum()
}