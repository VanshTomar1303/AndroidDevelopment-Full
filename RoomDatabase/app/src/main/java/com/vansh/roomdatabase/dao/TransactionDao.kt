package com.vansh.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.vansh.roomdatabase.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Upsert
    suspend fun upsert(transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    @Query("SELECT * from transactions")
    fun getAll(): Flow<List<Transaction>>

    @Query("SELECT COALESCE(SUM(amount), 0) as balance FROM transactions")
    fun getTotalAmount(): Flow<Double>

    @Query("SELECT COALESCE(SUM(amount), 0) as expense FROM transactions WHERE amount < 0")
    fun getTotalExpense(): Flow<Double>

    @Query("SELECT COALESCE(SUM(amount), 0) as income FROM transactions WHERE amount > 0")
    fun getTotalIncome(): Flow<Double>

}