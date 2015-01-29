package com.helloworld.tomek.helloworld;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.helloworld.tomek.database.entity.Contact;

import java.util.ArrayList;

/**
 * Created by Tomek on 2015-01-29.
 */
public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Contact> list;
    private Activity activity;

    public ListViewAdapter(Activity activity, ArrayList<Contact> list) {
        super();
        this.activity = activity;
        this.list = list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
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

        Contact contact = list.get(position);
        holder.txtFirst.setText(contact.getName());
        holder.txtSecond.setText(contact.getNumber());

        return convertView;
    }
}
