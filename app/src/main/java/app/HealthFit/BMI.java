package app.HealthFit;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class BMI extends Activity {
	private String str = " ";
	private EditText  height ,weight;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bmi);
		height = (EditText) findViewById(R.id.editetext1);
		weight = (EditText) findViewById(R.id.editetext2);


		Button  btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(height.getText().toString().equals("")||
						weight.getText().toString().equals("")){

					Toast.makeText(getApplicationContext(),"กรุณากรอกข้อมูลให้ครบ  ",Toast.LENGTH_SHORT).show();
				}

				else{

					showOneButton();
				}

			}

		});

		Button  btnCancel = (Button) findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				height.setText(" ");
				weight.setText(" ");
			}

		});

	}
	protected void showOneButton() {

		float height_       = Float.parseFloat(height.getText().toString());
		float height_s      = height_/100;
		float height_height = height_s*height_s;
		float weight_s      = Float.parseFloat(weight.getText().toString());
		float count         = weight_s/height_height;

		count = round(count, 2);
		String str = String.valueOf(count);

		if(count<=18.5){
			str="น้ำหนักน้อยเกินไป ซึ่งอาจจะเกิดจากนักกีฬาที่ออกกำลังกายมาก และได้รับสารอาหารไม่เพียงพอ วิธีแก้ไขต้องรับประทานอาหารที่มีคุณภาพ และมีปริมาณพลังงานเพียงพอ และออกกำลังกายอย่างเหมาะสม";
		}else if(count>18.5&&count<=23.4){
			str="น้ำหนักปกติ และมีปริมาณไขมันอยู่ในเกณฑ์ปกติ มักจะไม่ค่อยมีโรคร้าย อุบัติการณ์ของโรคเบาหวาน ความดันโลหิตสูงต่ำกว่าผู้ที่อ้วนกว่านี้";
		}else if(count>23.4&&count<=28.4){
			str="น้ำหนักเกิน หากคุณมีกรรมพันธ์เป็นโรคเบาหวานหรือไขมันในเลือดสูงต้องพยายามลดน้ำหนักให้ดัชนีมวลกายต่ำกว่า 23";
		}else if(count>28.4&&count<=34.9){
			str="โรคอ้วนระดับ1 และหากคุณมีเส้นรอบเอวมากกว่า 90 ซม.(ชาย) 80 ซม.(หญิง) คุณจะมีโอกาศเกิดโรคความดัน เบาหวานสูง จำเป็นต้องควบคุมอาหาร และออกกำลังกาย";
		}else if(count>34.9&&count<=39.9){
			str="โรคอ้วนระดับ2 คุณเสี่ยงต่อการเกิดโรคที่มากับความอ้วน หากคุณมีเส้นรอบเอวมากกว่าเกณฑ์ปกติคุณจะเสี่ยงต่อการเกิดโรคสูง คุณต้องควบคุมอาหาร และออกกำลังกายอย่างจริงจัง";
		}else if(count>39.9){
			str="โรคอ้วนขั้นสูงสุด";
		}else{
			str="กรุณากรอกข้อมูลให้ถูกต้อง";
		}
		// TODO Auto-generated method stub
		AlertDialog.Builder oneButton = new AlertDialog.Builder(this);

		// Set Icon
		oneButton.setIcon(R.drawable.ico_fat);

		// Set Title
		oneButton.setTitle("ดัชนีมวลกายของคุณ");

		// Set Message
		oneButton.setMessage(" "+count+" : "+str);

		// Set Positive Button
		oneButton.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Intent to FirstActivity

					}
				});
		oneButton.show();

	} //showOneButton

	public static float round(float value, int places) {
		if (places < 0) throw new IllegalArgumentException();
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (float) tmp / factor;
	}

}//BMI