/*
🔹 1. What is an Abstract Class?
An abstract class is a class that cannot be instantiated directly.
It’s meant to be a base class for other classes.

It can contain:
Abstract methods (no body → must be overridden).
Concrete methods (with body).
Properties (abstract or with default values).
A class can inherit only one abstract class (unlike interfaces).
 */

abstract class Animals {
    abstract fun sound()   // abstract function → must be implemented
    fun sleep() {          // concrete function → common implementation
        println("Sleeping...")
    }
}

class Dogs : Animals() {
    override fun sound() {
        println("Woof!")
    }
}

fun main() {
    val dog = Dogs()
    dog.sound()  // Woof!
    dog.sleep()  // Sleeping...
}

/*
| Feature              | Abstract Class                          | Interface                            |
| -------------------- | --------------------------------------- | ------------------------------------ |
| Instantiation        | ❌ Cannot be instantiated                | ❌ Cannot be instantiated             |
| Constructors         | ✅ Can have constructors                 | ❌ No constructor                     |
| State (fields)       | ✅ Can hold state (fields)               | ❌ Only properties (no backing field) |
| Multiple inheritance | ❌ Only one                              | ✅ Many                               |
| Methods              | Abstract + concrete                     | Abstract + default                   |
| Use case             | When classes share **state + behavior** | When classes share **behavior only** |

 */
