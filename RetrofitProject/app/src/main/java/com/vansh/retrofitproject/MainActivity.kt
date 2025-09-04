package com.vansh.retrofitproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vansh.retrofitproject.api.RetrofitInstance
import com.vansh.retrofitproject.repo.NoteRepository
import com.vansh.retrofitproject.ui.theme.RetrofitProjectTheme
import androidx.compose.runtime.getValue
import com.vansh.retrofitproject.presentation.NoteScreen
import com.vansh.retrofitproject.presentation.NoteViewModel

class MainActivity : ComponentActivity() {

    private val api by lazy {
        RetrofitInstance.getApiService()
    }

    private val repo by lazy {
        NoteRepository(api = api)
    }

    private val viewModel by viewModels<NoteViewModel>(
        factoryProducer = {
            object: ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return NoteViewModel(noteRepository = repo) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitProjectTheme {

                val state by viewModel.state.collectAsState()

                NoteScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )

            }
        }
    }
}
