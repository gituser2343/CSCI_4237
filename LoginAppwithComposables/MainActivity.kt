package com.example.loginappwithcomposables

import android.os.Bundle
import android.widget.Toast
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginappwithcomposables.ui.theme.LoginAppwithComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           myApp()
            }
        }
}

@Composable
fun myApp() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    ) {
        Text(text = "Login Screen", fontSize = 50.sp,fontWeight = FontWeight.Bold)
        Spacer(Modifier.size(50.dp))
        TextField(value=username, onValueChange ={x->username=x},
            label = {Text("Username", fontSize = 24.sp)},
            textStyle = TextStyle(fontSize=24.sp))
        Spacer(Modifier.size(50.dp))
        TextField(value=password, onValueChange ={x->password=x},
            label = {Text("Password", fontSize = 24.sp)},
            visualTransformation = PasswordVisualTransformation(mask = '*'),
            textStyle = TextStyle(fontSize=24.sp))
        Spacer(Modifier.size(50.dp))
        Button(enabled = f1(username,password), onClick = {
            Toast.makeText(context, "Hello $username", Toast.LENGTH_LONG).show()
        }) {Text("Login", fontSize = 24.sp) }
    }
}

fun f1(username: String, password: String):Boolean {
    return username.isNotBlank() && password.isNotBlank()
}

@Preview(showBackground = true)
@Composable
fun x() {
    myApp()
}