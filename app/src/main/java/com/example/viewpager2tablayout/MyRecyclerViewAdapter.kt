package com.example.viewpager2tablayout

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val dataset: ArrayList<ContactProfileItem>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = dataset.get(position).NAME
        holder.age.text = dataset.get(position).AGE
        holder.call.text = dataset.get(position).CALL
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val age = itemView.findViewById<TextView>(R.id.tv_age)
        val call = itemView.findViewById<TextView>(R.id.tv_call)
    }
}