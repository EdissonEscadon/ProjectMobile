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

public class ProductoBd extends SQLiteOpenHelper {
    private static final String DATABASE = "uniformes.db";
    Context miContext;

    public ProductoBd(@Nullable Context context) {
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

    /*public Cursor listaClientes(){
        Cursor cursor;
        String sql="select ROWID as _id, * from producto";
        cursor=this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }*/


    //listar Producto
    public Cursor listarProducto(){
        Cursor cursor;
        String sql = "select ROWID as _id, * from producto";
        cursor=this.getReadableDatabase().rawQuery(sql,null);
        return cursor;
    };



    //ingreso de producto

    public String ingresoProducto(Producto producto){
        String sql="INSERT INTO producto (nombre,precio,modelo,descripcion,id_compra)";
        sql+="VALUES('"+producto.getNombre()+" ','"+producto.getPrecio()+"','"+producto.getModelo()+"','"+producto.getDescripcion()+"','"+producto.getId_compra()+"')";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "error"+ ex.getMessage();
        }
        return null;
    }

    public String eliminarProducto(String idCodProducto){
        String sql ="DELETE FROM producto WHERE id_producto IN (' "+idCodProducto+"');";

        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "error en la eliminacion"+ ex.getMessage();
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
