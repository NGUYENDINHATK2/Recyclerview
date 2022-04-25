package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
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
        binding.itemImage.setImageResource(R.drawable.img)
        if(datainput!=null){
            data.add(ItemsViewModel(R.drawable.img,data1.toString() ,data2.toString()))
        }
        var adapter = RecyclerAdapter(data)
        recyclerview.adapter = adapter
        adapter.setOnItemClickListener(object :RecyclerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity,data[position].title,Toast.LENGTH_SHORT).show()
            }

        })





        binding.fabAdd.setOnClickListener {
            val intent: Intent = Intent (this, LayoutInput::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        binding.recyclerview.adapter?.notifyDataSetChanged()
    }
}