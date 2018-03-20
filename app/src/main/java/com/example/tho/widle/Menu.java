package com.example.tho.widle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button ajouter;
    Button reserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ajouter = (Button) findViewById(R.id.button);
        reserver = (Button) findViewById(R.id.button4);


        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, AjoutRessource.class);
                startActivity(i);
            }
        });

        reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, MainRessource.class);
                startActivity(i);
            }
        });
    }
}
