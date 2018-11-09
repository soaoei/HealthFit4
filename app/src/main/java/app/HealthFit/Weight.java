package app.HealthFit;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import app.HealthFit.fileconfixe.DatabaseFood;
import app.HealthFit.fileconfixe.DatabaseRegister;

public class Weight extends Activity {
    private DatabaseRegister namedata;
    private EditText  editetext1;
    private TextView text1_,settextwriat;

    private ArrayList<HashMap<String, String>> selectAllData_listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        text1_ = (TextView) findViewById(R.id.text1_);
        editetext1 = (EditText) findViewById(R.id.editetext1);
        settextwriat = (TextView) findViewById(R.id.settextwriat);
        namedata=new DatabaseRegister(this);


        String[] dataRegister  = namedata.SelectDataCode(Constants.idData);


        text1_.setText(dataRegister[8]);
         final double  total =  Double.parseDouble(dataRegister[8]) ;
        Button  btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editetext1.getText().toString().equals("")
                        ){

                    Toast.makeText(getApplicationContext(),"กรุณากรอกข้อมูลให้ครบ  ",Toast.LENGTH_SHORT).show();
                }else{
                    int dd=Integer.parseInt(editetext1.getText().toString())  ;
                    int ss=dd*18;
                    double  totalss =   total-373;
String ddddd="การลดน้ำหนักที่ปลอดภัย ท่านต้องใช้เวลา "+ss+" วัน "+" ปกติร่างกายคุณต้องการแคลลอรี่อยู่ที่ "+text1_.getText().toString()+" ถ้าคุณต้องการลดน้ำหนัก  "+dd+" กิโลกรัม "
        +" คุณต้องกินวันล่ะ ไม่เกิน "+totalss+" แคลลอรี่";
                    settextwriat.setText(ddddd);


                }

            }

        });


        Button  btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editetext1.setText(" ");
                settextwriat.setText(" ");

            }

        });
    }
}
