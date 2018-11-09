package app.HealthFit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;



public class MainActivity extends Activity  {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LinearLayout buttonSomething1 = (LinearLayout) findViewById(R.id.buttonSomething1); //calories
		buttonSomething1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub


			    	Intent i = new Intent(MainActivity.this, TabHostFOOD.class);
			        startActivity(i);
			}
		});

		LinearLayout buttonSomething2 = (LinearLayout) findViewById(R.id.buttonSomething2); //burnCalories

		buttonSomething2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

						 Intent i = new Intent(MainActivity.this, TabHostEXERCISE.class);
			             startActivity(i);

			}
		});

		LinearLayout buttonSomething3 = (LinearLayout) findViewById(R.id.buttonSomething3); //BMI
		buttonSomething3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub


						 Intent i = new Intent(MainActivity.this,BMI.class);
			               startActivity(i);
			}
		});

		LinearLayout buttonSomething4 = (LinearLayout) findViewById(R.id.buttonSomething4); //BMR
		buttonSomething4.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub


						 Intent i = new Intent(MainActivity.this, BMR.class);
			               startActivity(i);
			}
		});




//			   LinearLayout buttonSomething6 = (LinearLayout) findViewById(R.id.buttonSomething6); //BMR
//			   buttonSomething6.setOnClickListener(new OnClickListener() {
//			   
//			      public void onClick(View v) {
//			          // TODO Auto-generated method stub 
//			  		
//
//						 Intent i = new Intent(MainActivity.this, Detail_Register.class);
//			               startActivity(i);
//			      } 
//			   }); 
	}
}
