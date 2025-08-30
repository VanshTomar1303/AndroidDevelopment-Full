package com.vansh.jetpackcomposetutorial

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
🔹 @Composable
A special annotation that marks a function as UI code in Compose.
🔹 @Preview
Lets you preview your UI in Android Studio without running the app.
 */

@Preview(showBackground = true)
@Composable
fun MyText() {
    /*
🔹 Text
Displays a piece of text on the screen.
Equivalent to TextView in XML.

🔹 Modifier
A tool to style and adjust UI elements (size, padding, color, click, etc.).
     */
    Text(
        text = "Hello!",
        modifier = Modifier.padding(4.dp),
        color = MaterialTheme.colorScheme.primary,
        fontSize = 24.sp,
        fontFamily = FontFamily.Monospace
    )
}