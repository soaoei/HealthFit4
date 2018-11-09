package app.HealthFit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import app.HealthFit.fileconfixe.DatabaseExsersie;
import app.HealthFit.fileconfixe.DatabaseRegister;


public class Burn_Activity extends Activity {
	private DatabaseRegister dataname;
	private String user_accout_id;
	private DatabaseExsersie Exsersie;
	private Typeface mTypeface;
	private Button buttoncancle;
	private EditText edittext;
	private ListView listview;
	private int number = 0;
	private int count_number = 1;
	private int count=0;
	private String[] dataname_ ;

	private int[] image  = {
			R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,
			R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,
			R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2,R.drawable.ico_burn2

	};

	//เพิ่มข้อมูลและแคลอรี่
	private String[] text = {
			"กวาดพื้น","ซักผ้าด้วยมือ","ตัดหญ้า","ทำงานบ้าน","ทำสวน",
			"นอนหลับ","นั่งดูทีวี","นั่งทำงานใช้สมอง","ปูที่นอน","ยืน",
			"รีดผ้า","ลงนอน (ไม่หลับ)","เดินเล่น","เย็บผ้า","เลื่อยไม้"

	};


	private String[] text2 ={
			"225","240","300","250","450",
			"75","100","110","135","140",
			"150"," 85","210","115","515"


	};

	int textlength = 0;

	ArrayList<String> text_sort = new ArrayList<String>();
	ArrayList<Integer> image_sort = new ArrayList<Integer>();
	ArrayList<String> text_sort2 = new ArrayList<String>();
	public void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_calories_burn);

		Exsersie=new DatabaseExsersie(this);
		dataname=new DatabaseRegister(this);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			user_accout_id = extras.getString("id");

		}
		dataname_ =dataname.SelectDataCode(user_accout_id);
		TextView  nameTitle = (TextView) findViewById(R.id.textView1);
		nameTitle.setText("เลือกกิจกรรม");

		edittext = (EditText) findViewById(R.id.EditText01);
		listview = (ListView) findViewById(R.id.ListView01);
		listview.setAdapter(new MyCustomAdapter(text, image,text2));

		edittext.addTextChangedListener(new TextWatcher()
		{

			public void afterTextChanged(Editable s)
			{

			}

			public void beforeTextChanged(CharSequence s, int start,
										  int count, int after)
			{

			}

			public void onTextChanged(CharSequence s, int start, int before, int count)
			{

				textlength = edittext.getText().length();
				text_sort.clear();
				image_sort.clear();
				text_sort2.clear();

				for (int i = 0; i < text.length; i++)
				{
					if (textlength <= text[i].length())
					{
						if (edittext.getText().toString().equalsIgnoreCase((String) text[i].subSequence(0, textlength))){

							text_sort.add(text[i]);
							image_sort.add(image[i]);
							text_sort2.add(text2[i]);
							number = 1;
						}
					}
				}

				listview.setAdapter(new MyCustomAdapter(text_sort, image_sort,text_sort2));

			}
		});
		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

				if (number == 1) {
					for(int g=0;g<text.length;g++){
						if(text[g].equals(text_sort.get(position))){
							count=g;
							alertFormElements();
						}
					}

				} else {
					for(int g=0;g<text.length;g++){
						if(text[g].equals(text[position])){
							count=g;
							alertFormElements();
						}
					}

				}

			}
		});
	}

	class MyCustomAdapter extends BaseAdapter
	{

		String[] data_text;
		int[] data_image;
		String[] data_text2;
		MyCustomAdapter(){}

		MyCustomAdapter(String[] text, int[] image,String[] text2)
		{

			data_text = text;
			data_image = image;
			data_text2 = text2;
		}

		MyCustomAdapter(ArrayList<String> text, ArrayList<Integer> image,ArrayList<String> text2)
		{

			data_text = new String[text.size()];
			data_image = new int[image.size()];
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

			LayoutInflater inflater = getLayoutInflater();
			View row;

			row = inflater.inflate(R.layout.listview_calories1_burn1, parent, false);
			mTypeface = Typeface.createFromAsset(getBaseContext().getAssets(),"fonts/TH_Mali_Grade6_Bold.ttf");
			TextView textview = (TextView) row.findViewById(R.id.listview_item_title_medium);
			ImageView imageview = (ImageView) row.findViewById(R.id.listview_item_image);
			TextView textview2 = (TextView) row.findViewById(R.id.listview_item_title_small);


			textview.setText(data_text[position]);
			imageview.setImageResource(data_image[position]);
			textview2.setText(data_text2[position]+" กิโลแคลอรี่");

			return (row);

		}
	}

	public void alertFormElements() {


		AlertDialog.Builder alertDialogs = new AlertDialog.Builder(Burn_Activity.this);
		LayoutInflater inflatersss = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View convertView = (View) inflatersss.inflate(R.layout.witzand2_searchlistview, null);
		ImageView imageView = (ImageView) convertView.findViewById(R.id.list_images);
		TextView type_name = (TextView) convertView.findViewById(R.id.textViewName);
		TextView textViewName = (TextView) convertView.findViewById(R.id.textViewLastName);

		imageView.setBackgroundResource(image[count]);
		type_name.setText(text[count]);
		textViewName.setText(text2[count]+" กิโลแคลอรี่");
		final TextView textViewnumber = (TextView) convertView.findViewById(R.id.textViewnumber);
		ImageButton bntButton1 = (ImageButton) convertView.findViewById(R.id.imageButton1);
		ImageButton bntButton2 = (ImageButton) convertView.findViewById(R.id.ImageButton01s);

		bntButton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count_number<100){
					count_number++;
					textViewnumber.setText(Integer.toString(count_number));
				}

			}
		});
		bntButton2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count_number>1){
					count_number--;
					textViewnumber.setText(Integer.toString(count_number));
				}
			}
		});
		alertDialogs.setView(convertView);


		Button button_Submit = (Button) convertView.findViewById(R.id.Submit);
		Button button_Cancle = (Button) convertView.findViewById(R.id.Cancle);

		button_Submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Calendar  cal_Tomorrow= Calendar.getInstance();
				SimpleDateFormat formats = new SimpleDateFormat("yyyy/MM/dd, EEEE");
				String strdate=formats.format(cal_Tomorrow.getTime());

				int foo = Integer.parseInt(text2[count])*count_number;
				String data55555=Integer.toString(foo) ;
				Exsersie.InsertData(null, user_accout_id, text[count], text2[count], data55555, Integer.toString(count_number), " ",strdate, dataname_[8], " ");


//	     			Toast.makeText(getApplicationContext(),"บันทึกข้อมูลเรียบร้อย ครับ/ค่ะ"+dataname_[8] ,Toast.LENGTH_SHORT).show();
				convertView.getRootView().setVisibility(View.GONE);

			}
		});

		button_Cancle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				convertView.getRootView().setVisibility(View.GONE);
			}

		});
		alertDialogs.show();

	}
}