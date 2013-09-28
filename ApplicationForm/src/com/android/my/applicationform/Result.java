package com.android.my.applicationform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity {

	String nm11, en11, sem11, java11, php11, cnet11, net11, aspnet11,
			android11, sex;
	TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		Intent secIntent = getIntent();

		nm11 = secIntent.getStringExtra("name");
		en11 = secIntent.getStringExtra("eno");
		sem11 = secIntent.getStringExtra("semester");
		sex = secIntent.getStringExtra("sex");

		java11 = secIntent.getStringExtra("java");
		php11 = secIntent.getStringExtra("php");
		cnet11 = secIntent.getStringExtra("cnet");
		net11 = secIntent.getStringExtra("net");
		aspnet11 = secIntent.getStringExtra("aspnet");
		android11 = secIntent.getStringExtra("android");
		tv = (TextView) findViewById(R.id.name1);
		tv1 = (TextView) findViewById(R.id.eno1);
		tv2 = (TextView) findViewById(R.id.sem1);
		tv3 = (TextView) findViewById(R.id.male1);
		tv4 = (TextView) findViewById(R.id.java1);
		tv5 = (TextView) findViewById(R.id.php1);
		tv6 = (TextView) findViewById(R.id.cnet1);
		tv7 = (TextView) findViewById(R.id.net1);
		tv8 = (TextView) findViewById(R.id.aspnet1);
		tv9 = (TextView) findViewById(R.id.android1);
		tv10 = (TextView) findViewById(R.id.female1);

		if (nm11.equals(null)) {
			tv.setText("");
		} else {
			tv.setText("Name is :" + nm11);
		}
		if (en11.equals(null)) {
			tv1.setText("");
		} else {
			tv1.setText("Enrollment no is :" + en11);
		}

		if (sem11.equals(null)) {
			tv2.setText("");
		} else {
			tv2.setText("Semester is :" + sem11);
		}

		if (sex.equals(null)) {
			tv3.setText("");
		} else {
			tv3.setText("Gender is :" + sex);
		}

		if (java11.equals(null)) {
			tv4.setText("");
		} else {
			tv10.setText("Selected Languages are :");
			tv4.setText(java11);
		}

		if (php11.equals(null)) {
			tv5.setText("");
		} else {
			tv5.setText(php11);
		}
		if (cnet11.equals(null)) {
			tv6.setText("");
		} else {
			tv6.setText(cnet11);
		}
		if (net11.equals(null)) {
			tv7.setText("");
		} else {
			tv7.setText(net11);
		}

		if (aspnet11.equals(null)) {
			tv8.setText("");
		} else {
			tv8.setText(aspnet11);
		}

		if (android11.equals(null)) {
			tv9.setText("");
		} else {
			tv9.setText(android11);
		}

	}

}
