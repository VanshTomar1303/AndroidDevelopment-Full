package com.vansh.noteapp.service

import com.vansh.noteapp.controller.NoteController
import com.vansh.noteapp.model.Note
import com.vansh.noteapp.repo.NoteRepo
import org.springframework.stereotype.Service
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class NoteService(private val noteRepo: NoteRepo) {

    fun getAllNotes(): List<Note> =
        noteRepo.findAll()

    fun getNoteById(id: Long): Note =
        noteRepo.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Note with id $id not found")
        }

    fun createNote(noteRequest: NoteController.NoteRequest): Note {
        val note = Note(
            title = noteRequest.title,
            content = noteRequest.content
        )
        return noteRepo.save(note) // ✅ return saved note
    }

    fun updateNote(noteRequest: NoteController.NoteRequest, id: Long): Note {
        val existingNote = noteRepo.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Note with id $id not found")
        }

        val updatedNote = existingNote.copy(
            title = noteRequest.title,
            content = noteRequest.content
        )

        return noteRepo.save(updatedNote) // ✅ return updated note
    }

    fun deleteNote(id: Long) {
        if (!noteRepo.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Note with id $id not found")
        }
        noteRepo.deleteById(id)
    }
}
