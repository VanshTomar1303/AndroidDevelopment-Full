package com.vansh.roomdatabase

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExpenseTrackerScreen(
    balance: Double,
    income: Double,
    expense: Double,
    state: TransactionState,
    onEvent: (TransactionEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(TransactionEvent.ShowDialog)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {  padding ->
        if (state.isAddingTransaction){
            AddTransactionDialog(state, onEvent)
        }


        Column(
            modifier = Modifier.fillMaxSize()
                .padding(2.dp),
        ) {
            SummaryCard(
                totalAmount = balance,
                income = income,
                expense = expense
            )
            Spacer(modifier = Modifier.height(16.dp))
            TransactionList(transactionList = state.transactionList)
        }
    }
}