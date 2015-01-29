package com.helloworld.tomek.helloworld;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AboutActivity extends ActionBarActivity {
    private EditText contactEditText;
    private Button contactMsgSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        contactEditText = (EditText) findViewById(R.id.contactEditText);
        contactMsgSendButton = (Button) findViewById(R.id.contactButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.d("Clicked", "x=" + id);
        if (id == R.id.opt1) {
            Log.d("click!", "Home");
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.opt2) {
            Log.d("click!", "About");
        }
        return true;
    }

    public void contactButtonClick(View v) {
        String emailText = contactEditText.getText().toString();
        if(!emailText.equals("")) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[] {"pokora.tomek@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Contact message");
            i.putExtra(Intent.EXTRA_TEXT, emailText);
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(AboutActivity.this, "There is no email clients installed.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
