package com.bellarix.socializaproto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        RecyclerView rvOffers = (RecyclerView)findViewById(R.id.streamer);
        OfferRecyclerViewAdapter adapter = new OfferRecyclerViewAdapter(this, getSomeCoolOffers());
        rvOffers.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOffers.setLayoutManager(layoutManager);
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_title);
    }


    // Here I will be populating a series of sample offers
    // which should be displayed in the RecyclerView (hopefully)
    private ArrayList<Offer> getSomeCoolOffers() {
        ArrayList<Offer> items = new ArrayList<>();
        items.add(new Offer("Skydiving with the Boys", "Aneudy + 2.3k", "2350"));
        items.add(new Offer("Playtime in Punta Cana", "Mami + 5.2k", "1800"));
        items.add(new Offer("Coco-Bongo Night", "Vianny + 8.3k", "2650"));
        items.add(new Offer("Señor Frogs Miami", "Aneudy + 1.5k", "850"));

        items.add(new Offer("Skydiving with the Boys", "Aneudy + 2.3k", "2350"));
        items.add(new Offer("Playtime in Punta Cana", "Cheka + 5.2k", "1800"));
        items.add(new Offer("Coco-Bongo Night", "Vianny + 8.3k", "2650"));
        items.add(new Offer("Señor Frogs Miami", "Aneudy + 1.5k", "850"));

        items.add(new Offer("Skydiving with the Boys", "Aneudy + 2.3k", "2350"));
        items.add(new Offer("Playtime in Punta Cana", "Cheka + 5.2k", "1800"));
        items.add(new Offer("Coco-Bongo Night", "Vianny + 8.3k", "2650"));
        items.add(new Offer("Señor Frogs Miami", "Aneudy + 1.5k", "850"));
        return items;
    }

    //-----Main Stream Card buttons functions
    public void onClickOpenDetailsPage(View view){
        Intent intent = new Intent(this, OfferDetailsActivity.class);
        this.startActivity(intent);
    }

    public void onClickShare(View view){
        String shareBody = "http://nixstock.com/";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this offer!");
        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(intent, "Send via"));
    }
    // -------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
