package com.android.my.applicationform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Form extends Activity {

	EditText nm, en;
	Button sub;
	Spinner sem;
	CheckBox cbJava, cbPhp, cbCNet, cbNet, cbAspNet, cbAndroid;
	RadioGroup rg;
	RadioButton rbSex;
	String nm1, en1;
	String smale, sfemale;
	String sjava, sphp, scnet, snet, saspnet, sandroid;
	String sspiner;
	Intent intent;
	int selectedId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);

		nm = (EditText) findViewById(R.id.name);
		en = (EditText) findViewById(R.id.eno);
		sub = (Button) findViewById(R.id.submit);
		sem = (Spinner) findViewById(R.id.spinner1);
		cbJava = (CheckBox) findViewById(R.id.java);
		cbPhp = (CheckBox) findViewById(R.id.php);
		cbCNet = (CheckBox) findViewById(R.id.c_net);
		cbNet = (CheckBox) findViewById(R.id.net);
		cbAspNet = (CheckBox) findViewById(R.id.asp_net);
		cbAndroid = (CheckBox) findViewById(R.id.android);
		rg = (RadioGroup) findViewById(R.id.radioGroup1);
		selectedId = rg.getCheckedRadioButtonId();
		rbSex = (RadioButton) findViewById(selectedId);

		btnClickEvent();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form, menu);
		return true;
	}

	public void btnClickEvent() {
		// TODO Auto-generated method stub

		int selectedId = rg.getCheckedRadioButtonId();
		rbSex = (RadioButton) findViewById(selectedId);
		if (cbAndroid.isChecked()) {
			sandroid = cbAndroid.getText().toString();
		}
		if (cbAspNet.isChecked()) {
			saspnet = cbAspNet.getText().toString();
		}
		if (cbNet.isChecked()) {
			snet = cbNet.getText().toString();
		}
		if (cbPhp.isChecked()) {
			sphp = cbPhp.getText().toString();
		}
		if (cbJava.isChecked()) {
			sjava = cbJava.getText().toString();
		}
		if (cbCNet.isChecked()) {
			scnet = cbCNet.getText().toString();
		}

		sub.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				intent = new Intent(Form.this, Result.class);
				intent.putExtra("name", nm.getText().toString());
				intent.putExtra("eno", en.getText().toString());
				intent.putExtra("semester", sem.getSelectedItem().toString());
				intent.putExtra("sex", rbSex.getText().toString());
				intent.putExtra("java", cbJava.getText().toString());
				intent.putExtra("php", cbPhp.getText().toString());
				intent.putExtra("cnet", cbCNet.getText().toString());
				intent.putExtra("net", cbNet.getText().toString());
				intent.putExtra("aspnet", cbAspNet.getText().toString());
				intent.putExtra("android", cbAndroid.getText().toString());

				startActivity(intent);

			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			Intent refresh = new Intent(this, Form.class);
			startActivity(refresh);
			this.finish();
			return true;
		case R.id.item2:
			finish();
			System.exit(0);
			return true;

		}

		return super.onOptionsItemSelected(item);
	}

}
