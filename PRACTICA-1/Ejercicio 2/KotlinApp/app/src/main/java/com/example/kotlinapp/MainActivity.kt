package com.example.kotlinapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(217, 106, 199),
                            ),
                            navigationIcon = {
                                Icon(
                                    painterResource(R.drawable.ic_pri),
                                    contentDescription = null
                                )
                            }, title = {
                                Text("Navegation")
                            })
                    },
                    bottomBar = { BottomNavigationBar(navController) }) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(it)) {
                        NavHost(
                            modifier = Modifier,
                            navController = navController,
                            startDestination = "textfields"
                        ) {
                            composable("textfields") { TextFieldsScreen() }
                            composable("buttons") { ButtonsScreen() }
                            composable("selection") {
                                SelectionScreen {
                                    startActivity(
                                        Intent(
                                            this@MainActivity,
                                            SecondActivity::class.java
                                        )
                                    )
                                }
                            }
                            composable("lists") { ListsScreen() }
                            composable("information") { InformationScreen() }
                        }
                    }
                }
            }
        }
    }
}

