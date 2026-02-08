package com.example.countrylistapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var v1: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        v1 = findViewById(R.id.CountryListView)
        var countries=resources.getStringArray(R.array.countries)
        var a = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        v1.adapter = a
        v1.setOnItemClickListener {parent, view, position, id ->
            val country: String = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "You Selected $country", Toast.LENGTH_LONG).show()
        }
    }
}