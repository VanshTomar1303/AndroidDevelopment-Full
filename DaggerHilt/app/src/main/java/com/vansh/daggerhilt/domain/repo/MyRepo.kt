package com.vansh.daggerhilt.domain.repo

interface MyRepo {
    suspend fun doNetworkCall()
}