/*
🔹 1. What is Inheritance?
Inheritance allows a class (child / subclass) to reuse properties and methods of another class (parent / superclass).
Promotes code reusability and polymorphism.
In Kotlin, classes are final by default (cannot be inherited).
👉 You must mark a class as open (or abstract) to allow inheritance.
 */

open class Persons(val name: String) {
    open fun greet() {
        println("Hello, my name is $name")
    }
}

class Student(name: String, val rollNo: Int) : Persons(name) {
    override fun greet() {
        println("Hello, I am $name and my roll no is $rollNo")
    }
}

fun main() {
    val student = Student("Vansh", 101)
    student.greet()

    val obj = Child()
    obj.show()
}

open class Parent {
    open fun show() = println("From Parent")
}

class Child : Parent() {
    override fun show() {
        super.show()   // calls Parent method
        println("From Child")
    }
}




