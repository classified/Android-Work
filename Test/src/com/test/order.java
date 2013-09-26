package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class order extends Activity {
	EditText ed1, ed2, ed3;
	Button btn1, btn2, btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);

		btn1 = (Button) findViewById(R.id.bill);
		btn2 = (Button) findViewById(R.id.menu);
		btn3 = (Button) findViewById(R.id.aboutbill);
		ed1 = (EditText) findViewById(R.id.editText1);
		ed2 = (EditText) findViewById(R.id.editText2);
		ed3 = (EditText) findViewById(R.id.editText3);

		final String pizza;
		final String coffee, burger;
		pizza = ed1.getText().toString();
		coffee = ed2.getText().toString();
		burger = ed3.getText().toString();

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(order.this, bill.class);
				i.putExtra("pizza", pizza);
				i.putExtra("coffee", coffee);
				i.putExtra("burger", burger);
				startActivity(i);
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1 = new Intent(order.this, Test.class);
				
				startActivity(i1);
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2 = new Intent(order.this,about.class);
				startActivity(i2);
			}
		});
	}
}
