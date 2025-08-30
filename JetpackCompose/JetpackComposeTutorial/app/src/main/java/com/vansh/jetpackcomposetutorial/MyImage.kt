package com.vansh.jetpackcomposetutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
🔹 Image
Used to display images (from resources, URL, or vector).
 */

@Preview(showBackground = true)
@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "background"
    )

    // for async image -> can use url to show image
    // dependency -> implementation("io.coil-kt:coil-compose:2.6.0")
//    AsyncImage(
//        model = "https://picsum.photos/200", // Image URL
//        contentDescription = "Random Image",
//        modifier = Modifier.size(200.dp)
//    )
}