package app.HealthFit;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;




public class BMR extends Activity {
	private RadioButton radio0,radio1;
	private Spinner spinner1;
	private String str = " ";
	private String strdate = " ";
	private EditText  height ,weight,age;
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.bmr);
		final  Calendar  cal_Tomorrow= Calendar.getInstance();
		final SimpleDateFormat formats = new SimpleDateFormat("yyyy/MM/dd, EEEE");
		strdate=formats.format(cal_Tomorrow.getTime());


		height = (EditText) findViewById(R.id.editetext1);
		weight = (EditText) findViewById(R.id.editetext2);
		age= (EditText) findViewById(R.id.editetext3);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();
		list.add("นั่งทำงานอยู่กับที่ และไม่ได้ออกกำลังกายเลย");
		list.add("ออกกำลังกายน้อยเล่นกีฬา 1-3 วัน/สัปดาห์");
		list.add("ออกกำลังกายปานกลางเล่นกีฬา 3-5 วัน/สัปดาห์ ");
		list.add("ออกกำลังกายหนักเล่นกีฬา 6-7 วัน /สัปดาห์ ");
		list.add("ออกกำลังกายเล่นกีฬาอย่างหนักทุกวัน");



		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
		dataAdapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter);


		radio0=(RadioButton)findViewById(R.id.radio0);
		radio1=(RadioButton)findViewById(R.id.radio1);
		radio0.setText("ชาย");
		radio1.setText("หญิง");

		Button  btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(height.getText().toString().equals("")||
						weight.getText().toString().equals("")||
						age.getText().toString().equals("")){

					Toast.makeText(getApplicationContext(),"กรุณากรอกข้อมูลให้ครบ  ",Toast.LENGTH_SHORT).show();
				}else{

					showOneButton(String.valueOf(spinner1.getSelectedItem()));
				}

			}

		});


		Button  btnCancel = (Button) findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				height.setText(" ");
				weight.setText(" ");
				age.setText(" ");
			}

		});

	}

	protected void showOneButton(String str) {
		RadioGroup  grp=(RadioGroup)findViewById(R.id.radioGroup1);
		final RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());

		float height_ = Float.parseFloat(height.getText().toString());
		float weight_s = Float.parseFloat(weight.getText().toString());
		float ages = Float.parseFloat(age.getText().toString());

		float bmr ;

		if(answer.getText().equals("ชาย")){
			bmr= (float)(66.0+(13.7 * weight_s)+(5.0 * height_)-(6.8 * ages));
		}else {
			bmr= (float)(665+(9.6 * weight_s)+(1.8 * height_)-(4.7*ages));
		}


		if( str.equals("นั่งทำงานอยู่กับที่ และไม่ได้ออกกำลังกายเลย")){
			bmr=(float) (bmr * 1.2);
		}else if( str.equals("ออกกำลังกายหรือเล่นกีฬาเล็กน้อย ประมาณอาทิตย์ละ 1-3 วัน")){
			bmr=(float) (bmr * 1.375);
		}else if( str.equals("ออกกำลังกายหรือเล่นกีฬาปานกลาง ประมาณอาทิตย์ละ 3-5 วัน ")){
			bmr=(float) (bmr * 1.55);
		}else if( str.equals("ออกกำลังกายหรือเล่นกีฬาอย่างหนัก ประมาณอาทิตย์ละ 6-7 วัน ")){
			bmr=(float) (bmr * 1.725);
		}else if( str.equals("ออกกำลังกายหรือเล่นกีฬาอย่างหนักทุกวันเช้าเย็น")){
			bmr=(float) (bmr * 1.9);
		}


		bmr = round(bmr, 2);
		String bmr1 = String.valueOf(bmr);

		str="ถ้า"+answer.getText()+"คนนี้จะมีชีวิตอยู่ต่อไปได้ในแต่ละวัน ("+str+") ก็จะต้องการพลังงานอย่างน้อย    :"+bmr+" กิโลแคลอรี่";

		final String bmr_= String.valueOf(bmr );
		// TODO Auto-generated method stub
		AlertDialog.Builder oneButton = new AlertDialog.Builder(this);

		// Set Icon
		oneButton.setIcon(R.drawable.ico_bmi);

		// Set Title
		oneButton.setTitle("ปริมาณพลังงานที่ร่างกายต้องการ");

		// Set Message
		oneButton.setMessage("ปริมาณพลังงานที่ร่างกายต้องการในแต่ละวันสำหรับการดำรงชีวิตอยู่   "+str);

		// Set Positive Button
		oneButton.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Intent to FirstActivity


					}
				});
		oneButton.show();

	}//showOneButton

	public static float round(float value, int places) {
		if (places < 0) throw new IllegalArgumentException();
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (float) tmp / factor;
	}

}//BMR