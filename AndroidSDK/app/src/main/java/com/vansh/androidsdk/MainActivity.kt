package com.vansh.androidsdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vansh.androidsdk.ui.theme.AndroidSDKTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSDKTheme {

            }
        }
    }
}

// ✨ viewmodel
//class MainActivity : ComponentActivity() {
//
//    // given by android
//    private val viewModel by viewModels<ContactsViewModel>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            AndroidSDKTheme {
//                // compose viewmodel
//                // this dependency -> implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.3")
//                // val vieModel = viewModel<ContactsViewModel>()
//                // if we have to pass argument to viewmodel
//                /*
//                    val vieModel = viewModel<ContactsViewModel>(
//                        factory = object : ViewModelProvider.Factory{
//                            override fun <T: ViewModel> create(modelClass: Class<T>): T{
//                                return ContactsViewModel("arguments") as T
//                            }
//                        }
//                    )
//                 */
//                ViewModelScreen(viewModel)
//            }
//        }
//    }
//}


// ✨ Activity
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            AndroidSDKTheme {
//
//            }
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//
//    override fun onPause() {
//        super.onPause()
//    }
//
//    override fun onStop() {
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//    }
//}
