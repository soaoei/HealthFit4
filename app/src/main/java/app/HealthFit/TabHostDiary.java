package app.HealthFit;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class TabHostDiary extends Activity {

	private TabHost myTabHost;
	private LocalActivityManager myLocalActivityManager;
	private String user_accout_id;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_top);
//หน้าประวัติ
		user_accout_id = Constants.idData;
		//	Toast.makeText(TestTabHostdetail.this," "+user_accout_id, Toast.LENGTH_LONG).show();

		myTabHost = (TabHost) findViewById(R.id.TabHostMasterUNG);

		myLocalActivityManager = new LocalActivityManager(this, false);
		myTabHost.setup(myLocalActivityManager);
		myLocalActivityManager.dispatchCreate(savedInstanceState);

		TabHost.TabSpec spec;


		///Calories_ALL_55555 Calories_ALL
		Intent goTab6 = new Intent().setClass(this, Calories_ALL.class); //tab6
		goTab6.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabFirst").setIndicator("รายการอาหารทั้งหมด",getResources().getDrawable(R.drawable.ico_listdata)).setContent(goTab6);
		myTabHost.addTab(spec);

		//Burn_All555 //Burn_ALL
		Intent goTab4 = new Intent().setClass(this, Burn_All.class); //tab4
		goTab4.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabFirst").setIndicator("รายการออกกำลังกายทั้งหมด",getResources().getDrawable(R.drawable.ico_listdata)).setContent(goTab4);
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


