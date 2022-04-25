package com.example.recyclerview

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class RecyclerAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
//    onCreateViewHolder (): Hàm này thiết lập các khung nhìn để hiển thị các mục.
//onBindViewHolder (): Hàm này được sử dụng để liên kết các mục trong danh sách với các widget của chúng tôi như TextView, ImageView, v.v.
//getItemCount (): Nó trả về số lượng các mục có trong danh sách.


private lateinit var mListener:onItemClickListener


interface  onItemClickListener{

    fun onItemClick(position:Int)
}
    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
//        v.setBackgroundColor(Color.argb(randomColor(),randomColor(),randomColor(),randomColor() ))
        return  ViewHolder(v,mListener)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        val ItemsViewModel=mList[position]
        holder.itemtitle.text=ItemsViewModel.title
        holder.itemdetail.text=ItemsViewModel.detail
        holder.itemimage.setImageResource(ItemsViewModel.image)

//        holder.itenbtn.setOnClickListener{
//            Toast.makeText(holder.itemView.context,"Clicked ${ItemsViewModel.title}",Toast.LENGTH_SHORT).show()
//
//            val intent = Intent(holder.itemView.context,MainActivity2::class.java)
//            intent.putExtra("data", "Hello screen2!")
//            startActivity(holder.itemView.context,intent,null)
//        }
    }

    override fun getItemCount(): Int {
       return mList.size
    }



    inner  class ViewHolder(itemView: View,listener:onItemClickListener):RecyclerView.ViewHolder(itemView){

       var itemimage: ImageView
       var itemtitle: TextView
       var itemdetail :TextView
       var itenbtn : Button
       init{
           itemimage=itemView.findViewById(R.id.item_image)
           itemtitle=itemView.findViewById(R.id.item_title)
           itemdetail=itemView.findViewById(R.id.item_detail)
           itenbtn=itemView.findViewById(R.id.item_button)

           itenbtn.setOnClickListener{
               listener.onItemClick(adapterPosition)
           }

       }
     }


}