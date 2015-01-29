package com.helloworld.tomek.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.helloworld.tomek.database.Database;
import com.helloworld.tomek.database.entity.Contact;

import java.util.ArrayList;


public class StorageActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayList<Contact> list;
    private ListViewAdapter adapter;
    private EditText newContactNameEditText;
    private EditText newContactNumberEditText;
    private Button addNewContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        newContactNameEditText = (EditText) findViewById(R.id.newContactNameEditText);
        newContactNumberEditText = (EditText) findViewById(R.id.newContactNumberEditText);
        addNewContactButton = (Button) findViewById(R.id.addContactButton);

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

    public void addNewContactButtonClick(View v) {
        String newContactName = newContactNameEditText.getText().toString();
        String newContactNumber = newContactNumberEditText.getText().toString();
        if (!newContactName.equals("") && !newContactNumber.equals("")) {
            Database db = new Database(this);
            Contact contact = new Contact();
            contact.setName(newContactName);
            contact.setNumber(newContactNumber);
            db.addContact(contact);
            populateList();
            adapter = new ListViewAdapter(this, list);
            listView.setAdapter(adapter);
            clearNewContactEditText();
        } else {
            Toast.makeText(getApplicationContext(), "Complete contact details!", Toast.LENGTH_LONG).show();
        }
    }

    private void clearNewContactEditText() {
        newContactNameEditText.setText("");
        newContactNumberEditText.setText("");
    }
}
