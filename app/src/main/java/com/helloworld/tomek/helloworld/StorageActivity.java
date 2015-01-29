package com.helloworld.tomek.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.helloworld.tomek.database.Database;
import com.helloworld.tomek.database.entity.Contact;

import java.util.ArrayList;


public class StorageActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayList<Contact> list;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        listView = (ListView) findViewById(R.id.listView);
        populateList();
        adapter = new ListViewAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private void populateList() {
        Database db = new Database(this);
        list = new ArrayList<Contact>();
        for (Contact c : db.getAll()) {
            list.add(c);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_storage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.d("Clicked", "x=" + id);
        if (id == R.id.home) {
            Log.d("click!", "Home");
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.about) {
            Log.d("click!", "About");
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        }
        return true;
    }
}
