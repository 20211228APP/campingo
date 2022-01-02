package com.example.viewpager2tablayout.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager2tablayout.R
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_imageshow.*

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imageshow)

        val bundle: Bundle = intent.extras!!
        val drawable = bundle.getInt("Drawable")
        expanded_image.setImageResource(drawable)

        setContentView()
    }
    private fun setContentView() {
        val mAdapter = ShowAdapter(getImage(19))
        show_recycler.adapter = mAdapter
        show_recycler.layoutManager = LinearLayoutManager(this)

        mAdapter.itemClick = object: ShowAdapter.ItemClick {
            override fun onClick(view: View, item: ImageItem) {
                expanded_image.setImageResource(item.img)
            }
        }
    }
    private fun getImage(size: Int): ArrayList<ImageItem> {
        val list = ArrayList<ImageItem>()
        for (i in 1 until size) {
            val drawable = when (i) {
                1 -> R.drawable.test1
                2 -> R.drawable.test2
                3 -> R.drawable.test3
                4 -> R.drawable.test4
                5 -> R.drawable.test5
                6 -> R.drawable.test6
                7 -> R.drawable.test7
                8 -> R.drawable.test8
                9 -> R.drawable.test9
                10 -> R.drawable.test10
                11 -> R.drawable.test11
                12 -> R.drawable.test12
                13 -> R.drawable.test13
                14 -> R.drawable.test14
                15 -> R.drawable.test15
                16 -> R.drawable.test16
                17 -> R.drawable.test17
                18 -> R.drawable.test18
                else -> R.drawable.test19
            }
            val item = ImageItem(i)
            list += item
        }
        return list
    }


}