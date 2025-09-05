package com.vansh.daggerhilt

import androidx.lifecycle.ViewModel
import com.vansh.daggerhilt.domain.repo.MyRepo
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor (
    private val repo: Lazy<MyRepo>
): ViewModel() {
}