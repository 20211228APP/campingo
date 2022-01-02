package com.example.viewpager2tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.viewpager2tablayout.ui.contact.ProfileItem
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import org.json.JSONObject


class MapFragment : Fragment(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_map, container, false)
        rootView.findViewById<CardView>(R.id.card_view).visibility = View.GONE
        setupMap()
        return rootView
    }

    private fun setupMap() {
        (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
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

        for (profile in result) {
            val name = profile.NAME
            val location = profile.Location
            val call = profile.CALL
            val latitude: Double = profile.latitude
            val longitude: Double = profile.longitude

            val markerOptions = MarkerOptions()
            markerOptions.position(LatLng(latitude, longitude))
            markerOptions.title(name)
            markerOptions.icon(BitmapDescriptorFactory.fromAsset("tentMarker.ico"))

            val marker: Marker? = googleMap.addMarker(markerOptions) //핀 추가 및 마커 생성
            if (marker != null) {
                marker.tag =
                    name+ "/" + call + "/" + location
            }
        }




        val korea = LatLng(36.38, 127.51)

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(korea, 7f))
//
        googleMap!!.setOnMarkerClickListener(object : GoogleMap.OnMarkerClickListener {
            override fun onMarkerClick(marker: Marker): Boolean {

                activity?.findViewById<CardView>(R.id.card_view)?.visibility  = View.VISIBLE
                var campingName: TextView? = activity?.findViewById<TextView>(R.id.camping_name)
                var campingCall: TextView? = activity?.findViewById<TextView>(R.id.camping_call)
                var campingLocation: TextView? = activity?.findViewById<TextView>(R.id.camping_location)
                var arr = marker.tag.toString().split("/") //마커에 붙인 태그
                if (campingName != null) {
                    campingName.text = arr[0]
                }
                if (campingCall != null) {
                    campingCall.text = arr[1]
                }
                if (campingLocation != null) {
                    campingLocation.text = arr[2]
                }
                return false
            }
        })
//
        googleMap!!.setOnMapClickListener(object : GoogleMap.OnMapClickListener {
            override fun onMapClick(latLng: LatLng) {
                activity?.findViewById<CardView>(R.id.card_view)?.visibility  = View.GONE
            }
        })
    }


}