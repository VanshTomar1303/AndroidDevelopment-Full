package com.vansh.retrofitproject

import com.vansh.retrofitproject.model.NoteResponse
import java.time.LocalDateTime

data class NoteState(
    val notesList: List<NoteResponse> = emptyList(),
    val title: String = "",
    val content: String = "",
    val isLoading: Boolean = false,
    val dialog: Boolean = false
)