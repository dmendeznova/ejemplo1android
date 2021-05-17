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
<<<<<<< HEAD


=======
    private String contadors;
>>>>>>> upstream/main
    private SharedPreferences preferences;
    int c=0;
    private TextView textocontador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        edit1 = findViewById(R.id.edit1);
        btn1 = findViewById(R.id.btn1);
        edit2 = findViewById(R.id.edit2);
        btnRegistar = findViewById(R.id.btnRegistar);
        textocontador= findViewById(R.id.contador);

        preferences = getSharedPreferences("Preference", Context.MODE_PRIVATE);

        //recibirdatos();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String textoEdit1 = edit1.getText().toString();
                String textotextocontador=textocontador.getText().toString();
                text1.setText(textoEdit1);
               // textocontador.setText(textotextocontador);
                if (isValidForm()) {
                    Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                    saveShared(textoEdit1);

                    int aux=c+1;
                    contadors=String.valueOf(aux);
                    saveShared2(contadors);
                    textocontador.setText(contadors);
                    c=aux;
                    sendSecondActivity(textoEdit1);

<<<<<<< HEAD
=======



>>>>>>> upstream/main
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
<<<<<<< HEAD
      //  text1.setText( "Nombre guardado: "+getSharedNombre());

=======
        text1.setText( "Nombre guardado: "+getSharedNombre());
        textocontador.setText("numero de intentos "+getSharedcontador());
>>>>>>> upstream/main
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
    private void saveShared2(String contador){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString( "contador",contador);
        editor.apply();

    }
    private void funcont(){

    }
    private String getSharedNombre(){
        return preferences.getString( "nombre","");
    }
<<<<<<< HEAD



=======
    private String getSharedcontador(){
        return preferences.getString( "contador","");
    }
>>>>>>> upstream/main
}


