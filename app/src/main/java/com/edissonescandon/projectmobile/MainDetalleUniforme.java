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
            {"Tecnico Salesiano", "Uniforme de Gala","Uniforme d Deportes","Habilitado", "Tecnico: contamos con uniformes deportivos y de gala, para niños y niñas, de distintas tallas, tambien puede comprar su uniforme por piezas."},
            {"Escuela Ricaurte", "Uniforme de Gala","Uniforme d Deportes","Medio", "Ricaurte: contamos con uniformes deportivos y de gala, para niños y niñas, de distintas tallas, tambien puede comprar su uniforme por piezas."},
            {"Julio Matovelle","Uniforme Deportivo","Uniforme d Deportes","Bajo", "Matovelle: contamos con uniformes deportivos y de gala, para niños y niñas, de distintas tallas, tambien puede comprar su uniforme por piezas."},
            {"Sagrado Corazon Todos Santos","Uniforme Deportivo","Uniforme d Deportes","Existente", "Sagrado Corazon: contamos con uniformes deportivos y de gala, para niños y niñas, de distintas tallas, tambien puede comprar su uniforme por piezas."},
            {"Francisca Davila","Uniforme de Gala","Uniforme Deportivo","Vacio", "Francisca: contamos con uniformes deportivos y de gala, para niños y niñas, de distintas tallas, tambien puede comprar su uniforme por piezas."},
    };
    int[] datosImg = {R.drawable.indice2, R.drawable.indice1, R.drawable.indice5, R.drawable.indice3, R.drawable.indice4};
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
