// objects -> single instance of class and can't have constructor
object Database {
    val name = "MyDB"

    fun connect() {
        println("Connected to $name")
    }
}

fun main() {
    Database.connect() // No need to create object, directly accessible
}
