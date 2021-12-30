package com.ewelionp.myrestaurantappquailcuisine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InfoFragment extends Fragment implements OnMapReadyCallback {

    TextView website;
    TextView email;
    TextView phone;

    GoogleMap mMap;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_info, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map_view);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        website = v.findViewById(R.id.textViewWebsite);
        email = v.findViewById(R.id.textViewEmail);
        phone = v.findViewById(R.id.textViewPhone);

        setListeners();

        return v;
    }


    /**
     * Setting OnClickListeners for bottom_nav_menu
     */
    private void setListeners() {

        website.setOnClickListener(v -> {
            Intent website_intent = new Intent(Intent.ACTION_VIEW);

            //TODO amend the below website
            website_intent.setData(Uri.parse("http://www.bbc.co.uk"));
            startActivity(website_intent);
        });

        email.setOnClickListener(v -> {
            Intent email_intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", getString(R.string.email_address), null));

            email_intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject_main_enquiry));
            startActivity(email_intent);
        });

        phone.setOnClickListener(v -> {
            Intent phone_intent = new Intent(Intent.ACTION_DIAL);

            phone_intent.setData(Uri.parse(getString(R.string.phone_number)));
            startActivity(phone_intent);

        });


    }

    /**
     * Implementing a method required by OnMapReadyCallback
     *
     * @param googleMap googleMap
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Quail Cuisine location and move the camera
        LatLng qc = new LatLng(51.50838, -0.22084);
        mMap.addMarker(new MarkerOptions().position(qc).title(getString(R.string.quail_cuisine))).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(qc, 14.5f));
        mMap.getUiSettings().setZoomGesturesEnabled(true);


    }

}
