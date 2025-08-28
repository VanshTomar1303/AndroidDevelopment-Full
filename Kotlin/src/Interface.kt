/*
🔹 1. What is an Interface?
An interface in Kotlin is like a contract.

It can declare:
Abstract methods (no body → must be implemented).
Concrete methods (with default implementation).
Properties (abstract or with getters/setters).
A class can implement multiple interfaces (Kotlin doesn’t support multiple inheritance, but interfaces fill that gap).
 */

interface Animal {
    fun sound()   // abstract method
    fun eat() {   // default method
        println("Animal is eating")
    }
}

class Dog : Animal {
    override fun sound() {
        println("Woof!")
    }
}

fun main() {
    val dog = Dog()
    dog.sound()  // Woof!
    dog.eat()    // Animal is eating (default implementation)
}

/*
| Feature              | Interface                                | Abstract Class                          |
| -------------------- | ---------------------------------------- | --------------------------------------- |
| Multiple inheritance | ✅ Allowed                                | ❌ Only one                              |
| Constructor          | ❌ No constructor                         | ✅ Can have                              |
| State (fields)       | ❌ Only properties (no backing field)     | ✅ Can hold state                        |
| Default method body  | ✅ Yes                                    | ✅ Yes                                   |
| When to use?         | Common behavior across unrelated classes | Base class with shared state & behavior |

 */