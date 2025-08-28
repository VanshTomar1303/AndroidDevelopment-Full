/*
🔹 1. What is a Sealed Class?
A sealed class is a class whose subclasses are restricted to a certain scope.
Subclasses must be defined in the same file as the sealed class (but not necessarily inside it).
Cannot be directly instantiated (like abstract).
Useful for representing limited set of types (like enums, but more powerful).
 */

sealed class Result {
    class Success(val data: String) : Result()
    class Error(val message: String) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) = when (result) {
    is Result.Success -> println("Data: ${result.data}")
    is Result.Error   -> println("Error: ${result.message}")
    Result.Loading    -> println("Loading...")
}

/*
| Feature              | Sealed Class                                      | Sealed Interface                                       |
| -------------------- | ------------------------------------------------- | ------------------------------------------------------ |
| State                | ✅ Can hold state (fields, constructors)           | ❌ Cannot hold state                                    |
| Abstract methods     | ✅ Yes                                             | ✅ Yes                                                  |
| Multiple inheritance | ❌ Only single class                               | ✅ Can implement multiple interfaces                    |
| When to use          | Represent a closed hierarchy with data + behavior | Represent a closed hierarchy of types (contracts only) |

 */