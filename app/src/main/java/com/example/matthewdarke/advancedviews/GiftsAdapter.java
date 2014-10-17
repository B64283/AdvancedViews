package com.example.matthewdarke.advancedviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by matthewdarke on 10/16/14.
 */
public class GiftsAdapter extends BaseAdapter {

    private static final long ID_CONSTANT = 0x010101010L;

    private Context mContext;
    private ArrayList<Gifts> giftsArrayList;

    // We take in a context and list of Gift objects.
    // The list is our backing collection and the context is used
    // to create new views in our getView() method.
    public GiftsAdapter(Context _context, ArrayList<Gifts> _gifts) {
        mContext = _context;
        giftsArrayList = _gifts;
    }

    // Returning the number of objects in our collection.
    @Override
    public int getCount() {
        return giftsArrayList.size();
    }

    // Returning Employee objects from our collection.
    @Override
    public Gifts getItem(int _position) {
        return giftsArrayList.get(_position);
    }

    // Adding our constant and position to create unique ID values.
    @Override
    public long getItemId(int _position) {
        return ID_CONSTANT + _position;
    }

//create new views in our getView() method.
    @Override
    public View getView(int _position, View _convertView, ViewGroup _parent) {

        // If we don't have a recycled view, create a new view.
        if(_convertView == null) {
            // Creating the new view.
            _convertView = LayoutInflater.from(mContext).inflate(R.layout.gift_main, _parent, false);
        }

        // Get the object from the collection in an index-safe manner.
        Gifts gifts = getItem(_position);

        // Use the object from the collection to fill out our view.
        TextView tv = (TextView)_convertView.findViewById(R.id.gift_name);
        tv.setText(gifts.getName());

        tv = (TextView)_convertView.findViewById(R.id.gift_descript);
        tv.setText(gifts.getDescription());

        tv = (TextView)_convertView.findViewById(R.id.gift_descript);
        tv.setText(mContext.getString(R.string.order_num, gifts.getOrderNumb()));

        // Returning our filled out view.
        return _convertView;
    }

}



