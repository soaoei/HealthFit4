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



public class Health_Tips01 extends ListActivity  {

	private String listTitle[] = { "ดูแลดวงตาด้วยวิตามิน", "กินยาถ่ายพยาธิชนิดไหนดี", "น้ำมันเมล็ดองุ่น Grapeseed Oil",
			"ดื่มกาแฟช่วยรักษาสุขภาพตับ", "รู้จักสิ่งปนเปื้อนในน้ำก่อนดื่ม", "สารพิษสารเคมีในอาหาร", "วิธีการใช้ยาพาราเซตามอลที่ถูกต้อง", "ดื่มนมอุ่นก่อนนอน หลับง่ายหลับสนิทมากขึ้น",
			"20 ผักผลไม้ล้างพิษ", "หัวใจของคุณแข็งแรงดีอยู่หรือไม่", "น้ำช่วยสุขภาพดี", "ไลโคปีนในมะเขือเทศ ต้านพิษระบบสืบพันธุ์", "น้ำคั้นผลไม้ วิตามินเข้มข้นรักษาโรคตรงจุด",
			"ผักและผลไม้อย่าได้ขาด", "สตรอว์เบอร์รี่ จิ๋วแต่แจ๋ว", "ไข่วันละฟอง ไม่ทำร้ายสุขภาพ", "แคลเซียม", "เติมพลังสมองด้วยอาหารที่ดีที่สุดสำหรับสมอง",
			"ข้าวสาลีมีประโยชน์ทั้งการกินและการใช้", "ยากับน้ำผลไม้ ไม่ใช่ของคู่กัน", "รู้ไว้ใช่ว่า การกินยาที่ถูกวิธี", "กินเนื้อดิบอันตรายเสี่ยงโรคร้าย", "ยาเสื่อม ยาหมดอายุ ดูรู้ได้อย่างไร",
			"ข้าวเปล่า ที่ไม่เปล่าประโยชน์", "กาแฟลดความอ้วนช่วยได้จริงหรือ", "7 คุณประโยชน์ของกระเทียม ที่คุณอาจคาดไม่ถึง", "บำรุงผิวพรรณป้องกันมะเร็งด้วย ข้าวโพด",
			"ดื่มน้ำตามน้ำหนักตัว", "ดื่มน้ำตอนไหน ถึงจะดีกับร่างกาย", "กล้วย", "เคล็ดไม่ลับล้างผักสะอาดปลอดจากสารพิษตกค้าง"
	};



	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new MyPerformanceArrayAdapter(this, listTitle));

		setContentView(R.layout.tips_01);

	}

	protected void onListItemClick(ListView l, View v, int position, long id) {

		Intent goHealthDetailActivity = new Intent(getApplicationContext(),Health_Detail1.class);
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
			super(context, R.layout.tips_01, listTitle);
			this.context = context;
			this.listTitle = listTitle;

		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View rowView = inflater.inflate(R.layout.tips_01, null, true);

			TextView NameTitle = (TextView) rowView
					.findViewById(R.id.txtNameTitle1);
			ImageView ImageEbook = (ImageView) rowView
					.findViewById(R.id.imgTips1);

			String listNameTitle = this.listTitle[position];
			NameTitle.setText(listNameTitle);

			if (listNameTitle.startsWith("ดูแลดวงตากับวิตามิน"))
				ImageEbook.setImageResource(R.drawable.a_lis_1);
			else if (listNameTitle.startsWith("กินยาถ่ายพยาธิชนิดไหนดี"))
				ImageEbook.setImageResource(R.drawable.a_lis_2);
			else if (listNameTitle.startsWith("น้ำมันเมล็ดองุ่น Grapeseed Oil"))
				ImageEbook.setImageResource(R.drawable.a_lis_3);
			else if (listNameTitle.startsWith("ดื่มกาแฟช่วยรักษาสุขภาพตับ"))
				ImageEbook.setImageResource(R.drawable.a_lis_4);
			else if (listNameTitle.startsWith("รู้จักสิ่งปนเปื้อนในน้ำก่อนดื่ม"))
				ImageEbook.setImageResource(R.drawable.a_lis_5);
			else if (listNameTitle.startsWith("สารพิษสารเคมีในอาหาร"))
				ImageEbook.setImageResource(R.drawable.a_lis_6);
			else if (listNameTitle.startsWith("วิธีการใช้ยาพาราเซตามอลที่ถูกต้อง"))
				ImageEbook.setImageResource(R.drawable.a_lis_7);
			else if (listNameTitle.startsWith("ดื่มนมอุ่นก่อนนอน หลับง่ายหลับสนิทมากขึ้น"))
				ImageEbook.setImageResource(R.drawable.a_lis_8);
			else if (listNameTitle.startsWith("20 ผักผลไม้ล้างพิษ"))
				ImageEbook.setImageResource(R.drawable.a_lis_9);
			else if (listNameTitle.startsWith("หัวใจของคุณแข็งแรงดีอยู่หรือไม่"))
				ImageEbook.setImageResource(R.drawable.a_lis_10);
			else if (listNameTitle.startsWith("น้ำช่วยสุขภาพดี"))
				ImageEbook.setImageResource(R.drawable.a_lis_11);
			else if (listNameTitle.startsWith("ไลโคปีนในมะเขือเทศ ต้านพิษระบบสืบพันธุ์"))
				ImageEbook.setImageResource(R.drawable.a_lis_12);
			else if (listNameTitle.startsWith("น้ำคั้นผลไม้ วิตามินเข้มข้นรักษาโรคตรงจุด"))
				ImageEbook.setImageResource(R.drawable.a_lis_13);
			else if (listNameTitle.startsWith("ผักและผลไม้อย่าได้ขาด"))
				ImageEbook.setImageResource(R.drawable.a_lis_14);
			else if (listNameTitle.startsWith("สตรอว์เบอร์รี่ จิ๋วแต่แจ๋ว"))
				ImageEbook.setImageResource(R.drawable.a_lis_15);
			else if (listNameTitle.startsWith("ไข่วันละฟอง ไม่ทำร้ายสุขภาพ"))
				ImageEbook.setImageResource(R.drawable.a_lis_16);
			else if (listNameTitle.startsWith("แคลเซียม"))
				ImageEbook.setImageResource(R.drawable.a_lis_17);
			else if (listNameTitle.startsWith("เติมพลังสมองด้วยอาหารที่ดีที่สุดสำหรับสมอง"))
				ImageEbook.setImageResource(R.drawable.a_lis_18);
			else if (listNameTitle.startsWith("ข้าวสาลีมีประโยชน์ทั้งการกินและการใช้"))
				ImageEbook.setImageResource(R.drawable.a_lis_19);
			else if (listNameTitle.startsWith("ยากับน้ำผลไม้ ไม่ใช่ของคู่กัน"))
				ImageEbook.setImageResource(R.drawable.a_lis_20);
			else if (listNameTitle.startsWith("รู้ไว้ใช่ว่า การกินยาที่ถูกวิธี"))
				ImageEbook.setImageResource(R.drawable.a_lis_21);
			else if (listNameTitle.startsWith("กินเนื้อดิบอันตรายเสี่ยงโรคร้าย"))
				ImageEbook.setImageResource(R.drawable.a_lis_22);
			else if (listNameTitle.startsWith("ยาเสื่อม ยาหมดอายุ ดูรู้ได้อย่างไร"))
				ImageEbook.setImageResource(R.drawable.a_lis_23);
			else if (listNameTitle.startsWith("ข้าวเปล่า ที่ไม่เปล่าประโยชน์"))
				ImageEbook.setImageResource(R.drawable.a_lis_24);
			else if (listNameTitle.startsWith("กาแฟลดความอ้วนช่วยได้จริงหรือ"))
				ImageEbook.setImageResource(R.drawable.a_lis_25);
			else if (listNameTitle.startsWith("7 คุณประโยชน์ของกระเทียม ที่คุณอาจคาดไม่ถึง"))
				ImageEbook.setImageResource(R.drawable.a_lis_26);
			else if (listNameTitle.startsWith("บำรุงผิวพรรณป้องกันมะเร็งด้วย ข้าวโพด"))
				ImageEbook.setImageResource(R.drawable.a_lis_27);
			else if (listNameTitle.startsWith("ดื่มน้ำตามน้ำหนักตัว"))
				ImageEbook.setImageResource(R.drawable.a_lis_28);
			else if (listNameTitle.startsWith("ดื่มน้ำตอนไหน ถึงจะดีกับร่างกาย"))
				ImageEbook.setImageResource(R.drawable.a_lis_29);
			else if (listNameTitle.startsWith("กล้วย"))
				ImageEbook.setImageResource(R.drawable.a_lis_30);
			else if (listNameTitle.startsWith("เคล็ดไม่ลับล้างผักสะอาดปลอดจากสารพิษตกค้าง"))
				ImageEbook.setImageResource(R.drawable.a_lis_31);


			return rowView;

		}


	}
}
