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

        final DetalleCompraBd detalleCompraBd= new DetalleCompraBd(getApplicationContext());

        Button buttonAgregar = (Button)findViewById(R.id.btnAgregar);

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView texNombre =(TextView)findViewById(R.id.txtNombre);
                EditText editTextCantidad = (EditText)findViewById(R.id.editTextCantidad);
                TextView texDescripcion =(TextView)findViewById(R.id.textViewDescripcion);
                TextView texPrecio =(TextView)findViewById(R.id.textViewPrecio);
                TextView textFecha = (TextView)findViewById(R.id.editTextFecha);

                //float num1 = new Float(texPrecio.getText().toString());
                //int num2 = new Integer(editTextCantidad.toString());
                //float res = (num1*num2);
               // String precioTotal= String.valueOf(res);


                DetalleProducto detalleProducto= new  DetalleProducto(texNombre.getText().toString(),
                        editTextCantidad.getText().toString(),
                        editTextCantidad.getText().toString(),
                        textFecha.getText().toString(),
                        texDescripcion.getText().toString());
                String mensaje = detalleCompraBd.ingresoDetalleCompra(detalleProducto);
                if (mensaje == null){
                    Toast.makeText(getApplicationContext(),"Agregado al Carrito",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                }
            }
        });


    }



}
