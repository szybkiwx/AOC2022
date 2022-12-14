package day09

import common.Point
import common.readLines

fun part1() : Int {
    val instructions = readLines("/day09/input.txt")
        .flatMap{ line -> val(dir, timesS) = line.split(' ')
                      val times = timesS.toInt()
                      List<Char>(times) { dir[0] }
        }

    var H = Point(0, 0)
    var T = Point(0, 0)
    var track = hashMapOf<Point<Int>, Int>().toMutableMap()

    for(instruction in instructions) {
        var x = when(instruction) {
            'U' -> {
                    val y = if(H.y > T.y) T.y + 1 else T.y
                    val x = if(H.y > T.y) {
                        if (H.x == T.x) T.x
                        else H.x
                    }
                    else T.x
                    Pair(Point(H.x, H.y +1), Point(x, y))
                }
            'D' -> {
                val y = if(H.y < T.y) T.y - 1 else T.y
                val x = if(H.y < T.y) {
                    if (H.x == T.x) T.x
                    else H.x
                }
                else T.x
                Pair(Point(H.x, H.y - 1), Point(x, y))
            }
            'L' -> {
                val x = if(H.x < T.x) T.x - 1 else T.x
                val y = if(H.x < T.x) {
                    if (H.y == T.y) T.y
                    else H.y
                }
                else T.y
                Pair(Point(H.x - 1, H.y), Point(x, y))
            }
            'R' -> {
                val x = if(H.x > T.x) T.x + 1 else T.x
                val y = if(H.x > T.x) {
                    if (H.y == T.y) T.y
                    else H.y
                }
                else T.y
                Pair(Point(H.x + 1, H.y), Point(x, y))
            }
            else -> Pair(Point(0, 0), Point(0, 0))
            }
        H = x.first
        T = x.second

        if(track.contains(T))
            track[T] = track[T]!! + 1

        else
            track[T] = 1

    }


    return track.size
}


fun part2() : Int {
    val instructions = readLines("/day09/input.txt")
        .flatMap{ line -> val(dir, timesS) = line.split(' ')
            val times = timesS.toInt()
            List(times) { dir[0] }
        }

    var rope = List(10) { Point(0, 0) }.toMutableList()

    var track = hashMapOf<Point<Int>, Int>().toMutableMap()

    var H: Point<Int>
    var T: Point<Int>

    for(instruction in instructions) {




    }


    return track.size
}