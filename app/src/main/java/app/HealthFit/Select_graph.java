package app.HealthFit;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import app.HealthFit.fileconfixe.DatabaseRegister;


public class Select_graph extends Activity {


	private Button button1,button2 ;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_graph);

		initWidget();

		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Select_graph.this, MainActivity_graph_view.class);
				startActivity(i);
			}
		});

		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Select_graph.this, MainActivity_graph_view1.class);
				startActivity(i);
			}
		});
	}





	void initWidget() {
		// TODO Auto-generated method stub

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);

	}
	@Override
	public void onBackPressed() {
		Select_graph.this.finish();
	}
}
