package com.edissonescandon.projectmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int[] datosImg;

    public Adaptador(Context conexto, String[][] datos, int[] imagenes)
    {
        this.contexto = conexto;
        this.datos = datos;
        this.datosImg = imagenes;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView titulo = (TextView) vista.findViewById(R.id.txtTitulo);
        TextView descripcion = (TextView) vista.findViewById(R.id.txtDescripcion);
        TextView descripcion2 = (TextView) vista.findViewById(R.id.txtDescripcion2);
        TextView existente = (TextView) vista.findViewById(R.id.txtExisten);


        ImageView imagen = (ImageView) vista.findViewById(R.id.ivImagen);


        titulo.setText(datos[i][0]);
        descripcion.setText(datos[i][1]);
        descripcion2.setText(datos[i][2]);
        existente.setText("n°" + datos[i][3]);
        imagen.setImageResource(datosImg[i]);



        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}

