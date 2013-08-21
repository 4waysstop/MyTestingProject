package org.fourwaysstop.mytestingproject;

import android.os.Bundle;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

// Array of options --> ArrayAdapter --> ListView

//List view:(views: da_items.xml)

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        registerClickCallback();
    }

    private void populateListView(){
        //Create list of items
        String[] myItems = {"Blue", "Green", "Purple", "Red"};

        //Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.da_items, myItems);

        //Configure the list view
         ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);

    }

    private void registerClickCallback(){
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id){
                TextView textView = (TextView) viewClicked;
                String message = "You clicked # " + position + ", which is string: " + textView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }
    
}
