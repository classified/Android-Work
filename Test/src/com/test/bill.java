package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class bill extends Activity {
	Button btn1,btn2;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		btn1=(Button)findViewById(R.id.reorder);
		btn2=(Button)findViewById(R.id.testabout);
		Intent i=getIntent();
		final String pz,bg,cf;
		final int tot;
		
		pz="Pizza - "+ getIntent().getStringExtra("pizza");
		cf="Coffee - "+ getIntent().getStringExtra("coffee");
		bg="Burger - "+ getIntent().getStringExtra("burger");
		
		tot=Integer.parseInt(pz) + Integer.parseInt(cf)+Integer.parseInt(bg);
		tv.setText(String.valueOf(tot));
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2=new Intent(bill.this,order.class);
				startActivity(i2);
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(bill.this,about.class);
				startActivity(i1);
			}
		});
	}

}
