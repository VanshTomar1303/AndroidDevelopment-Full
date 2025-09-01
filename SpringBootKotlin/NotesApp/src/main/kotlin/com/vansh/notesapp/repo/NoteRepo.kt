package com.vansh.notesapp

import com.vansh.notesapp.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepo: JpaRepository<Note, Long> {
}