package com.vansh.roomdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transactions")
data class Transaction(
    val title: String,
    val category: String,
    val amount: Double,
    val createdAt: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
