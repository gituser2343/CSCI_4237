package com.example.valentine_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var img: ImageView
    private lateinit var name: TextView
    private lateinit var msg: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        img = findViewById(R.id.imageView)
        name = findViewById(R.id.inputName)
        msg = findViewById(R.id.message)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            img.visibility = View.VISIBLE
            msg.text = "Happy Valentine's Day " + name.text + "!"
        }
    }
}