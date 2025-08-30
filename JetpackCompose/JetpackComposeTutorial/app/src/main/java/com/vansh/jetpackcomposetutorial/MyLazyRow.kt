package com.vansh.jetpackcomposetutorial

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MyLazyRow(modifier: Modifier = Modifier) {
    val names = listOf("Alice", "Bob", "Charlie","Alice", "Bob", "Charlie","Alice", "Bob", "Charlie","Alice", "Bob", "Charlie","Alice", "Bob", "Charlie","Alice", "Bob", "Charlie","Alice", "Bob", "Charlie")

    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {
        items(names) {
                item ->
            Text(
                modifier = Modifier.padding(14.dp),
                text = item,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            VerticalDivider(color = Color.Gray, thickness = 1.dp)
        }
    }
}