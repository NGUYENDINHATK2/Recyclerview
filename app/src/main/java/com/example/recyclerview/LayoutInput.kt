package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.InputLayoutBinding

class LayoutInput: AppCompatActivity() {
    private lateinit var  binding:InputLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InputLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            val intent: Intent = Intent (this, MainActivity::class.java)

//            val datainput = intent.getStringArrayListExtra("data")
//            datainput?.add(ItemsViewModel(R.drawable.raiden,binding.tvtitle.text.toString() ,binding.tvdetail.text.toString()).toString())
//            intent.putExtra("data",datainput)

            val datadetail=ArrayList<String>()
            val data=ArrayList<String>()
            data.add(binding.tvtitle.text.toString())
            data.add(binding.tvdetail.text.toString())
            intent.putExtra("data",data)
            startActivity(intent)
        }
    }
}