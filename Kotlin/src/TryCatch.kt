fun main(){
    try {
        val input = readln().toInt()
    }catch (e: Exception){
        e.printStackTrace()
    }

    // this is not a good use case
    throw Exception("Dude this is shit") // custom exception

    val input2 = try {
        readln().toInt()
    }catch (e: Exception){
        0
    }

}