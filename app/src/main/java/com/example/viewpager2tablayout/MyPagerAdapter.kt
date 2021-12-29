package com.example.viewpager2tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val NUM_PAGES = 3

    override fun getItemCount(): Int = NUM_PAGES  //만들 페이지 수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MyFragment.newInstance("CONTACT", "")
            }
            1 -> {
                MyFragment.newInstance("GALLERY", "")
            }
            else -> {
                MyFragment.newInstance("Page3", "")
            }
        }
    }
}