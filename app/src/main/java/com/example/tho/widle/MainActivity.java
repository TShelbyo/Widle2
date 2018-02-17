package com.example.tho.widle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ListView mDrawerList;
    private ListView listeBase;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ArrayAdapter<String> mAdapter2;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private TextView t1;
    private String[] ArrayA = {"Salle 2127", "Salle 2237", "Salle 2235"};
    String[] Array2 ={"Disponible","Non disponible","Bientot indiponible"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.mydrawer);
        mActivityTitle = getTitle().toString();
        mDrawerList = (ListView) findViewById(R.id.myList);
        final Spinner sp=(Spinner) findViewById(R.id.spinner);
        final Button b=(Button) findViewById(R.id.button1);

        listeBase =(ListView) findViewById(R.id.myList2);
        CustomListView customListView=new CustomListView();

        //mAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ArrayA);
        listeBase.setAdapter(customListView);

        //addItems2();
         ArrayAdapter<String> monAdapteur= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.spinner));
         monAdapteur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(monAdapteur);


        listeBase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MainRessource.class);
                startActivity(intent);
            }
        });
       // addItems();

        setupDrawer();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void addItems() {
        String[] Array = { "Ajouter ressource", "Réserver", "Mes réservations"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Array);
        mDrawerList.setAdapter(mAdapter);
    }

    /*private void addItems2() {
        String[] Array = { "Salle 2127", "Salle 2237", "Salle 2235"};
        String[] Array2 ={"Disponible","Non disponible","Bientot indiponible"};
        //mAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Array);
        listeBase.setAdapter(customListView);
        //listeBase.getChildAt(1).setBackgroundColor(Color.parseColor("#FF4081"));
    }*/


    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {


            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Categorie");
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class CustomListView extends BaseAdapter {

        @Override
        public int getCount() {
            return ArrayA.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //setContentView(R.layout.list);
            View view=getLayoutInflater().inflate(R.layout.list,null);
            t1=(TextView) view.findViewById(R.id.textLibelleSalle);
            t1.setText(ArrayA[position]);
            if(position == 0)
            {
                // Set a background color for ListView regular row/item
                view.setBackgroundColor(Color.parseColor("#00FF00"));
                t1.setTextColor(Color.parseColor("#FFFFFF"));
            }
            else if(position ==1)
            {
                // Set the background color for alternate row/item
                view.setBackgroundColor(Color.parseColor("#FF0921"));
                t1.setTextColor(Color.parseColor("#FFFFFF"));
            }

            else {
                view.setBackgroundColor(Color.parseColor("#ED7F10"));
                t1.setTextColor(Color.parseColor("#FFFFFF"));
            }

            return view;
        }
    }
}
