package com.vansh.jetpackcomposetutorial.practice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NameList(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var names by remember { mutableStateOf(listOf("")) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.TopStart)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                }
            )
            Button(onClick = {
                names = names + name
            }) {
                Text("Add")
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 50.dp)
                .align(Alignment.TopEnd)
        ) {
            items(names) {
                    item ->
                if(names.isEmpty()) {
                    Text("Add names")
                }else {
                    Text(
                        modifier = Modifier.padding(14.dp),
                        text = item,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    HorizontalDivider(color = Color.Gray, thickness = 1.dp)
                }
            }
        }
    }
}