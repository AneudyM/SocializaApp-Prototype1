package com.bellarix.socializaproto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

/**
 * Created by flakoloko32 on 8/1/2015.
 */
public class OfferDetailsActivity extends AppCompatActivity {
        private Toolbar toolbar;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.details_page_layout);
            setToolbar();

        }

        private void setToolbar(){
            Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
            setActionBar(toolbar);
            toolbar.setLogo(R.mipmap.ic_title);
            setTitle("Details Page");
        }
}
