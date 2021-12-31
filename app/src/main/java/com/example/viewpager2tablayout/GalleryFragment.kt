package com.example.viewpager2tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.viewpager2tablayout.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    lateinit var imageAdapter: ImageAdapter
    val datas = mutableListOf<ImageData>()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        initRecycler()
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun initRecycler() {
        imageAdapter = ImageAdapter()
        binding.rvGallery.adapter = imageAdapter
        binding.rvGallery.layoutManager = GridLayoutManager(this.context, 3)

        datas.apply {
            add(ImageData(img = R.drawable.test1))
            add(ImageData(img = R.drawable.test2))
            add(ImageData(img = R.drawable.test3))
            add(ImageData(img = R.drawable.test4))
            add(ImageData(img = R.drawable.test5))
            add(ImageData(img = R.drawable.test6))
            add(ImageData(img = R.drawable.test7))
            add(ImageData(img = R.drawable.test8))
            add(ImageData(img = R.drawable.test9))
            add(ImageData(img = R.drawable.test10))
            add(ImageData(img = R.drawable.test11))
            add(ImageData(img = R.drawable.test12))
            add(ImageData(img = R.drawable.test13))
            add(ImageData(img = R.drawable.test14))
            add(ImageData(img = R.drawable.test15))
            add(ImageData(img = R.drawable.test16))
            add(ImageData(img = R.drawable.test17))
            add(ImageData(img = R.drawable.test18))
            add(ImageData(img = R.drawable.test19))



            imageAdapter.datas = datas
            imageAdapter.notifyDataSetChanged()
        }
    }
}

