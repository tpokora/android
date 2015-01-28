package com.helloworld.tomek.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private TextView mainTextView;
    private Button mainButton;
    private EditText editText;
    private ListView mainListView;
    private ArrayAdapter myArrayAdapter;
    private ArrayList myNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Set in Java!");

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.edittext);

        mainListView = (ListView) findViewById(R.id.list);

        myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myNameList);

        mainListView.setAdapter(myArrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (!editText.getText().toString().equals("")) {
            mainTextView.setText(editText.getText().toString() + " is learning Android!");
            myNameList.add(editText.getText().toString());
            myArrayAdapter.notifyDataSetChanged();
            editText.setText("");
        } else {
            mainTextView.setText("Name not typed!");
        }

    }
}
