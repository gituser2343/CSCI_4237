package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
        myApp()
        }
    }
}

@Composable fun myApp() {
    var counter by remember { mutableIntStateOf(0) }
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Text("You have clicked the button this many times", fontSize = 24.sp)
        Text("$counter", fontSize = 24.sp)
        Button(onClick = {
            counter++
            Log.d("counter", "$counter")
        }) {
            Text("Click Me")
        }
    }
}

//@Preview(showBackground = true)
