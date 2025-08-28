fun main(){
    val input = readln()
    val revStr = input.rev()

    println(revStr)
}

fun String.rev(): String{
    val finalString = buildString {
        for (i in this@rev.lastIndex downTo 0){
            append(this@rev[i])
        }
    }
    return finalString
}