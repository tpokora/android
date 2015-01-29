package com.helloworld.tomek.helloworld;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.helloworld.tomek.database.Database;
import com.helloworld.tomek.database.entity.Contact;

import java.util.ArrayList;

/**
 * Created by Tomek on 2015-01-29.
 */
public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Contact> list;
    private Activity activity;
    private ListViewAdapter adapter;

    public ListViewAdapter(Activity activity, ArrayList<Contact> list) {
        super();
        this.activity = activity;
        this.list = list;
        this.adapter = this;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.firstText);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.secondText);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Contact contact = list.get(position);
        holder.txtFirst.setText(contact.getName());
        holder.txtSecond.setText(contact.getNumber());

        holder.txtFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(),
                        "DELETING: " + contact.getName() + ", #" + contact.getId(),
                        Toast.LENGTH_SHORT).show();
                Database db = new Database(parent.getContext());
                db.deleteContact(contact.getId());
                list = new ArrayList<Contact>();
                for (Contact c : db.getAll()) {
                    list.add(c);
                }
                adapter.notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
