package app.HealthFit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;



public class Health_Tips extends Activity  {


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tips);
		LinearLayout button_tips1 = (LinearLayout) findViewById(R.id.button_tips1);
		button_tips1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub


				Intent i = new Intent(Health_Tips.this, Health_Tips01.class);
				startActivity(i);
			}
		});

		LinearLayout button_tips2 = (LinearLayout) findViewById(R.id.button_tips2);
		button_tips2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Health_Tips.this, Health_Tips02.class);
				startActivity(i);

			}
		});

		LinearLayout button_tips3 = (LinearLayout) findViewById(R.id.button_tips3);
		button_tips3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Health_Tips.this, Health_Tips03.class);
				startActivity(i);

			}
		});

		LinearLayout button_tips4 = (LinearLayout) findViewById(R.id.button_tips4);
		button_tips4.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Health_Tips.this, Health_Tips04.class);
				startActivity(i);

			}
		});
	}
}
