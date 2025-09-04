package com.vansh.retrofitproject.model

import java.time.LocalDateTime

data class NoteResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: String
)
