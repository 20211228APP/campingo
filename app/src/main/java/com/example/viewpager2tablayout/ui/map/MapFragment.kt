package com.example.viewpager2tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {
//    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_map, container, false)
        setupMap()
        return rootView
    }

    private fun setupMap() {
        (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val seoul = LatLng(-37.813, 144.962)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(12f))

        //마커 출력
        val marker = MarkerOptions()
            .position(seoul)
            .title("Nowon")
            .snippet("노원역입니다.")
        googleMap?.addMarker(marker)
    }

}