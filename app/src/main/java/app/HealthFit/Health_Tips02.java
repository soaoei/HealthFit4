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


public class Health_Tips02 extends ListActivity {

	private String listTitle[] = { "ดื่มน้ำ 400-600 มล. ก่อนออกกำลังกาย", "นักกีฬาต้องการพลังงานมากกว่า", "เรื่องต้องรู้ ก่อนออกกำลังกาย",
			"ออกกำลังกายพัฒนาสมอง", "เครื่องดื่มเสริมพลังระหว่างออกกำลังกาย", "หลักการพื้นฐานของการออกกำลังกาย", "ออกกำลัง ต้านมะเร็ง", "ผู้สูงอายุประมาณ 70 ปี ควรออกกำลังกายแบบไหนดี",
			"10 นาทีที่ทำให้รูปร่างลดลง", "วิ่ง เป็นประจำอายุยืนกว่าไม่วิ่งถึง 3 ปี", "เดินแบบไหน ได้ประโยชน์ตรงจุด", "เดินออกกำลังกาย เดินเร็วแต่ละก้าวมีความหมาย", "ออกกำลังกาย ให้สมวัย สำหรับผู้สูงอายุ",
			"โยคะร้อนมีประโยชน์มากมาย แต่ผลข้างเคียงก็ไม่น้อย", "การวิ่งดีต่อความแข็งแรงของกล้ามเนื้อ", "นอนเฉยๆ ก็ลดหน้าท้องได้ง่ายจัง", "วิ่งลงส้นเท้าและวิ่งปลายเท้าแตกต่างกันอย่างไร", "ออกกำลังกายด้วยการเดินแก้เซ็กซ์เสื่อม" };



	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new MyPerformanceArrayAdapter(this, listTitle));

		setContentView(R.layout.tips_02);
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {

		Intent goHealthDetailActivity = new Intent(getApplicationContext(),Health_Detail2.class);
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
			super(context, R.layout.tips_02, listTitle);
			this.context = context;
			this.listTitle = listTitle;

		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View rowView = inflater.inflate(R.layout.tips_02, null, true);

			TextView NameTitle = (TextView) rowView
					.findViewById(R.id.txtNameTitle2);
			ImageView ImageEbook = (ImageView) rowView
					.findViewById(R.id.imgTips2);

			String listNameTitle = this.listTitle[position];
			NameTitle.setText(listNameTitle);

			if (listNameTitle.startsWith("ดื่มน้ำ 400-600 มล. ก่อนออกกำลังกาย"))
				ImageEbook.setImageResource(R.drawable.b_lis_1);
			else if (listNameTitle.startsWith("นักกีฬาต้องการพลังงานมากกว่า"))
				ImageEbook.setImageResource(R.drawable.b_lis_2);
			else if (listNameTitle.startsWith("เรื่องต้องรู้ ก่อนออกกำลังกาย"))
				ImageEbook.setImageResource(R.drawable.b_lis_3);
			else if (listNameTitle.startsWith("ออกกำลังกายพัฒนาสมอง"))
				ImageEbook.setImageResource(R.drawable.b_lis_4);
			else if (listNameTitle.startsWith("เครื่องดื่มเสริมพลังระหว่างออกกำลังกาย"))
				ImageEbook.setImageResource(R.drawable.b_lis_5);
			else if (listNameTitle.startsWith("หลักการพื้นฐานของการออกกำลังกาย"))
				ImageEbook.setImageResource(R.drawable.b_lis_6);
			else if (listNameTitle.startsWith("ออกกำลัง ต้านมะเร็ง"))
				ImageEbook.setImageResource(R.drawable.b_lis_7);
			else if (listNameTitle.startsWith("ผู้สูงอายุประมาณ 70 ปี ควรออกกำลังกายแบบไหนดี"))
				ImageEbook.setImageResource(R.drawable.b_lis_8);
			else if (listNameTitle.startsWith("10 นาทีที่ทำให้รูปร่างลดลง"))
				ImageEbook.setImageResource(R.drawable.b_lis_9);
			else if (listNameTitle.startsWith("วิ่ง เป็นประจำอายุยืนกว่าไม่วิ่งถึง 3 ปี"))
				ImageEbook.setImageResource(R.drawable.b_lis_10);
			else if (listNameTitle.startsWith("เดินแบบไหน ได้ประโยชน์ตรงจุด"))
				ImageEbook.setImageResource(R.drawable.b_lis_11);
			else if (listNameTitle.startsWith("เดินออกกำลังกาย เดินเร็วแต่ละก้าวมีความหมาย"))
				ImageEbook.setImageResource(R.drawable.b_lis_12);
			else if (listNameTitle.startsWith("ออกกำลังกาย ให้สมวัย สำหรับผู้สูงอายุ"))
				ImageEbook.setImageResource(R.drawable.b_lis_13);
			else if (listNameTitle.startsWith("โยคะร้อนมีประโยชน์มากมาย แต่ผลข้างเคียงก็ไม่น้อย"))
				ImageEbook.setImageResource(R.drawable.b_lis_14);
			else if (listNameTitle.startsWith("การวิ่งดีต่อความแข็งแรงของกล้ามเนื้อ"))
				ImageEbook.setImageResource(R.drawable.b_lis_15);
			else if (listNameTitle.startsWith("นอนเฉยๆ ก็ลดหน้าท้องได้ง่ายจัง"))
				ImageEbook.setImageResource(R.drawable.b_lis_16);
			else if (listNameTitle.startsWith("วิ่งลงส้นเท้าและวิ่งปลายเท้าแตกต่างกันอย่างไร"))
				ImageEbook.setImageResource(R.drawable.b_lis_17);
			else if (listNameTitle.startsWith("ออกกำลังกายด้วยการเดินแก้เซ็กซ์เสื่อม"))
				ImageEbook.setImageResource(R.drawable.b_lis_18);


			return rowView;

		}


	}


}
