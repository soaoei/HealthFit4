package app.HealthFit;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.ArrayList;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import app.HealthFit.fileconfixe.DatabaseExsersie;
import app.HealthFit.fileconfixe.DatabaseFood;
import app.HealthFit.fileconfixe.DatabaseRegister;


public class Burn_All extends ExpandableListActivity implements OnChildClickListener {
	ArrayList<ArrayList<HashMap<String, String>>> nodes;
	private ArrayList<HashMap<String, String>> output;
	private ArrayList<HashMap<String, String>> al;
	private DatabaseRegister namedata;
	private String user_accout_id;
	private DatabaseExsersie exsersie;
	private ArrayList<HashMap<String, String>> selectAllData_listdata;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		exsersie=new DatabaseExsersie(this);
		namedata=new DatabaseRegister(this);
		Bundle extras = getIntent().getExtras();
		if (extras != null)

		{
			user_accout_id = extras.getString("id");
		}


	}
	@Override
	public void onStart(){
		super.onStart();

		Setdataandroid();
	}

	private void Setdataandroid() {
		// TODO Auto-generated method stub

		ExpandableListView expandbleLis = getExpandableListView();
		expandbleLis.setDividerHeight(2);
		expandbleLis.setGroupIndicator(null);
		expandbleLis.setClickable(true);
		setGroupData();


		Burn_ALL_Group mNewAdapter = new Burn_ALL_Group(al, nodes);
		mNewAdapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),this);
		getExpandableListView().setAdapter(mNewAdapter);
		expandbleLis.setOnChildClickListener(this);
	}

	public void setGroupData() {
		selectAllData_listdata= exsersie.SelectAllData();
		String date_equ="";

		for(int k=0;k<selectAllData_listdata.size();k++){

			if(selectAllData_listdata.get(k).get("col1").equals(user_accout_id)&&selectAllData_listdata.get(k).get("col7").equals(date_equ)){

			}else if(selectAllData_listdata.get(k).get("col1").equals(user_accout_id)){

				date_equ=selectAllData_listdata.get(k).get("col7");

				groupItem.add(date_equ);

			}else{

			}
		}

		nodes = new ArrayList<ArrayList<HashMap<String, String>>>();
		al= new ArrayList<HashMap<String, String>>();
		String date=" ";

		double value =0;
		String sd="";
		for(int i=0;i<groupItem.size();i++){
			value= 0;

			output= new ArrayList<HashMap<String, String>>();
			HashMap<String, String> hashMapAll = new HashMap<String, String>();
			for(int k=0;k<selectAllData_listdata.size();k++){
				if(selectAllData_listdata.get(k).get("col1").equals(user_accout_id)&&selectAllData_listdata.get(k).get("col7").equals(groupItem.get(i))){
					date=selectAllData_listdata.get(k).get("col7");
					HashMap<String, String> hashMap = new HashMap<String, String>();
					hashMap.put("col2", selectAllData_listdata.get(k).get("col2"));
					hashMap.put("col3", selectAllData_listdata.get(k).get("col5"));
					hashMap.put("col4",selectAllData_listdata.get(k).get("col4")+" Cal."+date );
					value= value+Double.parseDouble(selectAllData_listdata.get(k).get("col4"));
					sd= selectAllData_listdata.get(k).get("col8");
					output.add(hashMap);
				}
			}

			String aString = Double.toString(value);
			hashMapAll.put("Key1", groupItem.get(i));
			hashMapAll.put("Key2",aString);
			hashMapAll.put("Key3",sd);


			nodes.add(output);
			al.add (hashMapAll);
		}


	}

	ArrayList<String> groupItem = new ArrayList<String>();




	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
								int groupPosition, int childPosition, long id) {
		//al.get(0).get

		Toast.makeText(Burn_All.this, "Clicked On Child",
				Toast.LENGTH_SHORT).show(); return true;
	}
}