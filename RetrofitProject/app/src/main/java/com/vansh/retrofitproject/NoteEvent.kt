package com.vansh.retrofitproject

sealed interface NoteEvent {
    object SaveNote: NoteEvent
    data class SetTitle(val title: String): NoteEvent
    data class SetContent(val content: String): NoteEvent
    data class Loading(val loading: Boolean): NoteEvent
    data class DeleteNote(val id: Long): NoteEvent
    object ShowDialog: NoteEvent
    object HideDialog: NoteEvent
}
