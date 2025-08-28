fun main() {
    val rect = Rectangle(3,4)

    println(rect.height)
    println(rect.width)
}

class Rectangle(val width: Int, val height: Int){
    val area = width * height
}

// it give certain more better functions (getter, setter, copy, toString)
data class Person(val name: String, val age: Int)