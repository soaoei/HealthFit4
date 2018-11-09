package app.HealthFit;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.graphics.Color;
 
import android.os.Bundle;
 
import android.util.Log;
import android.widget.LinearLayout;  
import app.HealthFit.fileconfixe.DatabaseExsersie;
import app.HealthFit.fileconfixe.DatabaseFood;

import com.jjoe64.graphview.GraphView;  
import com.jjoe64.graphview.GraphView.GraphViewData;  
import com.jjoe64.graphview.GraphViewSeries;  
import com.jjoe64.graphview.LineGraphView;  
public class MainActivity_graph_view1 extends Activity  {
	private ArrayList<String> groupItem = new ArrayList<String>();
	private ArrayList<ArrayList<HashMap<String, String>>> nodes;
	private ArrayList<HashMap<String, String>> output;
	private ArrayList<HashMap<String, String>> al;
	 
	private String user_accout_id;
	
	private DatabaseFood foodData;
	private DatabaseExsersie exsersie ;
	private ArrayList<HashMap<String, String>> selectAllData_listdatafoodData;
	
	private ArrayList<HashMap<String, String>> selectAllData_listdataexsersie;
	 public interface Constants {  
		              String TAG = "com.example.graphactivity";  
		       }  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grapview);
 
		foodData=new DatabaseFood(this);
		exsersie=new DatabaseExsersie(this);
 
			user_accout_id = Database_File6.Code_Id;//extras.getString("id");
	 
		setGroupData();
		
		
		
		
		int[] index = new int[al.size()];
        int[] incomeA = new int[al.size()];
    
        int count =0;
		 for(int k=0;k<al.size();k++){
				HashMap<String, String> hashMap = new HashMap<String, String>();
				 hashMap= al.get(k); 
				 count++;
				 index[k]=count;
				 
				 double aDouble1 = Double.parseDouble(hashMap.get("Key2"));
				  double aDouble2 = Double.parseDouble(hashMap.get("Key4"));
				 
				  
				  
			 
				  
				  Log.i("incomeA", ""+ incomeA[k]);
				 
				  
				  double totol=0;
				  
				  double totol1=0;
				  if(aDouble1>aDouble2){
					  totol= aDouble1-aDouble2;
					  ///incomeC[k]=(int)totol;
					  totol1=totol/7.7;
					//  text2.setText("���Ѻ��ѧ�ҹ  "+totol+"  Kcal"+"\n"+strS1+totol1+"  Grams");
					//Log.i("totol", ""+incomeC[k]);
					  incomeA[k]=(int)totol1;
				  }else{
					  totol= aDouble2-aDouble1;
					  //incomeC[k]=(int)totol;
					 // Log.i("totol", ""+incomeC[k]);
					  totol1=totol/7.7;
					  incomeA[k]=(int)totol1;
					  //text2.setText("�٭���¾�ѧ�ҹ  "+totol+"  Kcal"+"\n"+strS+totol1+"  Grams");
				  }
				  
			 
		 }
 
          GraphViewData[] data = new GraphViewData[index.length];
          for (int i = 0; i < index.length; i++) {
              data[i] = new GraphViewData(i, incomeA[i]);
          }
GraphViewSeries seriesA = new GraphViewSeries("น้ำหนัก", new GraphViewSeries.GraphViewSeriesStyle(Color.RED, 5), data);

 
          GraphView graphView = new LineGraphView(this, "กราฟความเปลี่ยนแปลงของน้ำหนัก");
          graphView.addSeries(seriesA);
          

          graphView.setShowLegend(true);

          LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
          layout.addView(graphView);
	
	}
public void setGroupData() {
		
		selectAllData_listdatafoodData= foodData.SelectAllData();
		selectAllData_listdataexsersie=exsersie.SelectAllData();
		String date_equ="";
	 
		  for(int k=0;k<selectAllData_listdatafoodData.size();k++){
			  
			  if(selectAllData_listdatafoodData.get(k).get("col1").equals(user_accout_id)&&selectAllData_listdatafoodData.get(k).get("col7").equals(date_equ)){
				  
			  }else if(selectAllData_listdatafoodData.get(k).get("col1").equals(user_accout_id)){
				  
				  date_equ=selectAllData_listdatafoodData.get(k).get("col7");
				  
				  groupItem.add(date_equ);
			  }else{
				  
			  }
		  }
		 
	nodes = new ArrayList<ArrayList<HashMap<String, String>>>();
	al= new ArrayList<HashMap<String, String>>();
	String date=" ";
	
	 double value =0;
	 String sd="";
	 
	 double value1 =0;
	 String sd1="";
	 
	 
	  for(int i=0;i<groupItem.size();i++){
		  value= 0;
		  output= new ArrayList<HashMap<String, String>>();
		  HashMap<String, String> hashMapAll = new HashMap<String, String>();
		  
		  for(int k=0;k<selectAllData_listdatafoodData.size();k++){
				  if(selectAllData_listdatafoodData.get(k).get("col1").equals(user_accout_id)&&selectAllData_listdatafoodData.get(k).get("col7").equals(groupItem.get(i))){
					  date=selectAllData_listdatafoodData.get(k).get("col7");
					   HashMap<String, String> hashMap = new HashMap<String, String>();
					    hashMap.put("col2", selectAllData_listdatafoodData.get(k).get("col2"));
				        hashMap.put("col3", selectAllData_listdatafoodData.get(k).get("col5"));
				        hashMap.put("col4",selectAllData_listdatafoodData.get(k).get("col4")+" Cal."+date );
				        value= value+Double.parseDouble(selectAllData_listdatafoodData.get(k).get("col4"));
				          sd= selectAllData_listdatafoodData.get(k).get("col8");
				    	output.add(hashMap);
			  }
		  }	
		 
		  
		  
		  
		  
 value1= 0;
		  
		  
		  
		  for(int k=0;k<selectAllData_listdataexsersie.size();k++){
				  if(selectAllData_listdataexsersie.get(k).get("col1").equals(user_accout_id)&&selectAllData_listdataexsersie.get(k).get("col7").equals(groupItem.get(i))){
					 
				        value1= value1+Double.parseDouble(selectAllData_listdataexsersie.get(k).get("col3"));
				          sd1= selectAllData_listdataexsersie.get(k).get("col8");
				    	 
			  }
		  }	
		  String aString = Double.toString(value);
		  String aString1 = Double.toString(value1);
		  
		  hashMapAll.put("Key1", groupItem.get(i));
		  hashMapAll.put("Key2",aString);
		  hashMapAll.put("Key3",sd);
		  
		  hashMapAll.put("Key4",aString1);
		  hashMapAll.put("Key5",sd1);
		  
		  nodes.add(output);
		  al.add (hashMapAll);
	  }

	  
}
}