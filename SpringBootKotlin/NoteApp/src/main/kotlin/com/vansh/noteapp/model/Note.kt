package com.vansh.noteapp.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "notes")
data class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val content: String,

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime? = null
)
