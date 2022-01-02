package com.example.viewpager2tablayout.ui.gallery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpager2tablayout.R

import kotlinx.android.synthetic.main.item_image.view.*


class ImageAdapter() : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    var datas = mutableListOf<ImageItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = datas[position]
        val listener = View.OnClickListener { it ->
            val intent = Intent(it.context, ShowActivity::class.java)
            intent.putExtra("Drawable", currentItem.img)
            it.context.startActivity(intent)
        }
        holder.apply {
            bind(currentItem,listener)
            itemView.tag = currentItem
        }
        /*
        holder.bind(datas[position])
         */
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        private var view: View = itemView  //추가
        fun bind(item: ImageItem, listener: View.OnClickListener) { //리스너 추가함
            Glide.with(itemView).load(item.img).into(imgProfile)


            view.img_rv_photo.setImageResource(item.img) //추가
            view.setOnClickListener(listener) //추가
        }

    }

    //여기서부터 추가


}