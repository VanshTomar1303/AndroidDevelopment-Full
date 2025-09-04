package com.vansh.retrofitproject.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vansh.retrofitproject.NoteEvent
import com.vansh.retrofitproject.NoteState
import com.vansh.retrofitproject.ui.theme.Black
import com.vansh.retrofitproject.ui.theme.Green
import com.vansh.retrofitproject.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    state: NoteState,
    onEvent: (NoteEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Retrofit Notes App",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Green,
                    titleContentColor = LightGreen
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(NoteEvent.ShowDialog)
                },
                containerColor = Color.White,
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Note",
                    tint = Color.Red,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    ) { innerPadding ->

        if (state.dialog){
            CreateDialog(
                state = state,
                onEvent = onEvent
            )
        }

        if(state.isLoading){
            CircularProgressIndicator()
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
                .background(Black)
                .padding(10.dp)
        ) {
            items(state.notesList) {note ->
                NoteCard(note = note, onEvent = onEvent)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
