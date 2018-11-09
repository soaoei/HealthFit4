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


public class Health_Tips03 extends ListActivity  {

	private String listTitle[] = { "ประโยชน์ของฟลูออไรด์ที่มีต่อฟัน", "วิธีดูแลเท้าในผู้ป่วยเบาหวาน", "น้ำปลาและยาสีฟัน กับแผลน้ำร้อนลวก",
			"น้ำมันมะพร้าวพิฆาตเหา", "น้ำมันมะพร้าวเพิ่มภูมิคุ้มกันและต้านเสื่อม", "ขับถ่ายดีด้วยน้ำมันมะพร้าว", "การนวดกดจุดสะท้อนฝ่าเท้า", "เมื่ออากาศเปลี่ยนแปลง",
			"คัน อย่าแก้แค่เกา", "ระวังสมาร์ทโฟนตัวการทำแก่ก่อนวัย", "4 วิธีกระตุ้นสมอง ช่วยให้จำแม่น", "10 วิธีบรรเทาอาการปวดหัวไมเกรน", "กระดูกสันหลังคด",
			"ผิวแห้ง Dry Skin", "ลดความอ้วนกับหลักการพื้นฐานการกินอย่างมีสติ", "ระวังใช้หัวโหม่งบอลอันตรายถึงชีวิต", "ดูทีวี แชทสมาร์ทโฟนในที่มืด เสี่ยงต้อหิน", "ภัยที่มาพร้อมกับแสงแดด",
			"วางมือถือไว้ที่หัวนอนเสี่ยงเป็นเนื้องอก", "มลพิษในอากาศ", "วิตามินดี มีประโยชน์", "เรื่องต้องห้ามยามนอน" };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new MyPerformanceArrayAdapter(this, listTitle));

		setContentView(R.layout.tips_03);
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {

		Intent goHealthDetailActivity = new Intent(getApplicationContext(),Health_Detail3.class);
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
			super(context, R.layout.tips_03, listTitle);
			this.context = context;
			this.listTitle = listTitle;

		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View rowView = inflater.inflate(R.layout.tips_03, null, true);

			TextView NameTitle = (TextView) rowView
					.findViewById(R.id.txtNameTitle3);
			ImageView ImageEbook = (ImageView) rowView
					.findViewById(R.id.imgTips3);

			String listNameTitle = this.listTitle[position];
			NameTitle.setText(listNameTitle);

			if (listNameTitle.startsWith("ประโยชน์ของฟลูออไรด์ที่มีต่อฟัน"))
				ImageEbook.setImageResource(R.drawable.c_lis_1);
			else if (listNameTitle.startsWith("วิธีดูแลเท้าในผู้ป่วยเบาหวาน"))
				ImageEbook.setImageResource(R.drawable.c_lis_2);
			else if (listNameTitle.startsWith("น้ำปลาและยาสีฟัน กับแผลน้ำร้อนลวก"))
				ImageEbook.setImageResource(R.drawable.c_lis_3);
			else if (listNameTitle.startsWith("น้ำมันมะพร้าวพิฆาตเหา"))
				ImageEbook.setImageResource(R.drawable.c_lis_4);
			else if (listNameTitle.startsWith("น้ำมันมะพร้าวเพิ่มภูมิคุ้มกันและต้านเสื่อม"))
				ImageEbook.setImageResource(R.drawable.c_lis_5);
			else if (listNameTitle.startsWith("ขับถ่ายดีด้วยน้ำมันมะพร้าว"))
				ImageEbook.setImageResource(R.drawable.c_lis_6);
			else if (listNameTitle.startsWith("การนวดกดจุดสะท้อนฝ่าเท้า"))
				ImageEbook.setImageResource(R.drawable.c_lis_7);
			else if (listNameTitle.startsWith("เมื่ออากาศเปลี่ยนแปลง"))
				ImageEbook.setImageResource(R.drawable.c_lis_8);
			else if (listNameTitle.startsWith("คัน อย่าแก้แค่เกา"))
				ImageEbook.setImageResource(R.drawable.c_lis_9);
			else if (listNameTitle.startsWith("ระวังสมาร์ทโฟนตัวการทำแก่ก่อนวัย"))
				ImageEbook.setImageResource(R.drawable.c_lis_10);
			else if (listNameTitle.startsWith("4 วิธีกระตุ้นสมอง ช่วยให้จำแม่น"))
				ImageEbook.setImageResource(R.drawable.c_lis_11);
			else if (listNameTitle.startsWith("10 วิธีบรรเทาอาการปวดหัวไมเกรน"))
				ImageEbook.setImageResource(R.drawable.c_lis_12);
			else if (listNameTitle.startsWith("กระดูกสันหลังคด"))
				ImageEbook.setImageResource(R.drawable.c_lis_13);
			else if (listNameTitle.startsWith("ผิวแห้ง Dry Skin"))
				ImageEbook.setImageResource(R.drawable.c_lis_14);
			else if (listNameTitle.startsWith("ลดความอ้วนกับหลักการพื้นฐานการกินอย่างมีสติ"))
				ImageEbook.setImageResource(R.drawable.c_lis_15);
			else if (listNameTitle.startsWith("ระวังใช้หัวโหม่งบอลอันตรายถึงชีวิต"))
				ImageEbook.setImageResource(R.drawable.c_lis_16);
			else if (listNameTitle.startsWith("ดูทีวี แชทสมาร์ทโฟนในที่มืด เสี่ยงต้อหิน"))
				ImageEbook.setImageResource(R.drawable.c_lis_17);
			else if (listNameTitle.startsWith("ภัยที่มาพร้อมกับแสงแดด"))
				ImageEbook.setImageResource(R.drawable.c_lis_18);
			else if (listNameTitle.startsWith("วางมือถือไว้ที่หัวนอนเสี่ยงเป็นเนื้องอก"))
				ImageEbook.setImageResource(R.drawable.c_lis_19);
			else if (listNameTitle.startsWith("มลพิษในอากาศ"))
				ImageEbook.setImageResource(R.drawable.c_lis_20);
			else if (listNameTitle.startsWith("วิตามินดี มีประโยชน์"))
				ImageEbook.setImageResource(R.drawable.c_lis_21);
			else if (listNameTitle.startsWith("เรื่องต้องห้ามยามนอน"))
				ImageEbook.setImageResource(R.drawable.c_lis_22);



			return rowView;

		}


	}

}
