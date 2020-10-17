package com.edissonescandon.projectmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainDetalleUniforme extends AppCompatActivity {
    ListView lista;
    String[][] datos = {
            {"Chompa Mujer", "Selecciono 2 chompas","Talla: 38","12$  v/u", "Compra Guardada"},
            {"Uniforme de Gala", "Selecciono 1 uniforme de Gala","Talla: 40","36$ v/u", "Compra Guardada"},
            {"Uniforme Deportivo","Selecciono 1 uniforme Deportivo","Talla: 36","50% v/u", "Compra Guardada"},

    };
    int[] datosImg = { R.drawable.ri, R.drawable.uni,R.drawable.tec};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_escuela);

        lista = (ListView) findViewById(R.id.lvLista);
        lista.setAdapter(new Adaptador(this, datos, datosImg));
        lista.setAdapter(new Adaptador(this, datos, datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent visorDetalles = new Intent(view.getContext(), DetalleUniforme.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][4]);
                startActivity(visorDetalles);
            }
        });

    }

}
