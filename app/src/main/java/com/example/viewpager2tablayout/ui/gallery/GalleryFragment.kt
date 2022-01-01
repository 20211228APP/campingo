package com.example.viewpager2tablayout

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.viewpager2tablayout.ui.gallery.ImageAdapter
import com.example.viewpager2tablayout.ui.gallery.ImageItem
import com.example.viewpager2tablayout.databinding.FragmentGalleryBinding
import com.example.viewpager2tablayout.ui.gallery.GalleryGridDecoration

class GalleryFragment : Fragment() {
    lateinit var imageAdapter: ImageAdapter
    val datas = mutableListOf<ImageItem>()

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
        binding.rvGallery.addItemDecoration(GalleryGridDecoration(dpToPx(this, 1f)))
        binding.rvGallery.layoutManager = GridLayoutManager(this.context, 3)

        datas.apply {
            add(ImageItem(img = R.drawable.test1))
            add(ImageItem(img = R.drawable.test2))
            add(ImageItem(img = R.drawable.test3))
            add(ImageItem(img = R.drawable.test4))
            add(ImageItem(img = R.drawable.test5))
            add(ImageItem(img = R.drawable.test6))
            add(ImageItem(img = R.drawable.test7))
            add(ImageItem(img = R.drawable.test8))
            add(ImageItem(img = R.drawable.test9))
            add(ImageItem(img = R.drawable.test10))
            add(ImageItem(img = R.drawable.test11))
            add(ImageItem(img = R.drawable.test12))
            add(ImageItem(img = R.drawable.test13))
            add(ImageItem(img = R.drawable.test14))
            add(ImageItem(img = R.drawable.test15))
            add(ImageItem(img = R.drawable.test16))
            add(ImageItem(img = R.drawable.test17))
            add(ImageItem(img = R.drawable.test18))
            add(ImageItem(img = R.drawable.test19))



            imageAdapter.datas = datas
            imageAdapter.notifyDataSetChanged()
        }
    }

    fun dpToPx(context: GalleryFragment, dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
    }
}

