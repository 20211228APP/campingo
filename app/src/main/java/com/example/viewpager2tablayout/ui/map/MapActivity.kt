package com.example.viewpager2tablayout.ui.map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewpager2tablayout.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val melbourneLocation = LatLng(-37.813, 144.962)
        val melbourne = map.addMarker(
            MarkerOptions()
                .position(melbourneLocation)
        )
//        googleMap.addMarker(MarkerOptions().position(yeouido).title("Marker in Yeouido"))
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(yeouido))
    }
}