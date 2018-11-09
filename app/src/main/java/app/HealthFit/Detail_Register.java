package app.HealthFit;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import app.HealthFit.fileconfixe.DatabaseRegister;


public class Detail_Register extends Activity {
	private DatabaseRegister nameDatabase;


	private String str = " ";
	private String strdate = " ";
	private TextView height, weight, age, user, pass, name, sex, activity, bmr;
	String[] dataRegister;



	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		nameDatabase = new DatabaseRegister(this);
		setContentView(R.layout.detail_register);
		final Calendar cal_Tomorrow = Calendar.getInstance();
		final SimpleDateFormat formats = new SimpleDateFormat("yyyy/MM/dd, EEEE");
		strdate = formats.format(cal_Tomorrow.getTime());


		dataRegister = nameDatabase.SelectDataCode(Constants.idData);
		//dataRegister

		user = (TextView) findViewById(R.id.user);
		pass = (TextView) findViewById(R.id.pass);
		name = (TextView) findViewById(R.id.name);

		height = (TextView) findViewById(R.id.editetext1);
		weight = (TextView) findViewById(R.id.editetext2);
		age = (TextView) findViewById(R.id.editetext3);
		sex = (TextView) findViewById(R.id.test123);
		activity = (TextView) findViewById(R.id.test1234);
		bmr = (TextView) findViewById(R.id.bmr);

		user.setText(dataRegister[1]);
		pass.setText(dataRegister[2]);
		name.setText(dataRegister[3]);
		height.setText(dataRegister[4]);
		weight.setText(dataRegister[5]);
		age.setText(dataRegister[6]);
		sex.setText(dataRegister[7]);
		bmr.setText(dataRegister[8]);
		activity.setText(dataRegister[9]);


		Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setText("แก้ไขข้อมูล");
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent regis = new Intent(getApplicationContext(), Update_Register.class);
				startActivity(regis);
			}

		});

		Button btnCancel = (Button) findViewById(R.id.btnCancel);
		btnCancel.setText("กลับ");
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Detail_Register.this.finish();
			}

		});

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.

	}

	@Override
	public void onStart() {
		super.onStart();



	}

	@Override
	public void onStop() {
		super.onStop();


	}
}