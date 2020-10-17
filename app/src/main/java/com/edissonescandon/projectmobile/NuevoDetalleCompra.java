package com.edissonescandon.projectmobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NuevoDetalleCompra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);

        final TextView texNombre =(TextView)findViewById(R.id.txtNombre);
        final EditText editTextCantidad = (EditText)findViewById(R.id.editTextCantidad);
        final TextView texTalla =(TextView)findViewById(R.id.textTalla);
        final TextView texPrecio =(TextView)findViewById(R.id.textViewPrecio);
        final TextView textFecha = (TextView)findViewById(R.id.editTextFecha);
        final TextView titulo = (TextView)findViewById(R.id.lista);
        final TextView textitoNombre = (TextView)findViewById(R.id.textitoNombrecito);
        final DetalleCompraBd detalleCompraBd= new DetalleCompraBd(getApplicationContext());


        //Boton
        Bundle lista = getIntent().getExtras();
        Button buttonAgregar = (Button)findViewById(R.id.btnAgregar);
        /*if(lista==null){*/
            titulo.setText("nuevo cliente");
            buttonAgregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //float num1 = new Float(texPrecio.getText().toString());
                    //int num2 = new Integer(editTextCantidad.toString());
                    //float res = (num1*num2);
                    // String precioTotal= String.valueOf(res);


                    DetalleProducto detalleProducto= new  DetalleProducto(textitoNombre.getText().toString(),
                            editTextCantidad.getText().toString(),
                            texPrecio.getText().toString(),
                            textFecha.getText().toString(),
                            texTalla.getText().toString());
                    String mensaje = detalleCompraBd.ingresoDetalleCompra(detalleProducto);
                    if (mensaje == null){
                        Toast.makeText(getApplicationContext(),"Agregado al Carrito",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                    }
                }
            });
      /*  }else {*/
            //buttonAgregar.setText("Ver");
            //titulo.setText("Ver producto");
            String codi = lista.getString("nombre");
            String nom = lista.getString("precio");
            textitoNombre.setText(codi);
            texNombre.setEnabled(false);
            texPrecio.setText(nom);
            texPrecio.setEnabled(false);

      //  }





    }



}
