package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    private Button btnRegistrar2;
    private TextView textRut, textNombre, textPass;
    private EditText editRut, editNombre, editPass;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editNombre = (EditText)findViewById(R.id.editNombre);
        textNombre = (TextView) findViewById(R.id.textNombre);
        editRut = (EditText)findViewById(R.id.editRut);
        textRut = (TextView) findViewById(R.id.textRut);
        editPass = (EditText)findViewById(R.id.editPass);
        textPass = (TextView) findViewById(R.id.textPass);
        btnRegistrar2 = findViewById(R.id.btnRegistrar2);

       // cargarPreferencias();

        btnRegistrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (isValidForm()) {
                        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();


                        guardarPreferencias();
                        sendRegistrarActivity();

                        //Intent i = new Intent(registro.this, MainActivity.class);
                       // i.putExtra("nombreregistro",getSharedNombreRegistro());
                        //startActivity(i);
                        
                        
                    } else {
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
    private boolean isValidForm() {
        boolean r = false;
        if (TextUtils.isEmpty(editNombre.getText())) {
            editNombre.setError("El nombre es obligatorio");
        } else if (TextUtils.isEmpty(editRut.getText())) {
            editRut.setError("El rut es obligatoria");
        } else if (TextUtils.isEmpty(editPass.getText())) {
            editPass.setError("La contraeña es obligatoria");
        } else {
            r = true;
        }
        return r;
    }

    private void sendRegistrarActivity(){
        Intent intent = new Intent(registro.this, splash.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cargarPreferencias();

        //text1.setText( "Nombre guardado: "+getSharedNombre());

    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String nombre=preferences.getString("nombre"," ");
        String rut=preferences.getString("rut"," ");
        String pass=preferences.getString("pass"," ");
        editNombre.setText(nombre);
        editRut.setText(pass);
        editPass.setText(pass);
    }

    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String nombre = editNombre.getText().toString();
        String rut = editRut.getText().toString();
        String pass = editRut.getText().toString();
         SharedPreferences.Editor editor = preferences.edit();
         editor.putString("nombre",nombre);
        editor.putString("rut",rut);
         editor.putString("pass",pass);
         editNombre.setText(nombre);
        editRut.setText(rut);
         editRut.setText(pass);
         editor.commit();


    }

    private String getSharedNombreRegistro() {
        return preferences.getString("nombre", "");
    }



}