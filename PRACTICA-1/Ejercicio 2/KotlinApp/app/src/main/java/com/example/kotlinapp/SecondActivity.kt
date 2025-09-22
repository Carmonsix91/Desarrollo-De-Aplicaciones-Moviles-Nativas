package com.example.kotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinapp.ui.theme.KotlinAppTheme

class SecondActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(255, 152, 0, 255),
                            ),
                            navigationIcon = {
                                Icon(
                                    painterResource(R.drawable.ic_se),
                                    contentDescription = null
                                )
                            }, title = {
                                Text("Second Activity")
                            })
                    }, bottomBar = { SecondActivityBottomBar(navController = navController) }
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.fillMaxSize().padding(innerPadding ),
                        navController = navController,
                        startDestination = "lists"
                    ) {
                        composable("lists") { ListsScreen() }
                        composable("information") { InformationScreen() }
                    }
                }
            }
        }
    }
}
