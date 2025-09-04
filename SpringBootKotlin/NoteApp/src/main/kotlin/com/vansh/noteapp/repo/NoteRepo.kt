package com.vansh.noteapp.repo

import com.vansh.noteapp.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepo: JpaRepository<Note, Long> {
}