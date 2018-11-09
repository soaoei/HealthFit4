package app.HealthFit;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class TabHostADMIN extends Activity {

	private TabHost myTabHost;
	private LocalActivityManager myLocalActivityManager;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_top);


		myTabHost = (TabHost) findViewById(R.id.TabHostMasterUNG);


		myLocalActivityManager = new LocalActivityManager(this, false);
		myTabHost.setup(myLocalActivityManager);
		myLocalActivityManager.dispatchCreate(savedInstanceState);

		TabHost.TabSpec spec;
		Intent goSecond = new Intent().setClass(this, Login.class);
		spec = myTabHost.newTabSpec("tabSecond").setIndicator("Sign In",getResources().getDrawable(R.drawable.ico_signin)).setContent(goSecond);
		myTabHost.addTab(spec);

		Intent goFirst = new Intent().setClass(this, Register.class);
		spec = myTabHost.newTabSpec("tabFirst").setIndicator("Regist",getResources().getDrawable(R.drawable.ico_register)).setContent(goFirst);
		myTabHost.addTab(spec);

//		Intent goFirstUpdate_Register = new Intent().setClass(this, Update_Register.class);
//		spec = myTabHost.newTabSpec("tabFirst").setIndicator("Register",getResources().getDrawable(R.drawable.ico_register)).setContent(goFirstUpdate_Register);
//		myTabHost.addTab(spec);
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


