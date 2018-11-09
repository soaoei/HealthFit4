package app.HealthFit;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import app.HealthFit.fileconfixe.DatabaseFood;
import app.HealthFit.fileconfixe.DatabaseRegister;


public class Calories_TOTAL extends Activity {
	private DatabaseRegister namedata;
	private String user_accout_id;
	private DatabaseFood foodData;
	private Typeface mTypeface;
	private Button buttoncancle,refresh;
	private EditText edittext;
	private ListView listview;
	private int number = 0;
	private int count_number = 1;
	private ArrayList<HashMap<String, String>> selectAllData_listdata;

	private int count=0;
	private String[] image;
	private String[] text ;
	private String[] text2 ;
	private int textlength = 0;


	public void onCreate(Bundle savedInstanceState)

	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.calories_total);
		foodData=new DatabaseFood(this);
		namedata=new DatabaseRegister(this);
		SeekBar seekBar = (SeekBar)findViewById(R.id.seekbar);

		seekBar.setVisibility(View.GONE);


			user_accout_id = 		Database_File6.Code_Id;


		refresh = (Button) findViewById(R.id.button1);
		refresh.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Setdataandroid();
			}
		});



		Button  checkalldata = (Button) findViewById(R.id.checkalldata);
		checkalldata.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Calories_TOTAL.this, Report.class);
				i.putExtra("id", user_accout_id);
				startActivity(i);
			}
		});




	}


	class MyCustomAdapter extends BaseAdapter
	{

		String[] data_text;
		String[] data_image;
		String[] data_text2;
		MyCustomAdapter(){}

		MyCustomAdapter(String[] text, String[] image,String[] text2)
		{

			data_text = text;
			data_image = image;
			data_text2 = text2;
		}

		MyCustomAdapter(ArrayList<String> text, ArrayList<String> image,ArrayList<String> text2)

		{

			data_text = new String[text.size()];
			data_image = new String[image.size()];
			data_text2 = new String[text2.size()];

			for(int i=0;i<text.size();i++)

			{
				data_text[i] = text.get(i);
				data_image[i] = image.get(i);
				data_text2[i] = text2.get(i);
			}

		}

		public int getCount()
		{
			return data_text.length;
		}

		public String getItem(int position)
		{
			return null;
		}

		public long getItemId(int position)
		{
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent)
		{

			int k=position; k++;
			LayoutInflater inflater = getLayoutInflater();
			View row;

			row = inflater.inflate(R.layout.listview_calories_burn_total, parent, false);
			mTypeface = Typeface.createFromAsset(getBaseContext().getAssets(),"fonts/TH_Mali_Grade6_Bold.ttf");
			TextView data1 = (TextView) row.findViewById(R.id.data_number);
			TextView data2 = (TextView) row.findViewById(R.id.listview_item_title_medium);
			TextView data3 = (TextView) row.findViewById(R.id.data_number_detail);
			TextView data4 = (TextView) row.findViewById(R.id.listview_item_title_small);

			data1.setText( Integer.toString(k));
			data2.setText(data_image[position]);
			data3.setText(data_text[position]);
			data4.setText(data_text2[position]+" กิโลแคลอรี่");

			final  int position_poit=position;

			LinearLayout delete_data = (LinearLayout) row.findViewById(R.id.delete_data);

			delete_data.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					AlertDialog.Builder builder = new AlertDialog.Builder(Calories_TOTAL.this);
					builder.setMessage("คุณต้องการลบข้อมูลนี้จริงหรือ ไม่ ? ")
							.setCancelable(false)
							.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									String check_Code="";
									for(int i=0;i<selectAllData_listdata.size();i++){
										if(selectAllData_listdata.get(i).get("col1").equals(user_accout_id)
												&&data_text[position_poit].equals(selectAllData_listdata.get(i).get("col5"))
												&&data_text2[position_poit].equals(selectAllData_listdata.get(i).get("col4"))){
											   check_Code=selectAllData_listdata.get(i).get("Code");
										}

									}

									Toast.makeText(getApplicationContext(), "ลบข้อมูลเรียบครับ", Toast.LENGTH_LONG).show();

									foodData.DeleteData(check_Code);
									Setdataandroid();
									dialog.cancel();
								}
							})
							.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									//  Action for 'NO' Button
									dialog.cancel();
								}
							});

					//Creating dialog box
					AlertDialog alert = builder.create();
					//Setting the title manually
					alert.setTitle("ลบข้อมูลนี้");
					alert.show();

				}
			});

			return (row);

		}
	}


	@Override
	public void onStart(){
		super.onStart();

		Setdataandroid();
	}

	private void Setdataandroid() {
		// TODO Auto-generated method stub
		Calendar cal_Tomorrow= Calendar.getInstance();
		SimpleDateFormat formats = new SimpleDateFormat("yyyy/MM/dd, EEEE");
		String strdate=formats.format(cal_Tomorrow.getTime());

		String[] SelectDataCodename= namedata.SelectDataCode(user_accout_id);
		selectAllData_listdata= foodData.SelectAllData();

		int num=0;
		for(int k=0;k<selectAllData_listdata.size();k++){
			if(selectAllData_listdata.get(k).get("col1").equals(user_accout_id)&&selectAllData_listdata.get(k).get("col7").equals(strdate)){
				num++;
			}
		}

		image=new String[num];
		text=new String[num];
		text2=new String[num];

		double value =0;

		String sd=" "; //valuetotal
		String date=" ";
		int countNumber1=0;
		for(int i=0;i<selectAllData_listdata.size();i++){
			if(selectAllData_listdata.get(i).get("col1").equals(user_accout_id)&&selectAllData_listdata.get(i).get("col7").equals(strdate)){

				image[countNumber1]=selectAllData_listdata.get(i).get("col2");
				text[countNumber1]=selectAllData_listdata.get(i).get("col5");
				text2[countNumber1]=selectAllData_listdata.get(i).get("col4");
				value= value+Double.parseDouble(selectAllData_listdata.get(i).get("col4"));
				//values_= Double.parseDouble(selectAllData_listdata.get(i).get("col8"));
				sd=selectAllData_listdata.get(i).get("col8");
				date=selectAllData_listdata.get(i).get("col7");
				countNumber1++;
			}

		}

		if(countNumber1>0){
			double total = Double.parseDouble(sd);

			double num_count=(value/total)*100;
			double  format_number = num_count; //%
			int decimalPlaces = 2;
			BigDecimal bd = new BigDecimal(num_count);
			// setScale is immutable
			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
			format_number = bd.doubleValue();

			TextView textdetail_data = (TextView) findViewById(R.id.textdetail_data);
			textdetail_data.setText(SelectDataCodename[3]+" กินไป : "+value+" kcal"+"\n"+format_number+" %"+" จากที่ต้องใช้ต่อวัน  :"+sd+" kcal"+"\n"+"ข้อมูลวันที่ :"+date);


		}


		edittext = (EditText) findViewById(R.id.EditText01);
		listview = (ListView) findViewById(R.id.ListView01);
		listview.setAdapter(new MyCustomAdapter(text, image,text2));
	}
}