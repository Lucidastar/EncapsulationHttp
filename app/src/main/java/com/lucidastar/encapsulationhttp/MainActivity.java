package com.lucidastar.encapsulationhttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lucidastar.encapsulationhttp.ui.VenueActivity;

import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openVenue(View view) {
        startActivity(new Intent(this, VenueActivity.class));
    }
    public void openVenueDetail(View view) {

    }
}
