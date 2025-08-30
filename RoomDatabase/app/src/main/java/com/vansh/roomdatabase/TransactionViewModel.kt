package com.vansh.roomdatabase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vansh.roomdatabase.dao.TransactionDao
import com.vansh.roomdatabase.model.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TransactionViewModel(
    private val dao: TransactionDao
): ViewModel() {

    val totalAmount: StateFlow<Double> = dao.getTotalAmount()
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            0.0
        )

    val totalExpense: StateFlow<Double> = dao.getTotalExpense()
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            0.0
        )

    val totalIncome: StateFlow<Double> = dao.getTotalIncome()
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            0.0
        )

    private val _transactions = dao.getAll().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(TransactionState())
    val state = combine(_state, _transactions){states, transactions ->
        states.copy(
            transactionList = transactions
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TransactionState())

    @RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event: TransactionEvent){
        when(event){
            is TransactionEvent.DeleteTransaction -> {
                viewModelScope.launch {
                    dao.delete(event.transaction)
                }
            }
            TransactionEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingTransaction = false
                    )
                }
            }
            TransactionEvent.SaveTransaction -> {
                val title = state.value.title
                val category = state.value.category
                var amount = state.value.amount.toDoubleOrNull() ?: return

                if (title.isBlank() || category.isBlank()) return

                if (category == "Expense") amount *= -1
                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                val currentDate = Date()

                val transaction = Transaction(
                    title = title,
                    category = category,
                    amount = amount,
                    createdAt = dateFormat.format(currentDate)
                )

                viewModelScope.launch {
                   dao.upsert(transaction)
                }

                _state.update {
                    it.copy(
                        isAddingTransaction = false,
                        title = "",
                        amount = "",
                        category = ""
                    )
                }
            }
            is TransactionEvent.SetAmount -> {
                _state.update {
                    it.copy(
                        amount = event.amount
                    )
                }
            }
            is TransactionEvent.SetCategory -> {
                    _state.update {
                        it.copy(
                            category = event.category
                        )
                    }
            }
            is TransactionEvent.SetTitle -> {
                    _state.update {
                        it.copy(
                            title = event.title
                        )
                    }
            }
            TransactionEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingTransaction = true
                    )
                }
            }

            TransactionEvent.HideDropDown -> {
                _state.update {
                    it.copy(
                        isAddingCategory = false
                    )
                }
            }
            TransactionEvent.ShowDropDown -> {
                _state.update {
                    it.copy(
                        isAddingCategory = true
                    )
                }
            }
        }
    }
}