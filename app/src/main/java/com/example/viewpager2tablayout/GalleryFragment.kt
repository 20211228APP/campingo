package com.example.viewpager2tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2tablayout.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var imageAdapter: ImageAdapter
    val datas = mutableListOf<ImageData>()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        initRecycler()
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            GalleryFragment().apply {
                initRecycler()
            }

    }

    private fun initRecycler() {
        imageAdapter = ImageAdapter()
        binding.rvGallery.adapter = imageAdapter
        binding.rvGallery.layoutManager = GridLayoutManager(this.context, 3)

        datas.apply {
            add(ImageData(img = R.drawable.ic_baseline_contact_phone_24))
            add(ImageData(img = R.drawable.ic_baseline_image_24))
            add(ImageData(img = R.drawable.ic_baseline_info_24))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test))
            add(ImageData(img = R.mipmap.test23))


            imageAdapter.datas = datas
            imageAdapter.notifyDataSetChanged()
        }
    }
}

