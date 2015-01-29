package com.helloworld.tomek.helloworld;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;


public class MultithreadActivity extends ActionBarActivity {

    private Button asyncButton;
    private ProgressBar asyncProgressBar;

    private class SeparateThread extends AsyncTask<Void, Void, Void> {



        @Override
        protected void onPreExecute() {
            Log.d("Thread", "Thread running");
            asyncProgressBar.setVisibility(Spinner.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.d("Hanging...", "Sorry...");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            asyncProgressBar.setVisibility(Spinner.INVISIBLE);
            Log.d("Bye", "Goodbye");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multithread);

        asyncButton = (Button) findViewById(R.id.asyncButton);
        asyncProgressBar = (ProgressBar) findViewById(R.id.asyncProgressBar);
        asyncProgressBar.setVisibility(Spinner.INVISIBLE);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SeparateThread().execute();
            }
        };

        asyncButton.setOnClickListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multithread, menu);
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
