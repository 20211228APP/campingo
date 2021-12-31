package com.example.viewpager2tablayout


import android.media.Image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager2tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tabIcon = listOf(
        R.drawable.ic_baseline_contact_phone_24,
        R.drawable.ic_baseline_image_24,
        R.drawable.ic_baseline_location_on_24
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager.apply {
            adapter = TabAdapter(context as FragmentActivity)  //MyPagerAdapter 객체를 만들어서 Viewpager Adapter속성에 연결함
            setPageTransformer(ZoomOutPageTransformer()) //페이지 넘기는 효과 ZoomOut
        }

        //TabLayout과 ViewPager2연결
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            if(position==0) tab.text = "CONTACT"
            if(position==1) tab.text = "GALLERY"
            if(position==2) tab.text = "MAP"
            tab.setIcon(tabIcon[position])  //탭 아이콘은 위에 만들었던 리스트에서 가져와서 포지션에 따라 다르게 나옴
        }.attach()


    }


}

