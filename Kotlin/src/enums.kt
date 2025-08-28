/*
Enums (enumerations) in Kotlin are a special class type that is used to represent a fixed set of constants. They make the code more readable and type-safe when you want to restrict a variable to a small set of predefined values.
 */
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}
fun main() {
    val dir: Direction = Direction.NORTH

    println(dir)          // Output: NORTH
    println(dir.name)     // Output: NORTH
    println(dir.ordinal)  // Output: 0 (position of the constant)

    Day.FRIDAY.printInfo()   // FRIDAY is weekend? false
    Day.SUNDAY.printInfo()   // SUNDAY is weekend? true
}

enum class Day(val isWeekend: Boolean) {
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true);

    fun printInfo() {
        println("$name is weekend? $isWeekend")
    }
}

