package com.edissonescandon.projectmobile;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalDetalleProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carrito);

       final DetalleCompraBd detalleCompraBd =  new DetalleCompraBd(getApplicationContext());

       final Cursor cursorCarrito = detalleCompraBd.listarDetalleCompra();

       String[] desde = new String[]{"nombre","descripcion","cantidad","total_pagar"};
       int[] hasta = new int[]{R.id.txtNombre,R.id.txtDescripcion,R.id.txtCantidad,R.id.txtPrecio};

        final CursorAdapter carritoAdapter= new SimpleCursorAdapter(getApplicationContext(),
                R.layout.activity_lista_carrito,cursorCarrito,desde,hasta,0);

        final ListView listView=(ListView)findViewById(R.id.mostrarCarrito);
        listView.setAdapter(carritoAdapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Cursor carritoItem = (Cursor)listView.getItemAtPosition(position);


                String nombreCarrito = carritoItem.getString(1);
                String mensaje = detalleCompraBd.eliminarDetalleCompra(nombreCarrito);
                if (mensaje == null){
                    Toast.makeText(getApplicationContext(),"Proveedor Eliminado",Toast.LENGTH_LONG).show();
                    carritoAdapter.swapCursor(detalleCompraBd.listarDetalleCompra());
                    listView.setAdapter(carritoAdapter);

                }else {
                    Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();

                }
                    return false;
            }

        });

    }


}
