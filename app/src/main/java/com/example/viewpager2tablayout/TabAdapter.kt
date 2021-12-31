package com.example.viewpager2tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val NUM_PAGES = 3

    override fun getItemCount(): Int = NUM_PAGES  //만들 페이지 수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ContactFragment()
            1 -> GalleryFragment()
            else -> MapFragment()
        }
    }
}
