package com.vansh.retrofitproject.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vansh.retrofitproject.NoteEvent
import com.vansh.retrofitproject.NoteState
import com.vansh.retrofitproject.ui.theme.Black
import com.vansh.retrofitproject.ui.theme.DarkGreen
import com.vansh.retrofitproject.ui.theme.Green
import com.vansh.retrofitproject.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateDialog(
    state: NoteState,
    onEvent: (NoteEvent) -> Unit
) {

    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Green,
        unfocusedContainerColor = Green,
        focusedTrailingIconColor = LightGreen,
        unfocusedTrailingIconColor = LightGreen,
        focusedTextColor = DarkGreen,
        unfocusedTextColor = DarkGreen,
        cursorColor = LightGreen,
        focusedLabelColor = LightGreen,
        unfocusedLabelColor = LightGreen,
    )

    AlertDialog(
        containerColor = Black,
        onDismissRequest = {
                onEvent(NoteEvent.HideDialog)
        },
        title = {
            Text(
                text = "Create Note",
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.title,
                    onValueChange = {
                        onEvent(NoteEvent.SetTitle(it))
                    },
                    colors = textFieldColors,
                    label = {
                        Text(
                            "Title"
                        )
                    }
                )
                TextField(
                    value = state.content,
                    onValueChange = {
                        onEvent(NoteEvent.SetContent(it))
                    },
                    colors = textFieldColors,
                    label = {
                        Text(
                            "Content"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    singleLine = false,
                    maxLines = Int.MAX_VALUE, // unlimited lines
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
                        onEvent(NoteEvent.SaveNote)
                        onEvent(NoteEvent.HideDialog)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Green,
                        containerColor = LightGreen
                    )
                ) {
                    Text("Save")
                }
            }

        }
    )
}