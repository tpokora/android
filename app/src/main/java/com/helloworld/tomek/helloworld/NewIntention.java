package com.helloworld.tomek.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class NewIntention extends ActionBarActivity {

    private TextView textView;
    private Button onetButton;
    private EditText urlEditText;
    private Button goToUrlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_intention);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hello, " + name);
        onetButton = (Button) findViewById(R.id.onetButton);
        urlEditText = (EditText) findViewById(R.id.urlEditText);
        goToUrlButton = (Button) findViewById(R.id.urlButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_intention, menu);
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

    public void onetButtonClick(View v ) {
        Uri uri = Uri.parse("http://onet.pl");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }

    public void goToUrlButtonClick(View v) {
        if (!urlEditText.getText().toString().equals("")) {
            String urlString = "http://" + urlEditText.getText().toString();
            Uri uri = Uri.parse(urlString);
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        }
    }

}
