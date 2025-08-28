fun main(){
    val n = readln().toIntOrNull() ?: 0

    if (n%2 == 0) println("Even")
    else if( n == 0) println(" It can't be zero")
    else println("Odd")

    val result: String = if (n % 2 == 0) "Even" else "Odd"
    println(result)
}