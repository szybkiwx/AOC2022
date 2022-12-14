package common

fun readLines(fileName: String) : List<String> {
    return object {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.readLines()!!

}

fun readInts(fileName: String) : List<Int> {
    return readLines(fileName).map { s -> s.toInt() }
}

data class Point<T>(val x: T, val y: T)
class Stack<T>{
    val elements: MutableList<T> = mutableListOf()

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    fun push(item: T) = elements.add(item)

    fun pop() : T? {
        val item = elements.lastOrNull()
        if (!isEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item
    }
    fun peek() : T? = elements.lastOrNull()

    override fun toString(): String = elements.toString()
}

