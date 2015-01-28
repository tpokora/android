package com.helloworld.tomek.helloworld;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Message!", "Create!");
        Toast.makeText(getApplicationContext(), "Welcome to my app!", Toast.LENGTH_SHORT).show();
        edit = (EditText) findViewById(R.id.edit);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textview);
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
        textView.setText("Hello, " + edit.getText().toString());
    }
}
