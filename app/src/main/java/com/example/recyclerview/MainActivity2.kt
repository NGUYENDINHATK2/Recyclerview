package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var  binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val data_ : String? = intent.getStringExtra("data")
        binding.textView.text=data_.toString()



    }
}