package app.HealthFit;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import app.HealthFit.fileconfixe.DatabaseRegister;

//import com.examplepharungthai.DATA.*;

public class Login extends Activity {

	private EditText user, password;
	private Button buttonEnter ;
	private String struser, strpassword;

	private DatabaseRegister data;
	private ArrayList<HashMap<String, String>> SelectAllData;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		data=new DatabaseRegister(this);
		SelectAllData =data.SelectAllData();
		initWidget();

		buttonEnter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				struser = user.getText().toString();
				strpassword = password.getText().toString();

				if (struser == null || struser.equals("")|| strpassword == null || strpassword.equals("")) {
					showErrorAlert();
				}
				else {
					setUpSearch();
				}
			}
		});


	}

	protected void setUpSearch() {
		boolean check=false;
		int g=0;
		for(int i=0;i<SelectAllData.size();i++){

			if(SelectAllData.get(i).get("col1").equals(struser)&&SelectAllData.get(i).get("col2").equals(strpassword)){
				g=i;
				check=true;
			}
		}

		if(check){

			Constants.idData=SelectAllData.get(g).get("Code");
			Database_File6.Code_Id=SelectAllData.get(g).get("Code");
			Intent regis = new Intent(getApplicationContext(), TabHostMENU.class);
			startActivity(regis);

		}else{
			AlertNoDATA();
		}
	}

	protected void showErrorAlert() {
		// TODO Auto-generated method stub
		Log.d("showErrorAlert", "Error");

		AlertDialog.Builder alertError = new AlertDialog.Builder(this);
		alertError.setIcon(R.drawable.window_close);
		alertError.setTitle(" USER AND PASSWORD");
		alertError.setMessage(" USER OR PASSWORD ");
		alertError.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
		alertError.show();
	}

	private void AlertNoDATA() {
		// TODO Auto-generated method stub
		AlertDialog.Builder noDATA = new AlertDialog.Builder(this);
		noDATA.setIcon(R.drawable.window_close);
		noDATA.setTitle(" USER OR PASSWORD ");
		noDATA.setMessage(" USER OR PASSWORD NO");
		noDATA.setPositiveButton("repast",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent goDetailEbookActivity = new Intent(
								getApplicationContext(), Register.class);
						startActivity(goDetailEbookActivity);
					}
				});

		noDATA.setNegativeButton("cancel",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

						dialog.dismiss();
					}
				});

		noDATA.show();

	}
	private void initWidget() {
		// TODO Auto-generated method stub
		user = (EditText) findViewById(R.id.User);
		password = (EditText) findViewById(R.id.Passpord);
		buttonEnter = (Button) findViewById(R.id.buttonEnter);


	}
	@Override
	public void onBackPressed() {
		AlertDialog.Builder twoButton = new AlertDialog.Builder(this);
		twoButton.setTitle("Exit");
		twoButton.setIcon(R.drawable.window_close);
		twoButton.setCancelable(true);
		twoButton.setMessage("Do you want to exit?");
		twoButton.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.addCategory(Intent.CATEGORY_HOME);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
						overridePendingTransition(R.anim.right_to_center, R.anim.center_to_right);
					}
				});
		twoButton.setNegativeButton("NO",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
		twoButton.show();
	}
}
