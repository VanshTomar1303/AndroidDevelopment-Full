package com.vansh.jetpackcomposetutorial

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
🔹 Button
A clickable UI element for actions.
Takes a onClick callback and some UI (like Text).

🔹 TextButton
A button that displays text only (no elevated background by default).
Commonly used for low emphasis actions (like “Cancel”, “Skip”, etc.).

🔹 IconButton
A button that shows only an icon (no text).
Often used in toolbars, cards, or floating actions where space is limited.
 */

@Preview(showBackground = true)
@Composable
fun ButtonsAndIconsAndTextButton(modifier: Modifier = Modifier) {
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
    TextButton(
        onClick = { /* do something */ }
    ) {
        Text(
            text = "Already have a account. Sign In!",
            modifier = Modifier.padding(4.dp),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace
        )
    }
    IconButton(
        onClick = { /* do something */ }
    ) {
        Icon(
            imageVector = Icons.Rounded.Settings,
            contentDescription = "Settings"
        )
    }

}