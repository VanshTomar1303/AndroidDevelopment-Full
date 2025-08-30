package com.vansh.roomdatabase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SummaryCard(
    totalAmount: Double,
    income: Double,
    expense: Double
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(14.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer),
    ) {
        SummaryCardItem(text = "Balance", totalAmount, color = Color.Blue)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            SummaryCardItem(text = "Income", income, color = Color.Green)
            SummaryCardItem(text = "Expense", expense, color = Color.Red)
        }
    }
}

@Composable
fun SummaryCardItem(text: String, amount: Double, color: Color){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.SemiBold
            )
        Text(
            text = "₹$amount",
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = color
        )
    }
}