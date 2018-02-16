package com.example.tho.widle;

/**
 * Created by Théo on 12/02/2018.
 */ import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainRessource extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {



    Spinner spinneCr;
    Button reserver;
    TextView text;
    ScrollView lundi;
    ScrollView mardi;
    ScrollView mercredi;
    ScrollView jeudi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ressource);

        Intent i = getIntent();
        spinneCr = (Spinner) findViewById(R.id.spinner);
        reserver = (Button) findViewById(R.id.reserver);
        text = (TextView) findViewById(R.id.textView);
        lundi = (ScrollView) findViewById(R.id.lundi);
        mardi = (ScrollView) findViewById(R.id.mardi);
        mercredi = (ScrollView) findViewById(R.id.mercredi);
        jeudi = (ScrollView) findViewById(R.id.jeudi);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dates_reservation, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinneCr.setAdapter(adapter);
        spinneCr.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String s = parent.getItemAtPosition(pos).toString();
        text.setText(s);
        if(parent.getItemAtPosition(pos) == parent.getItemAtPosition(1)){
            lundi.setVisibility(View.INVISIBLE);
            mardi.setVisibility(View.VISIBLE);
            mercredi.setVisibility(View.INVISIBLE);
            jeudi.setVisibility(View.INVISIBLE);
        }else if(parent.getItemAtPosition(pos) == parent.getItemAtPosition(2)){
            lundi.setVisibility(View.INVISIBLE);
            mardi.setVisibility(View.INVISIBLE);
            mercredi.setVisibility(View.VISIBLE);
            jeudi.setVisibility(View.INVISIBLE);
        }else if(parent.getItemAtPosition(pos) == parent.getItemAtPosition(3)){
            lundi.setVisibility(View.INVISIBLE);
            mardi.setVisibility(View.INVISIBLE);
            mercredi.setVisibility(View.INVISIBLE);
            jeudi.setVisibility(View.VISIBLE);
        }else if(parent.getItemAtPosition(pos) == parent.getItemAtPosition(0)){
            lundi.setVisibility(View.VISIBLE);
            mardi.setVisibility(View.INVISIBLE);
            mercredi.setVisibility(View.INVISIBLE);
            jeudi.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

