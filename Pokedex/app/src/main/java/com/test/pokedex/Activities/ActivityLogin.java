package com.test.pokedex.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.test.pokedex.R;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    private static String TAG = "LOGIN";
    private Context context = this;
    private String username, password;

    private EditText nombreUsuarioTexto;
    private EditText contrasenaTexto;
    private Button inicioSesionBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        manageIntent(((ActivityLogin)context).getIntent());

        initializeComponents();
        initializeListeners();
        initializeData();


        System.out.println(TAG + " " + username);
        Log.i(TAG,password);

    }

    public void manageIntent(Intent intent){
        if(intent != null){
            username = intent.getStringExtra("USERNAME");
            password = intent.getStringExtra("PASSWORD");
        }
    }

    public void initializeComponents(){
        nombreUsuarioTexto = findViewById(R.id.nombre_usuario_login);
        contrasenaTexto    = findViewById(R.id.contrasena_login);
        inicioSesionBoton  = findViewById(R.id.boton_login);
    }

    public void initializeListeners(){
        inicioSesionBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(nombreUsuarioTexto.getText().toString(),contrasenaTexto.getText().toString());
            }
        });
    }

    public void initializeData(){

    }

    public void login(String nombreUsuario, String contrasena){
        if(nombreUsuario.equals("")){
            Toast.makeText(context,"El nombre de usuario no puede estar vacío", Toast.LENGTH_LONG).show();
            nombreUsuarioTexto.setFocusable(true);
        }else if(contrasena.equals("")){
            Toast.makeText(context,"La contraseña no puede estar vacía", Toast.LENGTH_LONG).show();
            contrasenaTexto.setFocusable(true);
        }else{
            if(nombreUsuario.equals("pokedex") && contrasena.equals("pokedex")){
                Intent intent = new Intent(ActivityLogin.this, ActivityList.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        |Intent.FLAG_ACTIVITY_NEW_TASK
                        |Intent.FLAG_ACTIVITY_SINGLE_TOP);

                startActivity(intent);

            }else{
                Toast.makeText(context,"El nombre de usuario o la contraseña no no son correctos", Toast.LENGTH_LONG).show();
            }
        }
    }




}
