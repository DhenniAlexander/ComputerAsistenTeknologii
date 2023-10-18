package com.example.computerasistenteknologi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PsikotesLayout2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikotes_layout2);
    }

    public void btn_soalpsikotes1(View view) {

        startActivity(new Intent(getApplicationContext(), psikotesLayout.class));
    }
}