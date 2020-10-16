package com.edissonescandon.projectmobile;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Product extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaproducto);

        final ProductoBd productoBd= new ProductoBd(getApplicationContext());

        final Cursor cursorProducto = productoBd.listarProducto();

        String[] desde =new String[]{"nombre","precio","modelo","descripcion"};
        int[] hasta =new int[]{R.id.txtNombre,R.id.txtPrecio,R.id.txtModelo,R.id.txtDescripcion};

        final CursorAdapter productoAdapter= new SimpleCursorAdapter(getApplicationContext(),
                R.layout.activity_productoscargados,cursorProducto,desde,hasta,0);

        final ListView listView=(ListView)findViewById(R.id.mostraProductos);
        listView.setAdapter(productoAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor proveedorItem=(Cursor)listView.getItemAtPosition(position);

                String rucProveedor= proveedorItem.getString(1);

                Intent intent = new Intent(getApplicationContext(),NuevoDetalleCompra.class);
                startActivity(intent);

            }
        });

        Button buttonVerCarrito = (Button)findViewById(R.id.btnVerCarrito);

        buttonVerCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PrincipalDetalleProducto.class);
                startActivity(intent);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor proveedorItem=(Cursor)listView.getItemAtPosition(position);

                String rucProveedor= proveedorItem.getString(1);
                String mensaje = productoBd.eliminarProducto(rucProveedor);

                if (mensaje == null){
                    Toast.makeText(getApplicationContext(),"Proveedor Eliminado",Toast.LENGTH_LONG).show();
                    productoAdapter.swapCursor(productoBd.listarProducto());
                    listView.setAdapter(productoAdapter);
                }else {
                    Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(),"Eliminar"+rucProveedor,Toast.LENGTH_LONG).show();


                return false;
            }
        });

    }
}
