package com.vansh.roomdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vansh.roomdatabase.model.Transaction
import com.vansh.roomdatabase.dao.TransactionDao

@Database(
    entities = [Transaction::class],
    version = 1
)
abstract class TransactionDatabase: RoomDatabase() {
    abstract val dao: TransactionDao
}