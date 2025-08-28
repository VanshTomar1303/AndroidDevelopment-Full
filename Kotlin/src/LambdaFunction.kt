fun main() {
    val input = readln()

    val lettersOnly = input.filter { it.isLetter() } // predefine lambda function
    val lettersOnlyCustom = input.myFilter { it.isLetter() } // custom lambda function

    println(lettersOnly)
}

fun String.myFilter(predicate: (Char) -> Boolean): String{
    return buildString {
        for (char in this@myFilter){
            if (predicate(char)){
                append(char)
            }
        }
    }
}