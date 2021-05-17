package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.ejemplo1.MainActivity;



public class splash extends AppCompatActivity {

    private final int DURACION_SPLASH = 3000;
    private TextView text1;
    private EditText edit1;
    private SharedPreferences preferences;
    private String getSharedNombre = "ee";







    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        text1 = findViewById(R.id.text1);
        edit1 = findViewById(R.id.edit1);

        preferences = getSharedPreferences("Preference", Context.MODE_PRIVATE);




        new Handler().postDelayed(new Runnable(){
            public void run(){
                    if(getSharedNombre.isEmpty()){
                        Intent intent = new Intent(splash.this, Activity2.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(splash.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
            };
        }, DURACION_SPLASH);
    }









}
