package bruno.googlemapsandroidapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,LocationListener {

    private LocationManager lm;
    private Location location;
    private double longitude = -25.429675;
    private double latitude = -49.271870;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 60000, this);

    }


    @Override
    public void onMapReady(GoogleMap map) {
        if (lm != null) {
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();

            }
        }

        map.setMyLocationEnabled(true);
        map.setTrafficEnabled(true);

        map.addMarker(new MarkerOptions().position(new LatLng(-25.443150, -49.238243)).title("Jardim Botânico"));
        map.addMarker(new MarkerOptions().position(new LatLng(-25.389681, -49.231168)).title("Parque Bacaheri"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 11));
    }



    @Override
    public void onLocationChanged(Location arg0) {

    }

    @Override
    public void onProviderDisabled(String arg0) {

    }

    @Override
    public void onProviderEnabled(String arg0) {

    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

    }


}
