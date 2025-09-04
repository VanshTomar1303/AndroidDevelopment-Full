package com.vansh.retrofitproject.api

import com.vansh.retrofitproject.model.NoteRequest
import com.vansh.retrofitproject.model.NoteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("notes")
    suspend fun getNotes(): List<NoteResponse>

    @GET("notes/{id}")
    suspend fun getNoteById(@Path("id") id: Long): NoteResponse

    @POST("notes")
    suspend fun createNote(@Body noteRequest: NoteRequest): NoteResponse

    @PUT("notes/{id}")
    suspend fun updateNote(@Body noteRequest: NoteRequest, @Path("id") id: Long): NoteResponse

    @DELETE("notes/{id}")
    suspend fun deleteNote(@Path("id") id: Long): Response<Unit>
}