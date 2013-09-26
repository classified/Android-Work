package com.checktest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	CheckBox cb, cv;
	ImageView iv, iv1;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cb = (CheckBox) findViewById(R.id.checkBox1);
		cv = (CheckBox) findViewById(R.id.checkBox2);
		b = (Button) findViewById(R.id.button1);
		cb.setOnCheckedChangeListener(this);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				this.notify();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		final int show=1;
		if (cb.isChecked())

		{
			iv.setBackgroundDrawable(R.drawable.avatar_teamverygames3);
			iv1.setVisibility(show);
		}
		if (cv.isChecked()) {
			iv.setVisibility(0);
			iv1.setVisibility(0);
		}

	}

}
