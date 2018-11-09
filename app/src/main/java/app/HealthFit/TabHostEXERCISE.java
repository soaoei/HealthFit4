package app.HealthFit;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class TabHostEXERCISE extends Activity {

	private TabHost myTabHost;
	private LocalActivityManager myLocalActivityManager;
	private String user_accout_id;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_top);

		user_accout_id = Constants.idData;

		myTabHost = (TabHost) findViewById(R.id.TabHostMasterUNG);

		myLocalActivityManager = new LocalActivityManager(this, false);
		myTabHost.setup(myLocalActivityManager);
		myLocalActivityManager.dispatchCreate(savedInstanceState);

		TabHost.TabSpec spec;
		Intent goTab1 = new Intent().setClass(this, Burn_Activity.class); //tab1
		goTab1.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabSecond").setIndicator("กิจกรรม",getResources().getDrawable(R.drawable.ico_burn1)).setContent(goTab1);
		myTabHost.addTab(spec);


		Intent goTab2 = new Intent().setClass(this, Burn_Excercise.class); //tab2
		goTab2.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabSecond").setIndicator("ออกกำลังกาย",getResources().getDrawable(R.drawable.ico_burn1)).setContent(goTab2);
		myTabHost.addTab(spec);

		Intent goTab3 = new Intent().setClass(this, Burn_TOTAL.class); //tab3
		goTab3.putExtra("id", user_accout_id);
		spec = myTabHost.newTabSpec("tabFirst").setIndicator("ตรวจสอบการเผาผลาญ",getResources().getDrawable(R.drawable.ico_listdata)).setContent(goTab3);
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


