package com.edissonescandon.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class logo extends AppCompatActivity {
EditText e1,e2,e3;
Button b1, b2;
Servidor bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        bd=new Servidor(this);
        e1=(EditText)findViewById(R.id.txtUsuario);
        e2=(EditText)findViewById(R.id.txtContraseña);
        b1=(Button)findViewById(R.id.btnIngresar);
        b2=(Button)findViewById(R.id.btnIngreso);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario=e1.getText().toString();
                String contraseña=e2.getText().toString();
                Boolean ingreso=bd.logeanUsuario(usuario,contraseña);
                if(ingreso==true){
                    Toast.makeText(getApplicationContext()," Login Correcto",Toast.LENGTH_SHORT).show();
                    Intent intent =  new Intent(logo.this, activityMenu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext()," Incorrecto, Ingrese nuevamente",Toast.LENGTH_SHORT).show();
                }


            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent da = new Intent(getApplicationContext(),LoguinUsuario.class);
                startActivity(da);

            }
        });

        ImageView imageView =(ImageView)findViewById(R.id.imgClose);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(logo.this, activityMenu.class);
                startActivity(intent);
            }
        });

    }
}