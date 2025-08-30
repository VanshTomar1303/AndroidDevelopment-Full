package com.vansh.roomdatabase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTransactionDialog(
    state: TransactionState,
    onEvent: (TransactionEvent) -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            onEvent(TransactionEvent.HideDialog)
        },
        title = {
            Text(
                text = "Add transaction"
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.title,
                    onValueChange = {
                        onEvent(TransactionEvent.SetTitle(it))
                    },
                    placeholder = {
                        Text(text = "Title")
                    }
                )
                ExposedDropdownMenuBox(
                    expanded = state.isAddingCategory,
                    onExpandedChange = {
                        if (state.isAddingCategory == true){
                            onEvent(TransactionEvent.HideDropDown)
                        } else {
                            onEvent(TransactionEvent.ShowDropDown)
                        }
                    }
                ) {
                    TextField(
                        value =  state.category,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Choose an option") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = state.isAddingCategory)
                        },
                        modifier = Modifier.menuAnchor(
                            type = MenuAnchorType.PrimaryNotEditable,
                            enabled = true
                        )
                    )
                    ExposedDropdownMenu(
                        expanded = state.isAddingCategory,
                        onDismissRequest = {
                            onEvent(TransactionEvent.HideDropDown)
                        }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Expense"
                                )
                            },
                            onClick = {
                                onEvent(TransactionEvent.SetCategory("Expense"))
                                onEvent(TransactionEvent.HideDropDown)
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Income"
                                )
                            },
                            onClick = {
                                onEvent(TransactionEvent.SetCategory("Income"))
                                onEvent(TransactionEvent.HideDropDown)
                            },
                        )
                    }
                }
                TextField(
                    value = state.amount,
                    onValueChange = {
                        onEvent(TransactionEvent.SetAmount(it))
                    },
                    placeholder = {
                        Text(text = "Amount")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ){
                Button(
                    onClick = {
                        onEvent(TransactionEvent.SaveTransaction)
                    }
                ) {
                    Text("Save")
                }
            }
        }
    )
}