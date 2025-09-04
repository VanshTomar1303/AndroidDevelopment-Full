package com.vansh.androidsdk.viewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ViewModelScreen(
    viewModel: ContactsViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = viewModel.backgroundColor)
    ) {
        Button(onClick = {
            viewModel.changeBackgroundColor()
        }) {
            Text("Change Color")
        }
    }
}