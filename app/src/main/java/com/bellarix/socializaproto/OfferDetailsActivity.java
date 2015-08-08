package com.bellarix.socializaproto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by flakoloko32 on 8/1/2015.
 */
public class OfferDetailsActivity extends AppCompatActivity {
        //private Toolbar toolbar;
        ExpandableListAdapter listAdapter;
        ExpandableListView expListView;
        List<String> listDataHeader;
        HashMap<String, List<String>> listDataChild;
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.details_page_layout);
            setToolbar();
            // get the listview
            expListView = (ExpandableListView) findViewById(R.id.lvExp);

            // preparing list data
            prepareListData();

            listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

            // setting list adapter
            expListView.setAdapter(listAdapter);
        }

        private void setToolbar(){
            Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
            setActionBar(toolbar);
            toolbar.setLogo(R.mipmap.ic_title);
            setTitle("Details Page");
        }

    /*
 * Preparing the list data
 */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Top 250");

        // Adding child data
        List<String> food = new ArrayList<String>();
        food.add("The Shawshank Redemption");
        food.add("The Godfather");
        food.add("The Godfather: Part II");
        food.add("Pulp Fiction");
        food.add("The Good, the Bad and the Ugly");
        food.add("The Dark Knight");
        food.add("The Shawshank Redemption");
        food.add("The Godfather");
        food.add("The Godfather: Part II");
        food.add("Pulp Fiction");
        food.add("The Good, the Bad and the Ugly");
        food.add("The Dark Knight");
        food.add("12 Angry Men");
        food.add("The Shawshank Redemption");
        food.add("The Godfather");
        food.add("The Godfather: Part II");
        food.add("Pulp Fiction");
        food.add("The Good, the Bad and the Ugly");
        food.add("The Dark Knight");
        food.add("12 Angry Men");

        listDataChild.put(listDataHeader.get(0), food); // Header, Child data

    }

    // -------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Toast.makeText(this, "Hey you just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
