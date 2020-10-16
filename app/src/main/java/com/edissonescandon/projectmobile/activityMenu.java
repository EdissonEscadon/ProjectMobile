package com.edissonescandon.projectmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class activityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CardView cardPedido = (CardView)findViewById(R.id.cardUniforme);

        cardPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Product.class);
                startActivity(intent);
            }
        });

        CardView cardLidia = (CardView)findViewById(R.id.carNosotros);

        cardLidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),logo.class);
                startActivity(intent);
            }
        });

        CardView cardPrueba = (CardView)findViewById(R.id.Nosotros);
        cardPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),logo.class);
                startActivity(intent);
            }
        });

        CardView carProducto = (CardView)findViewById(R.id.cardchat);
        carProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),nuevoProducto.class);
                startActivity(intent);
            }
        });





    }
}
