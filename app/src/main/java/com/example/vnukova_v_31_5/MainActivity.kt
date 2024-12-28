package com.example.vnukova_v_31_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vnukova_v_31_5.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}
@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController()
        val isLoggedIn = remember { mutableStateOf(false) }

        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                LoginScreen(onLoginSuccess = {
                    isLoggedIn.value = true
                    navController.navigate("personal_area")
                })
            }
            composable("personal_area") {
                if (isLoggedIn.value){
                    PersonalAreaScreen(
                        onSettingsClick = {
                            navController.navigate("settings")
                        },
                        onLogout = {
                            isLoggedIn.value = false
                            navController.navigate("login")
                        }
                    )
                }

            }
            composable("settings") {
                SettingsScreen(onBackPressed = {
                    navController.popBackStack()
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}