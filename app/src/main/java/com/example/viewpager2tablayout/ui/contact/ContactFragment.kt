
package com.example.viewpager2tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2tablayout.ui.contact.ProfileItem
import com.example.viewpager2tablayout.ui.contact.ProfileAdapter
import com.example.viewpager2tablayout.databinding.FragmentContactBinding
import org.json.JSONObject

//프레그먼트를 이용
class ContactFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: ProfileAdapter? = null

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactBinding.inflate(inflater, container, false)

        val assetManager = resources.assets
        val inputStream = assetManager.open("ContactData.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        var result: ArrayList<ProfileItem> = arrayListOf()
        val jObject = JSONObject(jsonString)
        val jArray = jObject.getJSONArray("ContactData")

        for (i in 0 until jArray.length()) {
            val obj = jArray.getJSONObject(i)
            val name = obj.getString("NAME")
            val location = obj.getString("Location")
            val call = obj.getString("CALL")
            val latitude = obj.getDouble("latitude")
            val longitude = obj.getDouble("longitude")
            result.add(ProfileItem(name, location, call, latitude, longitude))
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = ProfileAdapter(result)
        }

        return binding.root
    }
}

