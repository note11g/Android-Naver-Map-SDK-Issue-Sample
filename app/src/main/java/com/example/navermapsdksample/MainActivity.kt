package com.example.navermapsdksample

import android.os.Bundle
import androidx.annotation.UiThread
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentActivity
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback

class MainActivity : FragmentActivity(), OnMapReadyCallback {
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mapFragment = supportFragmentManager.run {
            findFragmentById(R.id.map) as MapFragment?
                ?: MapFragment.newInstance().also {
                    beginTransaction().add(R.id.map, it).commit()
                }
        }
        mapFragment.getMapAsync(this)

        findViewById<AppCompatButton>(R.id.btn_refresh_map).setOnClickListener { forceRefreshMap() }
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
    }

    private fun forceRefreshMap() {
        naverMap.forceRefresh() // Unresolved reference: forceRefresh
    }
}
