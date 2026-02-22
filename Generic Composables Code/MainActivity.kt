//replace XXXXXXXXX with package name.  The package name is com.example. followed by the name assigned to a new project in lowercase and excluding spaces
//See Android->app->kotlin+java to see the package name
//edit myApp()

package com.example.XXXXXXXXX

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myApp()
        }
    }
}

@Composable
fun myApp(modifier: Modifier = Modifier) {
    Column (
        modifier=Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    ) {
        Text("Hello Modifiers!")

        Text("Hello 2", modifier = Modifier.border(2.dp, Color.White))
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    myApp()
}