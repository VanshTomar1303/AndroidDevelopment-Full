package com.vansh.retrofitproject.repo

import com.vansh.retrofitproject.api.ApiService
import com.vansh.retrofitproject.model.NoteRequest
import com.vansh.retrofitproject.model.NoteResponse

class NoteRepository(private val api: ApiService) {

    suspend fun getNotes(): List<NoteResponse> {
        return api.getNotes()
    }

    suspend fun getNoteById(id: Long): NoteResponse {
        return api.getNoteById(id)
    }

    suspend fun createNote(noteRequest: NoteRequest): NoteResponse {
        return api.createNote(noteRequest)
    }

    suspend fun updateNote(id: Long, noteRequest: NoteRequest): NoteResponse {
        return api.updateNote(noteRequest, id)
    }

    suspend fun deleteNote(id: Long) {
        api.deleteNote(id)
    }
}
