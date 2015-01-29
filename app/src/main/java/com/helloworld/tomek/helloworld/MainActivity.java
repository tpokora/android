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
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText edit;
    private Button button;
    private TextView textView;
    private Button nextActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Message!", "Create!");
        Toast.makeText(getApplicationContext(), "Welcome to my app!", Toast.LENGTH_SHORT).show();
        edit = (EditText) findViewById(R.id.edit);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textview);
        nextActivityButton = (Button) findViewById(R.id.nextActivityButton);
    }

    @Override
    public void onStop() {
        Log.d("Message!", "Stop!");
        super.onStop();
    }

    @Override
    public void onPause() {
        Log.d("Message!", "Pause!");
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.d("Message!", "Resume!");
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.d("Clicked", "x=" + id);
        if (id == R.id.opt1) {
            Log.d("click!", "Option 1");
        } else if (id == R.id.opt2) {
            Log.d("click!", "Option 2");
        } else if (id == R.id.opt3) {
            Log.d("click!", "Option 3");
        }
        return true;
    }

    public void buttonClick(View v) {
        if (!edit.getText().toString().equals("")) {
            textView.setText("Hello, " + edit.getText().toString());
        } else {
            Toast.makeText(getApplicationContext(), "Please type your name!", Toast.LENGTH_LONG).show();
        }
    }

    public void nextActivityButtonClick(View v) {
        if (!edit.getText().toString().equals("")) {
            Intent i = new Intent(this, NewIntention.class);
            i.putExtra("name", edit.getText().toString());
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Please type your name!", Toast.LENGTH_LONG).show();
        }

    }
}
