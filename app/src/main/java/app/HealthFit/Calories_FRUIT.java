package app.HealthFit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import app.HealthFit.fileconfixe.DatabaseFood;
import app.HealthFit.fileconfixe.DatabaseRegister;


public class Calories_FRUIT extends Activity {
	private  DatabaseRegister dataname;
	private String user_accout_id;
	private DatabaseFood foodData;
	private Typeface mTypeface;
	private Button buttoncancle;
	private EditText edittext;
	private ListView listview;
	private int number = 0;
	private int count_number = 1;
	private int count=0;
	private String[] dataname_ ;

	private int[] image  = {
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,
			R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3,R.drawable.ico_cate3
	};


	private String[] text = {
			"กล้วยตาก 1/2 ผล","กล้วยน้ำว้า 1 ผล","กล้วยหอม 1 ผล","กล้วยเล็บมือนาง 2 ผล","กล้วยไข่ 1 ผล",
			"ขนุน 2 ยวง","ชมพู่ 2-3 ผล","ชมพู่เมืองเพชร 2 ผล","ทุเรียนกระดุม 100 กรัม","ทุเรียนชะนี 100 กรัม",
			"น้อยหน่า 1/2 ผล","ฝรั่ง 1/2 ผล","ฝรั่งกลม (สาลี่) 1/2 ผล","พุทรา 4 ผล","มะกอกฝรั่ง 3 ผล",
			"มะขามหวาน 2 ฝัก","มะขามเทศ 3 ฝัก","มะปรางสุก 3 ผล","มะม่วงน้ำดอกไม้สุก 4 ชิ้น","มะม่วงอกร่องสุก 4 ชิ้น",
			"มะม่วงเขียวเสวย 1/2 ผล","มะยม 15 ผล","มะละกอ 8 ชิ้นพอคำ","มะเฟือง 1/2 ผล","มะไฟ 15 ผล",
			"มังคุด 4 ผล","ระกำ 4 ผล","ลองกอง 10 ผล","ละมุด 1 1/2 ผล","ลางสาด 10 ผล",
			"ลำไย 4 ผล","ลิ้นจี่ 4 ผล","ลูกตาลอ่อน 1 1/2 ผล","ลูกพลับ 1/2 ผล","ลูกเกด 15 เม็ด",
			"สตรอวเบอร์รี่ 6 ผล","สละ (หวาน)3 ผล","สับปะรด 8 ชิ้นพอคำ","สาลี่หอม 1 ผล","ส้มเขียวหวาน 1 ผล",
			"ส้มเช้ง 1 ผล","ส้มแป้น 1 กิโลกรัม","ส้มโอ 1 กลีบ","องุ่น (หวาน) 15 ผล","องุ่น (เปรี้ยวอมหวาน) 20 ผล",
			"อ้อยควั่น 5 ชิ้น","เงาะ 4 ผล","เชอรี่ (มาราชิโน) 4 ผล","เนื้อมะพร้าวอ่อน 100 กรัม","แก้วมังกร 8 ชิ้นพอคำ",
			"แคนตาลูป 8 ชิ้นพอคำ","แตงโม 1 กิโลกรัม","แตงโม 1 ชิ้นพอดีคำ 60 กรัม","แตงไทย 8 ชิ้นพอคำ","แอปเปิ้ล 1/2 ผล"

	};

	private String[] text2 ={
			"60","60","120","60","60",
			"60","60","60","129","165",
			"60","60","60","60","60",
			"60","60","60","60","60",
			"60","30","60","60","60",
			"60","30","60","60","60",
			"60","60","60","60","60",
			"60","30","60","60","60",
			"60","340","60","60","60",
			"60","60","60","77","60",
			"30","250","15","30","60"

	};

	int textlength = 0;

	ArrayList<String> text_sort = new ArrayList<String>();
	ArrayList<Integer> image_sort = new ArrayList<Integer>();
	ArrayList<String> text_sort2 = new ArrayList<String>();
	public void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_calories_burn);
		foodData=new DatabaseFood(this);
		dataname=new DatabaseRegister(this);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			user_accout_id = extras.getString("id");

		}
		dataname_ =dataname.SelectDataCode(user_accout_id);
		TextView  nameTitle = (TextView) findViewById(R.id.textView1);
		nameTitle.setText("เลือกผลไม้ที่บริโภค");
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
	protected void showOneButton() {

		// TODO Auto-generated method stub
		AlertDialog.Builder oneButton = new AlertDialog.Builder(this);

		// Set Icon
		oneButton.setIcon(image[count]);

		// Set Title
		oneButton.setTitle("แคลอรี่ในอาหาร");

		// Set Message
		oneButton.setMessage(" แคลอรี่ในอาหาร :"+text[count]+" : "+text2[count]);

		// Set Positive Button
		oneButton.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Intent to FirstActivity

					}
				});
		oneButton.show();

	}
	public void alertFormElements() {


		final AlertDialog.Builder alertDialogs = new AlertDialog.Builder(Calories_FRUIT.this);
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

				foodData.InsertData(null, 		Database_File6.Code_Id, text[count], text2[count], Integer.toString(foo), Integer.toString(count_number), " ",strdate, dataname_[8], " ");
				//Toast.makeText(getApplicationContext(),"บันทึกข้อมูลเรียบร้อย ครับ/ค่ะ"+dataname_[8] ,Toast.LENGTH_SHORT).show();
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