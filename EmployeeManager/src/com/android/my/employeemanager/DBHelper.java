package com.android.my.employeemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	static final String DATABASE = "employee.db";
	static final int VERSION = 1;
	static final String TABLE = "emp";
	static final String C_ID = "_id";
	static final String C_NAME = "ename";
	static final String C_DESIGNATION = "designation";
	static final String C_SALARY = "salary";

	public DBHelper(Context context) {
		super(context, DATABASE, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE + " ( " + C_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + C_NAME + " text, "
				+ C_DESIGNATION + " TEXT, " + C_SALARY + " text) ");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("Drop table " + TABLE);
		onCreate(db);
	}

}
