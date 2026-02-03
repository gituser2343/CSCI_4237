package com.example.loginappweek3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var v1: Button
    private lateinit var v2: EditText
    private lateinit var v3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        v1 = findViewById(R.id.button)
        v2 = findViewById(R.id.username)
        v3 = findViewById(R.id.password)
        v1.setEnabled(false)
        v2.addTextChangedListener(myTextWatcher)
        v3.addTextChangedListener(myTextWatcher)
        v1.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("username", v2.text.toString())
            startActivity(i)
        }
    }
    private val myTextWatcher: TextWatcher = object: TextWatcher{
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {

        }

        override fun onTextChanged(
            s: CharSequence?,
            start: Int,
            before: Int,
            count: Int
        ) {
            val b1 = v2.text.toString().isNotBlank()
            val b2 = v3.text.toString().isNotBlank()
            val b3 = b1 && b2
            v1.setEnabled(b3)

        }
    }
}