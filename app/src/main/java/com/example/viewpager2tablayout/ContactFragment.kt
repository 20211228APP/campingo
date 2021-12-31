
package com.example.viewpager2tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2tablayout.databinding.FragmentContactBinding
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException

//프레그먼트를 이용
class ContactFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: MyRecyclerViewAdapter? = null

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

        var result: ArrayList<ContactProfileItem> = arrayListOf()
        val jObject = JSONObject(jsonString)
        val jArray = jObject.getJSONArray("ContactData")

        for (i in 0 until jArray.length()) {
            val obj = jArray.getJSONObject(i)
            val name = obj.getString("NAME")
            val age = obj.getString("AGE")
            val call = obj.getString("CALL")
            result.add(ContactProfileItem(name, age, call))
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = MyRecyclerViewAdapter(result)
        }

        return binding.root
    }
}

