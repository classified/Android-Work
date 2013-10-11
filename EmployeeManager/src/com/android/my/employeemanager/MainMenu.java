/**
 * 
 */
package com.android.my.employeemanager;





import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * @author Rajan
 * 
 */
public class MainMenu extends Activity implements OnClickListener {
	EditText txtName, txtDesig, txtSalary;
	Button btnAdd;
	SimpleCursorAdapter adapter;
	DBHelper helper;
	SQLiteDatabase db;
	ListView disp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emp_show);
		helper = new DBHelper(this);
		txtName = (EditText) findViewById(R.id.empName);
		txtDesig = (EditText) findViewById(R.id.empDesig);
		txtSalary = (EditText) findViewById(R.id.empSalary);
		btnAdd = (Button) findViewById(R.id.btnAddEMP);
		disp = (ListView) findViewById(R.id.dispID);
		fetchdata();
		btnAdd.setOnClickListener(this);

	
	}
	
	@SuppressWarnings("deprecation")
	private void fetchdata() {
		// TODO Auto-generated method stub
		db = helper.getReadableDatabase();
		Cursor c = db.query(DBHelper.TABLE, null, null, null, null, null, null);
		adapter = new SimpleCursorAdapter(MainMenu.this, R.layout.rows, c,
				new String[] { DBHelper.C_NAME, DBHelper.C_SALARY,
						DBHelper.C_DESIGNATION }, new int[] { R.id.lblName,
						R.id.lblSalary, R.id.lblDesig });
		disp.setAdapter(adapter);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btnAdd) {
			ContentValues value = new ContentValues();
			value.put(DBHelper.C_NAME, txtName.getText().toString());
			value.put(DBHelper.C_DESIGNATION, txtDesig.getText().toString());
			value.put(DBHelper.C_SALARY, txtSalary.getText().toString());
			db = helper.getWritableDatabase();
			db.insert(DBHelper.TABLE, null, value);
			db.close();
			clearField();
			Toast.makeText(MainMenu.this, "RECORD UPDATED SUCCESSFULLY",
					Toast.LENGTH_LONG).show();

			fetchdata();
			

		}
	}
	private void clearField() {
		// TODO Auto-generated method stub
		txtName.setText("");
		txtDesig.setText("");
		txtSalary.setText("");
	}

	

}
