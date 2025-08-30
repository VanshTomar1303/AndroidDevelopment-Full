package com.vansh.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vansh.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { // Used inside Activity to define the UI hierarchy of the screen.
            JetpackComposeTutorialTheme {

            }
        }
    }
}

/*
❓ What is Jetpack Compose?
Jetpack Compose is Google’s modern toolkit for building native Android UI.
Instead of writing XML layouts + Java/Kotlin code separately, everything is written in Kotlin using @Composable functions.

🟢 Why it’s better than XML:
Declarative → You just say “what the UI should look like”, and Compose handles the updates automatically.
Less boilerplate → No findViewById, no adapters, no XML inflation.
Reactive state → When data changes, the UI updates automatically.
Faster development → Previews, hot reload (like Flutter/React).
Integration → Works with existing Android Views if needed.
 */