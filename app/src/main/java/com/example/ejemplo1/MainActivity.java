package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ejemplo1.registro;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private EditText edit1, edit2;
    private Button btn1, btnRegistar;
    private String valor;


    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        edit1 = findViewById(R.id.edit1);
        btn1 = findViewById(R.id.btn1);
        edit2 = findViewById(R.id.edit2);
        btnRegistar = findViewById(R.id.btnRegistar);

        preferences = getSharedPreferences("Preference", Context.MODE_PRIVATE);

        //recibirdatos();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoEdit1 = edit1.getText().toString();
                text1.setText(textoEdit1);
                if (isValidForm()) {
                    Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                    saveShared(textoEdit1);

                    sendSecondActivity(textoEdit1);

                } else {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRegistrarActivity();

            }
        });
    }

    private void recibirdatos(){
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("nombreregistro");

        text1.setText(d1);

    }

    @Override
    protected void onStart() {
        super.onStart();
      //  text1.setText( "Nombre guardado: "+getSharedNombre());

    }

    private boolean isValidForm() {
        boolean r = false;
        if (TextUtils.isEmpty(edit1.getText())) {
            edit1.setError("El nombre es obligatorio");
        } else if (TextUtils.isEmpty(edit2.getText())) {
            edit2.setError("La contraeña es obligatoria");
        } else {
            r = true;
        }
        return r;
    }

    private void sendRegistrarActivity(){
        Intent intent = new Intent(MainActivity.this, registro.class);
        startActivity(intent);
    }


    private void sendSecondActivity(String nombre) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        Bundle b = new Bundle();
        b.putString("nombre", nombre);
        intent.putExtras(b);
        startActivity(intent);
    }

    private void saveShared(String nombre){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString( "nombre",nombre);
        editor.apply();
    }

    private String getSharedNombre(){
        return preferences.getString( "nombre","");
    }



}


