package com.android.my.employeemanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NewUser extends SQLiteOpenHelper {

	static final String DATABASE = "users.db";
	static final int VERSION = 1;
	static final String TABLE = "users";
	static final String C_ID = "_id";
	static String C_USER = "username";
	static String C_PASS = "password";

	public NewUser(Context context) {

		super(context, DATABASE, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	private Intent getIntent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL("CREATE TABLE " + TABLE + " ( " + C_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + C_USER + " text, "
				+ C_PASS + " TEXT) ");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("Drop table " + TABLE);
		onCreate(db);
	}

}
