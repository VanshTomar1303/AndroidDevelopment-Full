package com.vansh.retrofitproject.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vansh.retrofitproject.NoteEvent
import com.vansh.retrofitproject.model.NoteResponse
import com.vansh.retrofitproject.ui.theme.DarkGreen
import com.vansh.retrofitproject.ui.theme.Green
import com.vansh.retrofitproject.ui.theme.LightGreen

@Composable
fun NoteCard(
    note: NoteResponse,
    onEvent: (NoteEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(DarkGreen)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = note.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Green
            )
            IconButton(
                onClick = {
                    onEvent(NoteEvent.DeleteNote(note.id))
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Green
                )
            }
        }
        Text(
            text = note.content,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = LightGreen
        )
    }
}

