package app.HealthFit;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Health_Tips04 extends ListActivity {

	private String listTitle[] = { "ยี่หร่าลดอ้วน", "ลดความอ้วนด้วยน้ำมันมะพร้าว", "6 วิธีกินคลีนนอกบ้าน",
			"น้ำอัดลมไดเอท ชนวนไมเกรนกำเริบ", "ลดน้ำหนักด้วยวิธี อัลคาไลน์ (Alkaline Diet)", "ลดน้ำหนักด้วยวิธี เพลีโอ (Paleo Diet)", "ลดน้ำหนักด้วยวิธี ดูกอง (Dukan Diet)", "เตรียมบอกลาความอ้วน มารู้จักสารสกัดกาแฟเขียวกัน",
			"อาบน้ำอุ่นสลับน้ำเย็นช่วยลดน้ำหนัก", "แขม่วท้องลดน้ำหนัก", "ดื่มน้ำลดน้ำหนัก", "อาหารคลีนไม่จำเป็นต้องราคาแพง", "เคล็ดลับช่วยผอมสำหรับคนต้องการอดอาหาร" };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new MyPerformanceArrayAdapter(this, listTitle));

		setContentView(R.layout.tips_04);
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {

		Intent goHealthDetailActivity = new Intent(getApplicationContext(),Health_Detail4.class);
		goHealthDetailActivity.putExtra("strTitleChoose", listTitle[position]);
		goHealthDetailActivity.putExtra("Position",position);
		startActivity(goHealthDetailActivity);

		//Toast.makeText(getApplicationContext(),
		//"You click " + listTitle[position], Toast.LENGTH_SHORT).show();
	}

	public class MyPerformanceArrayAdapter extends ArrayAdapter<String> {

		private final Activity context;
		private final String[] listTitle;

		public MyPerformanceArrayAdapter(Activity context, String[] listTitle) {
			super(context, R.layout.tips_04, listTitle);
			this.context = context;
			this.listTitle = listTitle;

		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View rowView = inflater.inflate(R.layout.tips_04, null, true);

			TextView NameTitle = (TextView) rowView
					.findViewById(R.id.txtNameTitle4);
			ImageView ImageEbook = (ImageView) rowView
					.findViewById(R.id.imgTips4);

			String listNameTitle = this.listTitle[position];
			NameTitle.setText(listNameTitle);

			if (listNameTitle.startsWith("ยี่หร่าลดอ้วน"))
				ImageEbook.setImageResource(R.drawable.d_lis_1);
			else if (listNameTitle.startsWith("ลดความอ้วนด้วยน้ำมันมะพร้าว"))
				ImageEbook.setImageResource(R.drawable.d_lis_2);
			else if (listNameTitle.startsWith("6 วิธีกินคลีนนอกบ้าน"))
				ImageEbook.setImageResource(R.drawable.d_lis_3);
			else if (listNameTitle.startsWith("น้ำอัดลมไดเอท ชนวนไมเกรนกำเริบ"))
				ImageEbook.setImageResource(R.drawable.d_lis_4);
			else if (listNameTitle.startsWith("ลดน้ำหนักด้วยวิธี อัลคาไลน์ (Alkaline Diet)"))
				ImageEbook.setImageResource(R.drawable.d_lis_5);
			else if (listNameTitle.startsWith("ลดน้ำหนักด้วยวิธี เพลีโอ (Paleo Diet"))
				ImageEbook.setImageResource(R.drawable.d_lis_6);
			else if (listNameTitle.startsWith("ลดน้ำหนักด้วยวิธี ดูกอง (Dukan Diet)"))
				ImageEbook.setImageResource(R.drawable.d_lis_7);
			else if (listNameTitle.startsWith("เตรียมบอกลาความอ้วน มารู้จักสารสกัดกาแฟเขียวกัน"))
				ImageEbook.setImageResource(R.drawable.d_lis_8);
			else if (listNameTitle.startsWith("อาบน้ำอุ่นสลับน้ำเย็นช่วยลดน้ำหนัก"))
				ImageEbook.setImageResource(R.drawable.d_lis_9);
			else if (listNameTitle.startsWith("แขม่วท้องลดน้ำหนัก"))
				ImageEbook.setImageResource(R.drawable.d_lis_10);
			else if (listNameTitle.startsWith("ดื่มน้ำลดน้ำหนัก"))
				ImageEbook.setImageResource(R.drawable.d_lis_11);
			else if (listNameTitle.startsWith("อาหารคลีนไม่จำเป็นต้องราคาแพง"))
				ImageEbook.setImageResource(R.drawable.d_lis_12);
			else if (listNameTitle.startsWith("เคล็ดลับช่วยผอมสำหรับคนต้องการอดอาหาร"))
				ImageEbook.setImageResource(R.drawable.d_lis_13);




			return rowView;

		}


	}

}
