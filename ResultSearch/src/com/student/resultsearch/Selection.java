package com.student.resultsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class Selection extends Activity  {
	
	Spinner spinner0, spinner1;
	Button submit, cancel;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_degree_sem);
		spinner0 = (Spinner)findViewById(R.id.SpinnerDegree);
        spinner1 = (Spinner)findViewById(R.id.SpinnerSemester);
        submit = (Button)findViewById(R.id.btnSubmit);
        cancel = (Button)findViewById(R.id.btnCancle);
        
      
        submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent intent=new Intent(Selection.this,SearchFunction.class);
				intent.putExtra("degree_val", spinner0.getSelectedItem().toString());
				intent.putExtra("semester_val", spinner1.getSelectedItem().toString());
				Selection.this.startActivity(intent);
				
			}
		});
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);
				
				
			}
		});
        
        
    
	}
	

}
