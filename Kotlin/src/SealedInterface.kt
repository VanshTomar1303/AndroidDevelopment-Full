/*
🔹 3. Sealed Interfaces
Introduced in Kotlin 1.5.
Similar to sealed classes, but for interfaces.
Restricts implementations to the same file.
Useful for defining contracts with limited implementations.
 */

sealed interface PaymentStatus

class Success(val transactionId: String) : PaymentStatus
class Failure(val reason: String) : PaymentStatus
object Pending : PaymentStatus

fun checkStatus(status: PaymentStatus) = when (status) {
    is Success -> println("Transaction ID: ${status.transactionId}")
    is Failure -> println("Failed: ${status.reason}")
    Pending    -> println("Pending payment")
}
