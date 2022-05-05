package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    companion object {
       var  newArrayList =  ArrayList<ItemsViewModel>()
        var itemArrayList=ArrayList<ItemsViewModel>()
        var savedata=ArrayList<ItemsViewModel>()
    }
    private lateinit var newRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        getData()
        binding.countrySearch.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                itemArrayList.clear()
                val searchtext=newText!!.toLowerCase(Locale.getDefault())
                if(searchtext.isNotEmpty()){

                    newArrayList.forEach {
                        if(it.title .toLowerCase(Locale.getDefault()).contains(searchtext)){
                            itemArrayList.add(it)
                        }
                    }
                    binding.recyclerview.adapter?.notifyDataSetChanged()
                }
                else{
                    itemArrayList.clear()
                    itemArrayList.addAll(newArrayList)
                    binding.recyclerview.adapter?.notifyDataSetChanged()
                }
                return false
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

    fun getData(){
        val recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(this)

        binding.itemImage.setImageResource(R.drawable.img)
        newArrayList.add(ItemsViewModel(R.drawable.img,"A" ,"asdassdfd"))
        newArrayList.add(ItemsViewModel(R.drawable.img,"BA" ,"asdasfssd"))
        newArrayList.add(ItemsViewModel(R.drawable.img,"C" ,"asdasfdfsd"))
        newArrayList.add(ItemsViewModel(R.drawable.img,"D" ,"asdasfsfsd"))
        newArrayList.add(ItemsViewModel(R.drawable.img,"E" ,"asdafssfdsd"))
        newArrayList.add(ItemsViewModel(R.drawable.img,"F" ,"asdafssfsd"))

        itemArrayList.addAll(newArrayList)
        savedata.addAll(newArrayList)
        var adapter = RecyclerAdapter(itemArrayList )
        recyclerview.adapter = adapter
        adapter.setOnItemClickListener(object :RecyclerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity,newArrayList[position].title,Toast.LENGTH_SHORT).show()
            }

            override fun onItemClickView(position: Int) {
                Toast.makeText(this@MainActivity,newArrayList[position].detail,Toast.LENGTH_SHORT).show()
            }

        })


    }
}