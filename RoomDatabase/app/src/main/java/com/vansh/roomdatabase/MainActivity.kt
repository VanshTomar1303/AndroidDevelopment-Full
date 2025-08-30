package com.vansh.roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.vansh.roomdatabase.database.TransactionDatabase
import com.vansh.roomdatabase.ui.theme.RoomDatabaseTheme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            TransactionDatabase::class.java,
            "transactions"
        ).build()
    }

    private val viewModel by viewModels<TransactionViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TransactionViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDatabaseTheme {

                val state by viewModel.state.collectAsState()
                val balance by viewModel.totalAmount.collectAsState()
                val expense by viewModel.totalExpense.collectAsState()
                val income by viewModel.totalIncome.collectAsState()

                ExpenseTrackerScreen(
                    balance = balance,
                    income = income,
                    expense = expense,
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}
