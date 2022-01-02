package com.example.viewpager2tablayout.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2tablayout.R
import kotlinx.android.synthetic.main.gallery_show_item.view.*

class ShowAdapter (private val ShowList: ArrayList<ImageItem>) :
    RecyclerView.Adapter<ShowAdapter.ShowViewHolder>(){
    var datas = mutableListOf<ImageItem>()

    interface  ItemClick {
        fun onClick(view: View, item: ImageItem)
    }
    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.gallery_show_item,
            parent, false
        )
        return ShowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val currentItem = datas[position]

        val listener = View.OnClickListener {

        }
        holder.apply {
            setItem(listener, currentItem)
            itemView.tag = currentItem
        }

        if(itemClick != null) {
            holder?.itemView?.setOnClickListener { v ->
                itemClick?.onClick(v, currentItem)
            }
        }
    }

    override fun getItemCount() = datas.size

    class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(listener: View.OnClickListener, item: ImageItem) {
            itemView.show_view.setImageResource(item.img)
            itemView.setOnClickListener(listener)
        }
    }
}