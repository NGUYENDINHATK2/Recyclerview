package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    companion object {
       var  data =  ArrayList<ItemsViewModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(this)
        val datainput : ArrayList<String>?= intent.getStringArrayListExtra("data")
        var data1= datainput?.get(0)
        var data2=datainput?.get(1)

        if(datainput!=null){
            data.add(ItemsViewModel(R.drawable.img,data1.toString() ,data2.toString()))
        }
        val adapter = RecyclerAdapter(data)
        recyclerview.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val intent: Intent = Intent (this, LayoutInput::class.java)

            startActivity(intent)
        }
    }

    // Sao luuw data cu
    override fun onResume() {
        super.onResume()
        binding.recyclerview.adapter?.notifyDataSetChanged()
    }
}