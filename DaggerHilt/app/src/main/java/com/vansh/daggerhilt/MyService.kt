package com.vansh.daggerhilt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.vansh.daggerhilt.domain.repo.MyRepo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyService: Service() {

    @Inject
    lateinit var repo: MyRepo

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}