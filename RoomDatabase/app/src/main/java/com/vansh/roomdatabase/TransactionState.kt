package com.vansh.roomdatabase

import com.vansh.roomdatabase.model.Transaction

data class TransactionState(
    val transactionList: List<Transaction> = emptyList(),
    val title: String = "",
    val category: String = "",
    val amount: String = "",
    val isAddingTransaction: Boolean = false,
    val isAddingCategory: Boolean = false
)