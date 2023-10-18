package com.example.computerasistenteknologi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }


    public void btn_wawasankebangsaan (View view) {
        startActivity(new Intent(getApplicationContext(), wawasankebangsaanLayout.class));
    }

    public void btn_kecerdasan (View view) {
        startActivity(new Intent(getApplicationContext(), kecerdasanLayout.class));
    }

    public void btn_psikotes (View view) {
        startActivity(new Intent(getApplicationContext(), PsikotesLayout2.class));
    }

    public void btn_kecermatan(View view) {
        startActivity(new Intent(getApplicationContext(), KecermatanLayout.class));
    }
}