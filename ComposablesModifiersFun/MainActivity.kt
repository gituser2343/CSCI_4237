package com.example.composablesmodifiersfun

import androidx.compose.ui.graphics.Color
//import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablesmodifiersfun.ui.theme.ComposablesModifiersFunTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposablesModifiersFunTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    app(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun app(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        myApp()
    }
}

@Composable
fun myApp(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .size(150.dp)
            .background(color=Color.Yellow)
            .padding(8.dp)
            .background(color = Color.Blue)
            .border(4.dp, color = Color.Red)
            .clickable(){println("clicked")}
    ) {
        Text("Hello Modifiers!")

        Text("Hello 2",
            modifier = Modifier.border(2.dp,Color.White)
    )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposablesModifiersFunTheme {
        app()
    }
}