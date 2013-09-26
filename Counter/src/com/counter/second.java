package com.counter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class second extends Activity {

	ListView ls;

	ArrayAdapter<String> adpt;
	String[] arr;
	String time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		ls = (ListView) findViewById(R.id.listView1);
		// time = getIntent().getStringExtra("text");
		Intent mIntent = getIntent();
		int number = Integer.parseInt(mIntent.getStringExtra("text"));
		arr = new String[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = number + " * " + (i + 1) + " = " + (number * (i + 1));

		}

		adpt = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arr);
		ls.setAdapter(adpt);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
