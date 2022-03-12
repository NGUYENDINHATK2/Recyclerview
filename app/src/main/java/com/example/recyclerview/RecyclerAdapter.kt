package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()  {
//    onCreateViewHolder (): Hàm này thiết lập các khung nhìn để hiển thị các mục.
//onBindViewHolder (): Hàm này được sử dụng để liên kết các mục trong danh sách với các widget của chúng tôi như TextView, ImageView, v.v.
//getItemCount (): Nó trả về số lượng các mục có trong danh sách.

    private var titles=arrayOf("c1","c2")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        val ItemsViewModel=mList[position]
        holder.itemtitle.text=ItemsViewModel.title
        holder.itemdetail.text=ItemsViewModel.detail
        holder.itemimage.setImageResource(ItemsViewModel.image)
    }

    override fun getItemCount(): Int {
       return mList.size
    }
 inner  class ViewHolder(itemView: View ):RecyclerView.ViewHolder(itemView){

       var itemimage: ImageView
       var itemtitle: TextView
       var itemdetail :TextView
       init{
           itemimage=itemView.findViewById(R.id.item_image)
           itemtitle=itemView.findViewById(R.id.item_title)
           itemdetail=itemView.findViewById(R.id.item_detail)
       }

    }






}