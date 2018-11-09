package app.HealthFit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Health_Detail3 extends Activity {

	private Button btnBack;
	private TextView txtDisplay, txtDetial1, txtDetial2;
	private ImageView imvDisplay;
	private String strRecipeTitle;
	int id;
	String Detail1, Detail2;

	SQLiteDatabase mDb;
	Health_Tips_DB HealthDB;
	Cursor mCur,mCur2;

	//MyDbHelper myDb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tips_detail3);

		checkDatabase();
		HealthDB = new Health_Tips_DB(this);
		mDb = HealthDB.getWritableDatabase();

		//myDb = new MyDbHelper(this);
		//mDb = myDb.getWritableDatabase();

		btnBack = (Button)findViewById(R.id.btnBack);
		txtDisplay = (TextView)findViewById(R.id.txtDisplay3);
		txtDetial1 = (TextView)findViewById(R.id.txtdetail1);
		txtDetial2 = (TextView)findViewById(R.id.txtdetail2);
		imvDisplay = (ImageView)findViewById(R.id.imvDisplay3);

		strRecipeTitle = getIntent().getStringExtra("strTitleChoose");
		id = getIntent().getIntExtra("Position",0);
		int id2 =id+1;


		//mCur = mDb.rawQuery("SELECT " + MyDbHelper.COL_Name + " FROM " + MyDbHelper.TABLE_NAME1 + " WHERE id IN ('"+id2+"')" , null);
		mCur = mDb.rawQuery("SELECT " + Health_Tips_DB.COL_Detail1 + " FROM " + Health_Tips_DB.TABLE_NAME3 + " WHERE ID IN ('"+id2+"')" , null);
		mCur2 = mDb.rawQuery("SELECT " + Health_Tips_DB.COL_Detail2 + " FROM " + Health_Tips_DB.TABLE_NAME3 + " WHERE ID IN ('"+id2+"')" , null);
		mCur.moveToFirst();
		mCur2.moveToFirst();

		//เอาข้อมูลที่selectแล้วเก็บในcursorเก็บลงในarraylist

		Detail1 = mCur.getString(mCur.getColumnIndex(Health_Tips_DB.COL_Detail1));
		Detail2 = mCur2.getString(mCur2.getColumnIndex(Health_Tips_DB.COL_Detail2));
		Log.i("Detail1", Detail1);
		//Log.i("Detail2", Detail2);
		int number = mCur.getCount();
		int number2 = mCur2.getCount();
		Log.i("number", String.valueOf(number));
		Log.i("number2", String.valueOf(number));
		chooseTitle();

		btnBack.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}//onCreate


	private void chooseTitle() {
		// TODO Auto-generated method stub
		if (id==0) {
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_1);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==1)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_2);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==2)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_3);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==3)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_4);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==4)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_5);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==5)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_6);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==6)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_7);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==7)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_8);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==8)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_9);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}


		else if (id==9)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_10);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==10)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_11);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==11)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_12);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==12)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_13);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==13)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_14);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==14)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_15);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==15)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_16);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}


		else if (id==16)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_17);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==17)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_18);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==18)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_19);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==19)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_20);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}

		else if (id==20)
		{
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_21);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}


		//else {
		//	if (strRecipeEbook.equals("Android eBook #4")) {
		//		txtDisplay.setText(strRecipeEbook);
		//		imvDisplay.setImageResource(R.drawable.ebook4);
		//	}
		//	else {
		//		if (strRecipeEbook.equals("Android eBook #5")) {
		//			txtDisplay.setText(strRecipeEbook);
		//			imvDisplay.setImageResource(R.drawable.ebook5);
		//		}
		else {
			txtDisplay.setText(strRecipeTitle);
			imvDisplay.setImageResource(R.drawable.c_deta_22);
			txtDetial1.setText(Detail1);
			txtDetial2.setText(Detail2);
		}
	}

	public void checkDatabase() {
		String url = "/data/data/" + getPackageName() + "/databases/HealthTips";
		File f = new File(url);
		if(!f.exists()) {
			try {
				//myDb = new MyDbHelper(this);
				//mDb =myDb.getWritableDatabase();
				HealthDB = new Health_Tips_DB(this);
				mDb = HealthDB.getWritableDatabase();
				mDb.close();
				HealthDB.close();
				InputStream in = getAssets().open("HealthTips");
				OutputStream out = new FileOutputStream(url);
				byte[] buffer = new byte[in.available()];
				in.read(buffer);
				out.write(buffer, 0, buffer.length);
				in.close();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onPause() {
		super.onPause();
		HealthDB.close();
		mDb.close();
	}

}
