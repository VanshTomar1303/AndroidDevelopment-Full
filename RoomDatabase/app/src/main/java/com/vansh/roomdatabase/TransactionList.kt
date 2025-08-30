package com.vansh.roomdatabase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vansh.roomdatabase.model.Transaction
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TransactionList(transactionList: List<Transaction>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        items(transactionList) {
            item -> TransactionListItem(item)
            HorizontalDivider(thickness = 2.dp)
        }
    }
}

@Composable
fun TransactionListItem(transaction: Transaction) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = transaction.title,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            Text(
                text = transaction.category,
                fontFamily = FontFamily.Monospace,
                fontSize = 16.sp,
            )
        }
        Column {
            Text(
                text = transaction.amount.toString(),
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = if (transaction.amount > 0) Color.Green else Color.Red
            )
            Text(
                text = transaction.createdAt,
                fontFamily = FontFamily.Monospace,
                fontSize = 16.sp,
            )
        }

    }
}