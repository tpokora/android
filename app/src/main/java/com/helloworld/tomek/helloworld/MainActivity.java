package com.helloworld.tomek.helloworld;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button.setText("I am button!");
        textView.setTextColor(Color.GREEN);
        textView.setText("I am green text!");

        /**
         * first version of adding listener too a button
         *
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Whiskey!", Toast.LENGTH_SHORT).show();
            }
        };
        button.setOnClickListener(listener);
        **/

        /**
         *
         * second version of adding listener to a button
         *
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Burbon!", Toast.LENGTH_SHORT).show();
            }
        });
         */
    }

    /** third version of adding button listener
     *
     * Complete with activity_main.xml
     *
     * @param v
     */

    public void clickHandle(View v) {
        Toast.makeText(getApplicationContext(), "Black Tooth Grin!", Toast.LENGTH_SHORT).show();
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
}
