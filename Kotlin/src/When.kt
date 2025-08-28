fun main(){
    val day = "Monday"

    when(day){
        "Monday" -> println("Arigato")
        "Tuesday" -> {
            println("mata ashita")
        }
        else -> println("jaane")
    }

    val input = readln().toIntOrNull()

    val output = when(input){
        null -> "Dude, enter a valid number!"
        3 -> "The number is three"
        in 10 .. 29 -> "The number is in b/w 10 and 20"
        else -> "i have no idea."
    }
    println(output)
}