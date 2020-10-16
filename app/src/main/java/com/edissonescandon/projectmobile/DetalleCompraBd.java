package com.edissonescandon.projectmobile;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DetalleCompraBd extends SQLiteOpenHelper {

    private static final String DATABASE = "uniformes.db";
    Context miContext;

    public DetalleCompraBd(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        miContext = context;

        File miArchivo=miContext.getDatabasePath(DATABASE);

        if (!verificaBD(miArchivo.getAbsolutePath())){
            try {
                copiarDB(miArchivo);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private boolean verificaBD(String ruta) {
        SQLiteDatabase miBase = null;
        try {
            miBase = SQLiteDatabase.openDatabase(ruta, null, SQLiteDatabase.OPEN_READONLY);
        }catch (Exception e){
            e.printStackTrace();
        }


        if (miBase != null) {
            miBase.close();
        }
        return miBase != null;
    }

    private void copiarDB(File archivoBD) throws IOException {
        InputStream inputStream = miContext.getAssets().open(DATABASE);
        OutputStream outputStream = new FileOutputStream(archivoBD);
        byte[] buffer = new byte[1024];
        int largo;
        while ((largo = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, largo);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();

    }




    //listar Detalle
    public Cursor listarDetalleCompra(){
        Cursor cursor;
        String sql = "select ROWID as _id, * from detalle_compra";
        cursor=this.getReadableDatabase().rawQuery(sql,null);
        return cursor;
    };



    //ingreso de Detalle

    public String ingresoDetalleCompra(DetalleProducto detalleProducto){
        String sql="INSERT INTO detalle_compra (nombre,cantidad,total_pagar,fecha_compra,descripcion)";
        sql+="VALUES('"+detalleProducto.getNombre()+" ','"+detalleProducto.getCantidad()+"','"+detalleProducto.getTotal_pagar()+"','"+detalleProducto.getFecha_compra()+"','"+detalleProducto.getDescripcion()+"')";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "error"+ ex.getMessage();
        }
        return null;
    }

    /*public String eliminarProducto(String idCliente){
        String sql ="DELETE FROM cliente WHERE cedula IN (' "+idCliente+"');";

        try{
        this.getWritableDatabase().execSQL(sql);
    }catch (SQLException ex){
        return "error en la eliminacion"+ ex.getMessage();
    }
        return null;
}*/

    public String eliminarDetalleCompra(String nombreCarrito){
        String sql = "DELETE FROM detalle_compra WHERE nombre IN ('"+nombreCarrito+"');";
        try {
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "Error en la ELIMINACION DEL PROVEEDOR"+ex.getMessage();
        }
        return null;
    }






    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
