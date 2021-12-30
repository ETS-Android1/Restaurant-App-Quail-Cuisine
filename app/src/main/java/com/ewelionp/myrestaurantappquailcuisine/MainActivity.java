package com.ewelionp.myrestaurantappquailcuisine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavView = findViewById(R.id.bottom_nav);

        navBarListener();


    }

    /**
     * Set up navBar listeners
     */
    private void navBarListener() {
        mBottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.restaurant_menu:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_content, new com.ewelionp.myrestaurantappquailcuisine.MenuFragment())
                            .commit();
                    break;

                case R.id.bookings:
                    Intent email_intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", getString(R.string.email_address), null));

                    email_intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject_booking_enquiry));
                    startActivity(email_intent);
                    break;

                case R.id.findus:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_content, new InfoFragment())
                            .commit();
                    break;

            }
            return true;
        });
    }

    /**
     * Adding options menu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     * Adding options to the options menu
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.administrator:
                Toast.makeText(this, "Working progress", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}