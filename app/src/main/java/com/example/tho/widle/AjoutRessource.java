package com.example.tho.widle;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;

public class AjoutRessource extends AppCompatActivity {

    TextView texttype;
    TextView textnom;
    Button valider;
    Button annuler;
    Spinner menu;
    EditText editNom;
    EditText editType;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_ressource);
        this.setTitle("Ajout d'une Ressource");

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        editType = (EditText) findViewById(R.id.editText2);
        editNom = (EditText) findViewById(R.id.editText);
        annuler = (Button) findViewById(R.id.button3);
        valider = (Button) findViewById(R.id.button2);
        menu = (Spinner) findViewById(R.id.spinner2);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    editType.setVisibility(View.VISIBLE);
                    menu.setVisibility(View.INVISIBLE);
                }else{
                    editType.setVisibility(View.INVISIBLE);
                    menu.setVisibility(View.VISIBLE);
                }
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                String[] a = res.getStringArray(R.array.dates_reservation);
                for (int i = 0; i < a.length; i++){
                    System.out.println(a[i].toString());
                }
                LinkedList<String> l = new LinkedList<String>();
                for (int i = 0; i < a.length; i++){
                    l.add(a[i]);
                }
                l.add("Vendredi 9 Mai");
                System.out.println(l);
            }
        });

    }
}
