package com.vansh.roomdatabase

import com.vansh.roomdatabase.model.Transaction

sealed interface TransactionEvent {
    object SaveTransaction: TransactionEvent
    data class SetTitle(val title: String): TransactionEvent
    data class SetCategory(val category: String): TransactionEvent
    data class SetAmount(val amount: String): TransactionEvent
    object ShowDialog: TransactionEvent
    object HideDialog: TransactionEvent
    object ShowDropDown: TransactionEvent
    object HideDropDown: TransactionEvent
    data class DeleteTransaction(val transaction: Transaction): TransactionEvent
}
