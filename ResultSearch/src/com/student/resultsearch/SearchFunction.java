package com.student.resultsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SearchFunction extends Activity {

	EditText SearchText;
	Button btnSearch,btnBack,btnExit;
	String deg,sem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_function);
		Intent intent = getIntent();
		deg=intent.getStringExtra("degree_val");
		sem=intent.getStringExtra("semester_val");
		SearchText=(EditText)findViewById(R.id.SearchBox);
		btnSearch=(Button)findViewById(R.id.btnSearch);
		btnBack=(Button)findViewById(R.id.btnBack);
		btnExit=(Button)findViewById(R.id.btnExit);
		btnSearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(deg.equals("MCA"))
				{
					String eno=SearchText.getText().toString();
					if(eno.equals("115220693166"))
					{
						Intent exInt=new Intent(SearchFunction.this,Result.class);
						SearchFunction.this.startActivity(exInt);
					}
				}
			}
		});
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent exInt1=new Intent(SearchFunction.this,Selection.class);
				SearchFunction.this.startActivity(exInt1);
			}
		});
		btnExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);
			}
		});
		
	}

}
