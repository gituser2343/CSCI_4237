package com.example.iamrichdiamondcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.iamrichdiamondcomposable.ui.theme.IAmRichDiamondComposableTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IAmRichDiamondComposableTheme {
                myApp()
            }
        }
    }
}

@Composable
fun myApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding).fillMaxWidth()
        )
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isVisible by remember { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hello World!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier,
            textAlign = TextAlign.Center
        )
        if (isVisible==1) {
            Image(
                painterResource(R.drawable.diamond_image),
                contentDescription = "Diamond",
                modifier = Modifier.size(150.dp)
            )
        }
        if (isVisible==1) {
            Text(
                text = "I am Poor!",
                modifier = modifier,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        }
        if (isVisible==0) {
            Text(
                text = "I am Rich!",
                modifier = modifier,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        }
        Button(onClick = {isVisible=1}) {Text("Click Me!") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IAmRichDiamondComposableTheme {
        myApp()
    }
}