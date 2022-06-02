
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
//import androidx.lifecycle.Transformations.map
import com.example.google_maps.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null

    // below are the latitude and longitude
    // of 4 different locations.
    var kel = LatLng(35.290630, -118.995827)
    var Ruhuna = LatLng(35.290630, -118.995827)
    var Jaffna = LatLng(9.665280, 80.018520)
   // var Brisbane = LatLng(-27.470125, 153.021072)

    // creating array list for adding all our locations.
    private var locationArrayList: ArrayList<LatLng>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

        // in below line we are initializing our array list.
        locationArrayList = ArrayList()

        // on below line we are adding our
        // locations in our array list.
        locationArrayList!!.add(kel)
        locationArrayList!!.add(Ruhuna)
        locationArrayList!!.add(Jaffna)
       // locationArrayList!!.add(Brisbane)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // inside on map ready method
        // we will be displaying all our markers.
        // for adding markers we are running for loop and
        // inside that we are drawing marker on our map.
        for (i in locationArrayList!!.indices) {

            // below line is use to add marker to each location of our array list.
            mMap!!.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker"))

            // below lin is use to zoom our camera on map.
            mMap!!.animateCamera(CameraUpdateFactory.zoomTo(18.0f))

            // below line is use to move our camera to the specific location.
            mMap!!.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!![i]))
        }
    }
}