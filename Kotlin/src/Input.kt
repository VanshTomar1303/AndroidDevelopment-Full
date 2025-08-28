fun main(){
    val name  = readln() // only give string
    val age = readln().toInt() // we have to type cast it
    val age2 = readln().toIntOrNull() ?: 0 // if it null assign 0
    val age3 = readln().toIntOrNull()?.inc() // if value in num then it value increment
    println(name)
}