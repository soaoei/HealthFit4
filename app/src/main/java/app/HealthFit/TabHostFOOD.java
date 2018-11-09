package app.HealthFit;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class TabHostFOOD extends Activity {

	private TabHost myTabHost;
	private LocalActivityManager myLocalActivityManager;
	private String user_accout_id;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_top);

		user_accout_id = Constants.idData;
		//	Toast.makeText(TestTabHostdetail.this," "+user_accout_id, Toast.LENGTH_LONG).show();

		myTabHost = (TabHost) findViewById(R.id.TabHostMasterUNG);

		myLocalActivityManager = new LocalActivityManager(this, false);
		myTabHost.setup(myLocalActivityManager);
		myLocalActivityManager.dispatchCreate(savedInstanceState);

		TabHost.TabSpec spec;
		Intent goTab1 = new Intent().setClass(this, Calories_FOOD.class); //tab1
		goTab1.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabSecond1").setIndicator("อาหาร",getResources().getDrawable(R.drawable.ico_tabhost_f)).setContent(goTab1);
		myTabHost.addTab(spec);



		Intent goTab2 = new Intent().setClass(this, Calories_FRUIT.class); //tab1
		goTab2.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabSecond2").setIndicator("ผลไม้",getResources().getDrawable(R.drawable.ico_cate3)).setContent(goTab2);
		myTabHost.addTab(spec);


		Intent goTab3 = new Intent().setClass(this, Calories_SWEET.class); //tab1
		goTab3.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabSecond3").setIndicator("ของหวาน",getResources().getDrawable(R.drawable.ico_cate2)).setContent(goTab3);
		myTabHost.addTab(spec);

		Intent goTab4 = new Intent().setClass(this, Calories_DRINK.class); //tab1
		goTab4.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabSecond4").setIndicator("เครื่องดื่ม",getResources().getDrawable(R.drawable.ico_cate4)).setContent(goTab4);
		myTabHost.addTab(spec);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		myLocalActivityManager.dispatchPause(isFinishing());
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		myLocalActivityManager.dispatchResume();
	}
}


