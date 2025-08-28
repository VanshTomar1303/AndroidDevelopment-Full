fun main(){
    add(4,5)

    val sub = sub(50,3)
    println(sub)
}

fun add(a: Int, b: Int) {
    println(a+b)
}

fun sub(a: Int, b: Int): Int{
    return a - b
}