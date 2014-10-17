package com.example.matthewdarke.advancedviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    private Spinner giftSpinner;
    private ArrayList<Gifts> giftsArrayList;
    private ListView giftsListView;
     TextView gSpinnerDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//Custom Class
        giftsArrayList = new ArrayList<Gifts>();
        giftsArrayList.add(new Gifts("Wisdom", "1 Corinthians 12-14, Acts 2:38,Psalm 11:10", 1));
        giftsArrayList.add(new Gifts("Knowledge", "1 Corinthians 12-14, Acts 2:38,Porverbs 18:15", 2));
        giftsArrayList.add(new Gifts("Faith", "Romans 10:17, Hebrews 11:6, Matthew 21;22", 3));
        giftsArrayList.add(new Gifts("Healing", "1 Peter 2:24, Psalm 103:3, Matthew 10:1", 4));
        giftsArrayList.add(new Gifts("Miracles", "John 4:48, Acts 19:11, Acts 3:6", 5));
        giftsArrayList.add(new Gifts("Prophecy", "1 Corinthians 14:1-40, 1 John 4:1, Matthew 7:21-23", 6));
        giftsArrayList.add(new Gifts("Discernment", "Hebrews 4:12, Matthew 10:16,", 7));
        giftsArrayList.add(new Gifts("Tongues", "1 Corinthians 14:2, Mark 16:17, Jude 1:20", 8));
        giftsArrayList.add(new Gifts("Interpretation of Tongues", "Acts 2:1-47, 1 Corinthians 14:13, 1 Corinthians 14:27", 9));


        giftSpinner = (Spinner)findViewById(R.id.spinner);
        giftSpinner.setAdapter(new GiftsAdapter(this, giftsArrayList));

        ArrayAdapter<Gifts> arrayAdapter = new ArrayAdapter<Gifts>(this,
                android.R.layout.simple_spinner_dropdown_item, giftsArrayList);
        giftSpinner.setAdapter(arrayAdapter);



        giftsListView = (ListView)findViewById(R.id.listView);
        giftsListView.setAdapter(new GiftsAdapter(this, giftsArrayList));

        arrayAdapter = new ArrayAdapter<Gifts>(this,
                android.R.layout.simple_list_item_1, giftsArrayList);
        giftsListView.setAdapter(arrayAdapter);




setSimpleAdapter();


    }




    private void setSimpleAdapter() {

// Field identifiers
        final String name = "Name";
        final String Reference = "Reference";
        final String order = "order";

        // List of elements for our adapter.
        final ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();

        // Goes through each Gift and maps the data elements to a String key.
        for (Gifts gifts : giftsArrayList) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(name, gifts.getName());
            map.put(Reference, gifts.getDescription());
            map.put(order, getString(R.string.order_num, gifts.getOrderNumb()));
            items.add(map);
        }

        // Creating an array of our keys
        String[] keys = new String[]{
                name, Reference, order
        };

        // Creating an array of our list item components.
        // Indices must match the keys array.
        int[] views = new int[]{
                R.id.gift_name,
                R.id.gift_descript,
                R.id.gift_number
        };

        // Creating a new SimpleAdapter that maps values to views using our keys and views arrays.
         SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.gift_main, keys, views);


        //set adapters to list view and spinner

        giftsListView.setAdapter(new GiftsAdapter(this, giftsArrayList));


        giftsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                //entry.remove(userString);

                final String item1 = items.get(position).get("name");
                final String item2 = items.get(position).get("Reference");
                final String item3 = items.get(position).get("order");

                String GiftString = new String(item1 + "  " + item2 + "" + item3);

                Toast.makeText(getApplicationContext(), GiftString, Toast.LENGTH_LONG).show();

                gSpinnerDetails.setText(GiftString);
            }


        });

        giftSpinner.setAdapter(new GiftsAdapter(this, giftsArrayList));
        giftSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                //entry.remove(userString);

                final String item1 = items.get(position).get("name");
                final String item2 = items.get(position).get("Reference");
                final String item3 = items.get(position).get("order");

                String GiftString2 = new String(item1 + "  " + item2 + "" + item3);

                Toast.makeText(getApplicationContext(), GiftString2, Toast.LENGTH_LONG).show();
            }

            //@Override
            public void onNothingselected(AdapterView<?> parent) {


            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
