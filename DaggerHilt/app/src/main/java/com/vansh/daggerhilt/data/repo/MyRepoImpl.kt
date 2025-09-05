package com.vansh.daggerhilt.data.repo

import com.vansh.daggerhilt.data.remote.MyApi
import com.vansh.daggerhilt.domain.repo.MyRepo
import javax.inject.Inject

// for repo module
class MyRepoImpl @Inject constructor (
    private val api: MyApi
): MyRepo {
    override suspend fun doNetworkCall() {
        TODO("Not yet implemented")
    }
}