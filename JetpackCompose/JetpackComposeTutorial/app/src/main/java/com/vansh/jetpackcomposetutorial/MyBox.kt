package com.vansh.jetpackcomposetutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
🔹 Box
A layout container that stacks children on top of each other.
Equivalent to FrameLayout in XML.
 */

@Preview(showBackground = true)
@Composable
fun MyBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Row (
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.TopStart),// it is because of box
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello!",
                modifier = Modifier.padding(4.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace
            )

            Button(
                onClick = { /* do something */ },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text(
                    text = "Click Me!",
                    modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello!",
                modifier = Modifier.padding(4.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace
            )

            Button(
                onClick = { /* do something */ },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text(
                    text = "Click Me!",
                    modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}