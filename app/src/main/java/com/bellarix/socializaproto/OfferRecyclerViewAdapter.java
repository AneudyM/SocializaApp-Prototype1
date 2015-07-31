package com.bellarix.socializaproto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by flakoloko32 on 7/26/2015.
 */
public class OfferRecyclerViewAdapter
        extends RecyclerView.Adapter<OfferRecyclerViewAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // This is used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain member variable
        // for any view that will be set as you render a row
        public TextView offerTitle;
        public TextView offerLikesNumber;
        public Button offerPrice;

        public ViewHolder(View offerView) {
            super(offerView);
            this.offerTitle = (TextView)offerView.findViewById(R.id.offer_title);
            this.offerLikesNumber = (TextView)offerView.findViewById(R.id.offer_likesNumber);
            this.offerPrice = (Button)offerView.findViewById(R.id.offer_price);
        }

    }

    // ... view holder defined above...
    // store a member variable for the offers
    private ArrayList<Offer> offers;
    // storing the context for later use
    private Context context;

    // Now, pass in the context and users array into the constructor
    public OfferRecyclerViewAdapter(Context context, ArrayList<Offer> offers){
        this.offers = offers;
        this.context = context;
    }


    // Now, define the default constructor so that the IDE stops being vexing
    // This usually involves inflating a layout from XML and returning the holder
    @Override
    public OfferRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Inflate the custom layout
        View offerView = LayoutInflater.from(context)
                .inflate(R.layout.stream_item, parent, false);
        // Return a new holder instance
        return new OfferRecyclerViewAdapter.ViewHolder(offerView);
    }

    // Now, this populates data into the offer item through the holder
    @Override
    public void onBindViewHolder(OfferRecyclerViewAdapter.ViewHolder holder, int position){
        // Get the data model based on position
        Offer offer = offers.get(position);
        // Set item views based on the data model
        holder.offerTitle.setText(offer.title);
        holder.offerLikesNumber.setText(offer.likesNumber);

        // commented because of the error being thrown since setText was not
        // found for button
        holder.offerPrice.setText(offer.price);
    }

    // Return the total count of offers/items
    @Override
    public int getItemCount(){
        return offers.size();
    }
}