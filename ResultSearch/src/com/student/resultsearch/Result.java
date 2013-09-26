package com.student.resultsearch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Result extends Activity {

	ListView ls;
	String arr[] = getResources().getStringArray(R.array.rajan);
	ArrayAdapter<String> adpt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		ls=(ListView)findViewById(R.id.listView1);
		adpt=new ArrayAdapter<String>(Result.this,android.R.layout.simple_list_item_1,arr);
		ls.setAdapter(adpt);
	}
}
