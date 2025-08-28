/*
🔹 What is a Generic Class?
A generic class is a class that can work with any data type without being limited to a specific one.
It allows type-safety and code reusability.
 */
fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7,8)
    val str = "Hello, World!"

    val evenNum = nums.filter { it % 2 == 0 }
    val letterOnly = str.filter { it.isLetter() }

    val numbers = listOf(1,38,39,49,59).myFilter { it % 2 == 0 }
    println(numbers)
}


fun <T> List<T>.myFilter(predicate: (T) -> Boolean): List<T>{
    val result = mutableListOf<T>()
    for (el in this){
        if (predicate(el)){
            result.add(el)
        }
    }

    return result.toList()
}

sealed interface Results<out D, out E>{
    data class Success<D>(val data: D): Results<D, Nothing>
    data class Error<E>(val error: E): Results<Nothing, E>
}