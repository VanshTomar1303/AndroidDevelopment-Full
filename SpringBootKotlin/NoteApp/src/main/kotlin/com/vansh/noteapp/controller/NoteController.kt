package com.vansh.noteapp.controller

import com.vansh.noteapp.model.Note
import com.vansh.noteapp.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(private val service: NoteService) {
    data class NoteRequest(
        val title: String,
        val content: String,
    )

    @GetMapping
    fun getAllNotes(): List<Note> =
        service.getAllNotes()

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: Long): Note =
        service.getNoteById(id)

    @PostMapping
    fun createNote(@RequestBody noteRequest: NoteRequest): ResponseEntity<Note> {
        val saved = service.createNote(noteRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @PutMapping("/{id}")
    fun updateNote(@PathVariable id: Long, @RequestBody noteRequest: NoteRequest): Note =
        service.updateNote(noteRequest, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNote(@PathVariable id: Long) =
        service.deleteNote(id)
}
