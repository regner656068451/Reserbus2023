package com.example.reserbus21

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.material.navigation.NavigationView

class menubar : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private lateinit var drawer: DrawerLayout
    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menubar)







        val botonDeRes = findViewById<ImageButton>(R.id.boton_agregar_res)
        botonDeRes.setOnClickListener {
            val pedirRes = Intent(this, reserva1::class.java)
            startActivity(pedirRes)
        }






            val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toogle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val startPoint = LatLng(37.7749, -122.4194)
        val endPoint = LatLng(37.4086, -122.0716)
        mMap.addMarker(MarkerOptions().position(startPoint).title("Start"))
        mMap.addMarker(MarkerOptions().position(endPoint).title("End"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 15f))

        val polylineOptions = PolylineOptions()
            .add(startPoint)
            .add(endPoint)
            .color(Color.BLUE)
            .width(5f)

        mMap.addPolyline(polylineOptions)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_eins -> {
                val intent = Intent(this, gestionreservas::class.java)
                startActivity(intent)
            }
            R.id.nav_item_zwei -> {
                val intent = Intent(this, CargarActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_item_drei -> {
                val intent = Intent(this, historialActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_item_sechs -> {
                val intent = Intent(this, TrabajaActivity2::class.java)
                startActivity(intent)
            }
            R.id.nav_item_sieben -> {
                val intent = Intent(this, AyudaActivity2::class.java)
                startActivity(intent)
            }

        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}