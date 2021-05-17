package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private TextView text1_dos;
    private CheckBox check1;
    private Button btn_atras_dos;
    private final int DURACION_SPLASH = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        text1_dos = findViewById(R.id.text1_dos);
        btn_atras_dos = findViewById(R.id.btn_atras_dos);



        Bundle bundle = this.getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        text1_dos.setText(nombre);

        btn_atras_dos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Activity2.this, splash.class);
                        startActivity(intent);
                        finish();
                    }
                }, DURACION_SPLASH);
            }
        });
    }
}


