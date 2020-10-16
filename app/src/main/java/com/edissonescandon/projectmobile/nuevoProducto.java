package com.edissonescandon.projectmobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class nuevoProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        final ProductoBd productoBd= new ProductoBd(getApplicationContext());

        Button buttonGrabar = (Button)findViewById(R.id.btnCargar);

        buttonGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //texVie precio
                //text catidad
                //iint prec1
                //Strin prec2


                EditText editTextCodigo = (EditText)findViewById(R.id.plnCodigo);
                EditText editTextNombre = (EditText)findViewById(R.id.plnNombre);
                EditText editTextPrecio = (EditText)findViewById(R.id.plnPrecio);
                EditText editTextModelo = (EditText)findViewById(R.id.plnModelo);
                EditText editTextDescripcion = (EditText)findViewById(R.id.plnDescripcion);
                EditText editTextCodigoCompra = (EditText)findViewById(R.id.plnCompra);
                ///Falta la compra q no se ok

                Producto producto = new Producto(editTextCodigo.getText().toString(),
                        editTextNombre.getText().toString(),
                        editTextPrecio.getText().toString(),
                        editTextModelo.getText().toString(),
                        editTextDescripcion.getText().toString(),
                        editTextCodigoCompra.getText().toString());
                String mensaje =  productoBd.ingresoProducto(producto);

                if (mensaje == null){
                    Toast.makeText(getApplicationContext(),"PRODUCTO CREADO",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                }

            }
        });

    }



}
