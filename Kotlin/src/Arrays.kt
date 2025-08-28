fun main(){
    // Array
    val num = arrayOf(1, 2, 3, 4, 5)
    val name = arrayOf("Alice", "Bob", "Charlie")

    val intArray = intArrayOf(1, 2, 3, 4)
    val doubleArray = doubleArrayOf(1.1, 2.2, 3.3)
    val charArray = charArrayOf('a', 'b', 'c')

    // Array(size) { init }
    val squares = Array(5) { i -> i * i }
    println(squares.joinToString()) // 0, 1, 4, 9, 16

    val nums = arrayOf(10, 20, 30)
    println(nums[0])   // 10
    nums[1] = 25       // update value
    println(nums[1])   // 25


    // immutable list
    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers[0])   // 1
    println(numbers.size) // 5
    // mutable list
    val fruits = mutableListOf("Apple", "Banana")
    fruits.add("Mango")
    fruits.remove("Banana")
    println(fruits) // [Apple, Mango]

    // immutable set
    val number = setOf(1, 2, 2, 3, 4)
    println(number) // [1, 2, 3, 4] (no duplicates)
    // mutable set
    val names = mutableSetOf("A", "B")
    names.add("C")
    names.remove("A")
    println(names) // [B, C]

    // immutable Map
    val countryCodes = mapOf( "IN" to "India", "US" to "United States" )
    println(countryCodes["IN"]) // India
    // mutable map
    val students = mutableMapOf(1 to "John", 2 to "Alice")
    students[3] = "Bob"
    students.remove(2)
    println(students) // {1=John, 3=Bob}

    // common function
    // iteration
    for (item in listOf(1,2,3)) println(item)
    // for each loop
    listOf(1,2,3).forEach { println(it) }
    // map
    val squared = listOf(1,2,3).map { it * it }
    println(squared) // [1, 4, 9]
    // filter
    val even = listOf(1,2,3,4).filter { it % 2 == 0 }
    println(even) // [2, 4]
    // reduce
    val sum = listOf(1,2,3).reduce { acc, i -> acc + i }
    println(sum) // 6
    // return bool
    println(listOf(1,2,3).any { it > 2 })  // true
    println(listOf(1,2,3).all { it > 0 })  // true
    println(listOf(1,2,3).none { it < 0 }) // true
    // return single value
    println(listOf(1,2,3).find { it > 2 }) // 3
    println(listOf(1,2,3).firstOrNull { it > 5 }) // null

}

/*
🔹 1. Types of Collections in Kotlin
Kotlin collections are mainly of two types:

Immutable (Read-only) → Cannot be changed after creation
Examples: listOf(), setOf(), mapOf()
You can read elements, but cannot add/remove.

Mutable (Read & Write) → Can be modified
Examples: mutableListOf(), mutableSetOf(), mutableMapOf()
You can add, remove, update elements.

🔹 2. Collection Interfaces
Kotlin defines the following main interfaces:

Collection<T> → Base interface (list & set extend it)
List<T> → Ordered, allows duplicates
Set<T> → Unordered, no duplicates
Map<K, V> → Key-value pairs, keys unique
 */