package com.edissonescandon.projectmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleUniforme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_uniforme);

        TextView titulo = (TextView) findViewById(R.id.txtNomEscuela);
        TextView detalles = (TextView) findViewById(R.id.txtdetalleuni);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }

}
