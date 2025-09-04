package com.vansh.retrofitproject.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vansh.retrofitproject.NoteEvent
import com.vansh.retrofitproject.NoteState
import com.vansh.retrofitproject.model.NoteRequest
import com.vansh.retrofitproject.repo.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NoteViewModel(
    private val noteRepository: NoteRepository
): ViewModel() {
    private val _state = MutableStateFlow(NoteState())
    val state: StateFlow<NoteState> = _state

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                val notes = noteRepository.getNotes()
                _state.update { it.copy(notesList = notes) }
            } catch (e: Exception) {
                Log.e("NoteViewModel", "Error loading notes", e)
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    fun onEvent(event: NoteEvent){
        when(event){
            NoteEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        dialog = false
                    )
                }
            }
            is NoteEvent.Loading -> {
                _state.update {
                    it.copy(
                        isLoading = event.loading
                    )
                }
            }
            NoteEvent.SaveNote -> {
                val title = state.value.title
                val content = state.value.content

                if (title.isBlank() || content.isBlank()) return

                val note = NoteRequest(
                    title = title,
                    content = content
                )

                viewModelScope.launch {
                    noteRepository.createNote(noteRequest = note)
                    loadNotes()
                }

                _state.update {
                    it.copy(
                        content = "",
                        title = "",
                        dialog = false,
                    )
                }

            }
            is NoteEvent.SetContent -> {
                _state.update {
                    it.copy(
                        content = event.content
                    )
                }
            }
            is NoteEvent.SetTitle -> {
                _state.update {
                    it.copy(
                        title = event.title
                    )
                }
            }
            NoteEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        dialog = true
                    )
                }
            }

            is NoteEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteRepository.deleteNote(event.id)
                    loadNotes()
                }
            }
        }
    }
}