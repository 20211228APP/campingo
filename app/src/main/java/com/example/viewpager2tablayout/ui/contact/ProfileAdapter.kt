package com.example.viewpager2tablayout.ui.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2tablayout.R

class ProfileAdapter(private val dataset: ArrayList<ProfileItem>) :
    RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
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