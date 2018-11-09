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


public class Calories_DRINK extends Activity {
	private DatabaseRegister dataname;
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
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,R.drawable.ico_cate4,
			R.drawable.ico_cate4
	};


	private String[] text = {
			"กาแฟร้อน 1 แก้ว","กาแฟเย็น 1 แก้ว","ชาดำเย็น 1 แก้ว","ชามะนาว 1 แก้ว","ชาร้อน 1 แก้ว",
			"ชาเขียว (รสหวาน) 1 แก้ว","ชาเย็น 1 แก้ว","ช็อคโกแลตร้อน 1 แก้ว","ช็อคโกแลตเย็น 1 แก้ว","นมจืด (250 cc) 1 กล่อง",
			"นมจืด (ไขมันต่ำ) 1 กล่อง","นมจืด (ไม่มีไขมัน) 1 กล่อง","นมถั่วเหลือง (หวานน้อย) 1 กล่อง","นมปรุงแต่ง (รสหวาน) 1 กล่อง","นมเปรี้ยว UHT รสผลไม้ (200 cc) 1 กล่อง",
			"นมเย็น 1 แก้ว","น้ำกระเจี๊ยบ 1 แก้ว","น้ำขิง (ขิงผงรสหวาน) 1 กล่อง","น้ำจับเลี้ยง 1 แก้ว","น้ำชาเขียว (250 ml) 1 กล่อง",
			"น้ำชาเขียวผสมน้ำผึ้ง (250 ml) 1 กล่อง","น้ำนมข้าวโพด 1 แก้ว","น้ำผลไม้รวม 1 กล่อง","น้ำผักรวม 1 กล่อง","น้ำฝรั่ง 100%(200 ml) 1 กล่อง",
			"น้ำมะตูม 1 แก้ว","น้ำมะนาว 1 แก้ว","น้ำมะพร้าว 1 แก้ว","น้ำมะพร้าวผสมเนื้อ 1 กล่อง","น้ำมะเขือเทศ 1 แก้ว",
			"น้ำมะเขือเทศ100%(200 ml) 1 กล่อง","น้ำลำใย 1 แก้ว","น้ำสับปะรด 1 แก้ว","น้ำสัปปะรด 100%(200 ml) 1 กล่อง","น้ำส้ม 100%(200 ml) 1 กล่อง",
			"น้ำส้มคั้น 1 แก้ว","น้ำองุ่น 1 แก้ว","น้ำองุ่นแดง 100%(200 ml) 1 กล่อง","น้ำอัดลม (หวาน) 1 แก้ว","น้ำอัดลมประเภทโคล่า(325 cc) 1 กระป๋อง",
			"น้ำอ้อย 1/2 แก้ว","น้ำเต้าหู้(จืด) 1 แก้ว","น้ำแอปเปิ้ลแดง 100%(200 ml) 1 กล่อง","น้ำใบบัวบก 1 แก้ว","น้ำใบเตย 1 แก้ว",
			"บรั่นดี (60 cc) 1 แก้ว","มิลค์เชค 1 แก้ว","วอดก้า 60 cc","วิสกี้ 60 cc","เบียร์ไทย 1 แก้ว",
			"เหล้ายิน 60 cc","เหล้ารัม 60 cc","แม่โขง (45 cc) 1 แก้ว","โกโก้ 1 แก้ว","โยเกิร์ต (รสธรรมชาติ) 1 กล่อง",
			"โยเกิร์ต (รสผลไม้) 1 กล่อง","โยเกิร์ต (ไขมันต่ำรสผลไม้) 1 กล่อง","โอวัลติน 1 แก้ว","โอเลี้ยง 1 แก้ว","ไวน์เชอรี่ 60 cc",
			"ไวน์แชมเปญ 60 cc"


	};


	private String[] text2 ={
			"55","115","110","100","55",
			"120","100","120","120","160",
			"125","80","140","200","125",
			"150","120","60","100","70",
			"70","80","100","90","100",
			"120","100","120","150","  48",
			"50","100","125","100","120",
			"90","112","120","75","130",
			"120","75","120","120","120",
			"130","150","120","140","148",
			"120","120","43","210","95",
			"175","160","210","165","84",
			"42"

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
		nameTitle.setText("เลือกเครื่องดื่มที่บริโภค");
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


		final AlertDialog.Builder alertDialogs = new AlertDialog.Builder(Calories_DRINK.this);
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