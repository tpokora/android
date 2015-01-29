package com.helloworld.tomek.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.helloworld.tomek.database.entity.Contact;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tomek on 2015-01-29.
 */
public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "contacts.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table contact(" +
                "id integer primary key autoincrement, " +
                "name text," +
                "number text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Contact> getAll() {
        List<Contact> contacts = new LinkedList<Contact>();
        String[] columns = {"id", "name", "number"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("contact", columns, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setId(cursor.getLong(0));
            contact.setName(cursor.getString(1));
            contact.setNumber(cursor.getString(2));
            contacts.add(contact);
        }
        return contacts;
    }

    public void addContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("number", contact.getNumber());
        db.insertOrThrow("contact", null, values);
    }

    public void deleteContact(Long id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {"" + id};
        db.delete("contact", "id=?", args);
    }

    public void editContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("number", contact.getNumber());
        String[] args = { "" + contact.getId() };
        db.update("contact", values, "id=?", args);
    }

    public Contact getContact(int id) {
        Contact contact = new Contact();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = { "id", "name", "number" };
        String[] args = { "" + id };
        Cursor cursor = db.query( "contact", columns, "id=?", args, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            contact.setId(cursor.getLong(0));
            contact.setName(cursor.getString(1));
            contact.setNumber(cursor.getString(2));
        }
        return contact;
    }
}
