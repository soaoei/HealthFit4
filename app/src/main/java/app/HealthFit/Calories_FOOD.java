package app.HealthFit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import app.HealthFit.fileconfixe.DatabaseFood;
import app.HealthFit.fileconfixe.DatabaseRegister;


public class Calories_FOOD extends Activity {
	private  DatabaseRegister dataname;
	private String user_accout_id;
	private DatabaseFood foodData;
	private Typeface mTypeface;
	private Button buttoncancle;
	private EditText edittext;
	private ListView listview;
	private int number = 0;
	private int count_number = 1;
	private int count=0;
	private String[] dataname_ ;

	private int[] image  = {
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,R.drawable.ico_cate1,
			R.drawable.ico_cate1,R.drawable.ico_cate1

	};

	private String[] text = {

			"กระเพาะปลา 1 ชาม","กระเพาะปลาตุ๋นน้ำแดง 1 ถ้วย","กุนเชียงทอด 1 คู่เล็ก","กุ้งทอดกระเทียมพริกไทย 3 ตัวกลาง","กุ้งนางนึ่งนมสด 1 ถ้วย",
			"กุ้งผัดพริกอ่อน 1 จาน","กุ้งอบวุ้นเส้น 1 จาน","ก๋วยจั๊บ 1 ชาม","ก๋วยจั๊บญวณ 1 ถ้วย","ก๋วยเตี๋ยวคั่วไก่ 1 จาน",
			"ก๋วยเตี๋ยวต้มยำกุ้ง 1 ถ้วย","ก๋วยเตี๋ยวผัดกระเพราไก่ 1 จาน","ก๋วยเตี๋ยวผัดไทยกุ้งสดใส่ไข่ 1 จาน","ก๋วยเตี๋ยวราดหน้าปลากระพง 1 จาน","ก๋วยเตี๋ยวหลอด 1 จาน",
			"ก๋วยเตี๋ยวเนื้อสับ 1 จาน","ก๋วยเตี๋ยวเนื้อเรียง 1 ถ้วย","ก๋วยเตี๋ยวเรือน้ำตกน้ำ 1 ถ้วย","ก๋วยเตี๋ยวเรือน้ำตกแห้ง 1 ถ้วย","ก๋วยเตี๋ยวเส้นปลา น้ำ 1 ชาม",
			"ก๋วยเตี๋ยวเส้นปลา แห้ง 1 ชาม","ก๋วยเตี๋ยวเส้นเล็กต้มยำหมู 1 ชาม","ก๋วยเตี๋ยวเส้นเล็กหมูแห้ง 1 ชาม","ก๋วยเตี๋ยวเส้นใหญ่ผัดซีอิ๊วใส่ไข่ 1 จาน","ก๋วยเตี๋ยวเส้นใหญ่ราดหน้าหมู 1 จาน",
			"ก๋วยเตี๋ยวแขก 1 ถ้วย","ขนมจีน (50 กรัม) 1 จับ","ขนมจีน 2 ทัพพี","ขนมจีนซาวน้ำ 1 จาน","ขนมจีนน้ำพริก 1 จาน",
			"ขนมจีนน้ำยา 1 จาน","ขนมจีนน้ำเงี้ยว 1 ถ้วย","ขนมหัวผักกาดผัด 1 จาน","ขนมหัวผักกาดผัด ใส่ไข่ 1 จาน","ข้าว สตูว์ไก่ 1 จาน",
			"ข้าวกุ้งทอดกระเทียมพริกไทย 1 จาน","ข้าวขาหมู 1 จาน","ข้าวคลุกกะปิ 1 จาน","ข้าวซอยไก่, หมู 1 ถ้วย","ข้าวญี่ปุ่น 3 ช้อนโต๊ะ 70 กรัม 1 ทัพพี",
			"ข้าวต้ม(ข้าวกล้อง) 1 ถ้วย","ข้าวต้ม(ข้าวขาว) 1 ถ้วย","ข้าวปุ้น (ส้มตำ - ขนมจีน) 1 จาน","ข้าวผัดกระเพรากุ้ง 1 จาน","ข้าวผัดกระเพราหมู 1 จาน",
			"ข้าวผัดกระเพราไก่ไข่ดาว 1 จาน","ข้าวผัดกุนเชียง 1 จาน","ข้าวผัดกุ้งใส่ไข่ 1 จาน","ข้าวผัดคะน้าหมูกรอบ 1 จาน","ข้าวผัดต้มยำทะเลแห้ง 1 จาน",
			"ข้าวผัดน้ำพริกกุ้งสด 1 จาน","ข้าวผัดน้ำพริกลงเรือ 1 จาน","ข้าวผัดปลาหมึกน้ำพริกเผา 1 จาน","ข้าวผัดปลาเค็ม 1 จาน","ข้าวผัดปูใส่ไข่ 1 จาน",
			"ข้าวผัดผักกระเฉดหมูกรอบ 1 จาน","ข้าวผัดมันกุ้งใส่ไข่ 1 จาน","ข้าวผัดสับปะรด 1 จาน","ข้าวผัดหนำเลียบ-หมู-ไข่ 1 จาน","ข้าวผัดหมูน้ำพริกเผา 1 จาน",
			"ข้าวผัดหมูใส่ไข่ 1 จาน","ข้าวผัดอเมริกัน 1 จาน","ข้าวผัดแกงเขียวหวานไก่ 1 จาน","ข้าวผัดแหนม 1 จาน","ข้าวผัดไส้กรอก 1 จาน",
			"ข้าวมันส้มตำ เนื้อผัดหวาน 1 จาน","ข้าวมันไก่ 1 จาน","ข้าวมันไก่ทอด 1 จาน","ข้าวยำปักษ์ใต้ 1 จาน","ข้าวราดหน้าไก่ 1 จาน",
			"ข้าวสวย(ข้าวกล้อง) 3 ทัพพี","ข้าวสวย(ข้าวขาว) 3 ทัพพี","ข้าวหน้ากุ้งผัดพริดสด 1 จาน","ข้าวหน้าเป็ด 1 จาน","ข้าวหมกไก่ 1 จาน",
			"ข้าวหมูกระเทียม 1 จาน","ข้าวหมูแดง 1 จาน","ข้าวอบเผือก 1 จาน","ข้าวเหนียวนึ่ง 1-2 ทัพพี","ข้าวเหนียวหมูทอด 1 ชุด",
			"ข้าวเหนียวหมูสวรรค์ 1 ชุด","ข้าวแช่ 1 ชุด","ข้าวไก่อบ 1 จาน","ข้าวไข่เจียว 1 จาน","ครีมซุปไก่ 1 ถ้วย",
			"คอหมูย่าง 1 จาน","คะน้าหมูกรอบ 1 จาน","ซุปข้าวโพด 1 ถ้วย","ซุปหน่อไม้ 1 จาน","ซุปใส (ผัก) 1 ถ้วย",
			"ตับไก่ปิ้ง 1 ไม้","ต้มกะทิสายบัว ปลาทูนึ่ง 1 ถ้วย","ต้มข่าไก่ 1 ถ้วย","ต้มจับฉ่าย 1 ถ้วย","ต้มตือฮวน 1 ถ้วย",
			"ต้มผักกาดดอง ซี่โครงหมู 1 ถ้วย","ต้มยำกุ้ง 1 ถ้วย","ต้มยำปลากระป๋อง 1 ถ้วย","ต้มยำปลากระพง 1 ถ้วย","ต้มยำเห็ดสด 1 ถ้วย",
			"ต้มยำไก่-ใส่เห็ด 1 ถ้วย","ต้มส้มปลาทู 1 ถ้วย","ต้มหัวผักกาดขาว ซี่โครงหมู 1 ถ้วย","ต้มเลือดหมู","ต้มโคล้งปลากรอบ 1 ถ้วย",
			"ต้มโคล้งไก่ย่าง 1 ถ้วย","ทอดมันกุ้ง 1 จาน","ทอดมันปลากราย 1 ชิ้น","น้ำพริกกะปิผักสด 2 ช้อนโต๊ะ","น้ำพริกปลาป่น 1 ถ้วย",
			"น้ำพริกมะขามสด 1 ถ้วย","น้ำพริกมะขามเปียก 1 ถ้วย","น้ำพริกมะม่วง 1 ถ้วย","น้ำพริกลงเรือ 1 ถ้วย","น้ำพริกหนุ่ม 2 ช้อนโต๊ะ",
			"น้ำพริกอ่อง 2 ช้อนโต๊ะ","บะหมี่กรอบราดหน้า 1 จาน","บะหมี่กรอบราดหน้า รวมมิตร 1 จาน","บะหมี่กรอบราดหน้า ไก่ หน่อไม้ 1 จาน","บะหมี่กึ่งสำเร็จรูปผัดกระเพราหมู 1 จาน",
			"บะหมี่กึ่งสำเร็จรูปผัดขี้เมา 1 จาน","บะหมี่น่องไก่-น้ำ 1 ชาม","บะหมี่น้ำต้มยำ หมู 1 ถ้วย","บะหมี่เกี๊ยวหมูแดง-น้ำ 1 ชาม","บะหมี่เกี๊ยวเป็ดย่าง 1 ถ้วย",
			"บะหมี่เป็ดน้ำ 1 ถ้วย","บะหมี่แห้ง หมูแดง 1 จาน","บาร์บีคิวซี่โครงหมู ข้าวคลุกเนย 1 ชุด","ปลากระพงนึ่งมะนาว 1 ชิ้นกลาง","ปลาชุบขนมปังทอด สลัดผัก 1 จาน",
			"ปลาช่อนอบเกลือ 1 ตัว","ปลาซาบะย่าง 1 ตัว","ปลาดุกย่าง น้ำปลามะนาว 1 ตัวเล็ก","ปลาทอดสามรส 1 ตัวกลาง","ปลาทูทอด 1 ตัวกลาง",
			"ปลาราดซอสมะนาว มันฝรั่งทอด 1 จาน","ปลาราดพริก 1 จาน","ปลาร้าทรงเครื่อง 1 ถ้วย","ปลาร้าสับ 1 ถ้วย","ปลาสลิดทอด 1 ตัว",
			"ปลาสำลีแดดเดียว ยำมะม่วง ครึ่งตัวเล็ก","ปลาหมึกนึ่งมะนาว 1 ตัว","ปลาหมึกผัดฉ่า 1 ถ้วย","ปลาอินทรีย์เค็มทอด 1 จาน","ปลาเล็กปลาน้อยทอดกรอบ 1 ช้อนโต๊ะ",
			"ปลาแซลมอนย่าง 1 จาน","ปีกไก่สอดไส้ทอด 3 ชุด","ผัดกะหล่ำปลี หมู กุ้ง 1 จาน","ผัดคะน้าปลาเค็ม 1 จาน","ผัดดอกกะหล่ำกับกุ้ง 1 จาน",
			"ผัดดอกกุ่ยช่ายกับตับ 1 จาน","ผัดถั่วงอกกับเต้าหู้ 1 จาน","ผัดถั่วลันเตากับกุ้ง 1 จาน","ผัดบร็อกโคลี่กับกุ้ง 1 จาน","ผัดบวบใส่ไข่ 1 จาน",
			"ผัดผักกระเฉดน้ำมันหอย 1 จาน","ผัดผักกาดขาวหมู วุ้นเส้น 1 จาน","ผัดผักกาดดองใส่ไข่ 1 จาน","ผัดผักบุ้งไฟแดง 1 จาน","ผัดผักรวมกับหมู 1 จาน",
			"ผัดพริกขิงกุ้งกับถั่วฝักยาว 1 ถ้วย","ผัดพริกขิงหมูกับถั่วฝักยาว 1 จาน","ผัดพริกแกงหมูกับหน่อไม้ 1 ถ้วย","ผัดฟักทองใส่ไข่ 1 จาน","ผัดมะเขือยาวหมูสับ 1 จาน",
			"ผัดยอดมะระน้ำมันหอย 1 จาน","ผัดวุ้นเส้นใส่ไข่ 1 จาน","ผัดสะตอกับหมู กุ้ง 1 จาน","ผัดหน่อไม้กับไข่ 1 จาน","ผัดหน่อไม้ฝรั่งกับกุ้ง 1 จาน",
			"ผัดเปรี้ยวหวานไก่ 1 จาน","ผัดเผ็ดปลาดุก 1 ถ้วย","ผัดเผ็ดปลาทอดกรอบ 1 ถ้วย","ผัดเผ็ดหมูกับมะเขือ 1 จาน","ผัดไชโป๊วใส่ไข่ 1 จาน",
			"ผัดไทยไข่ห่อ 1 จาน","ผัดไทยไร้เส้น 1 จาน","พอร์คชอปทอด ผักผัดเนย 1 จาน","พะแนงไก่ 1 ถ้วย","ฟักตุ๋นไก่มะนาวดอง 1 ถ้วย",
			"มักกะโรนีขี้เมาไก่ 1 จาน","มักกะโรนีผัดกุ้ง 1 จาน","ยากิโซบะ 1 จาน","ยำกุนเชียง 1 จาน","ยำขนมจีน 1 จาน",
			"ยำถั่วพู 1 จาน","ยำบะหมี่กึ่งสำเร็จรูป 1 จาน","ยำปลากระป๋อง 1 ถ้วย","ยำปลาดุกฟู 1 จาน","ยำผักกะเฉด 1 จาน",
			"ยำผักกาดดอง","ยำผักบุ้งทอดกรอบ 1 จาน","ยำมะเขือยาว 1 จาน","ยำรวมมิตรทะเล 1 จาน","ยำวุ้นเส้น 1 จาน",
			"ยำหนังหมู 1 จาน","ยำหมูย่าง 1 จาน","ยำเนื้อย่าง 1 จาน","ยำไข่ต้ม 1 ฟอง","ยำไส้กรอก 1 จาน",
			"ลาบไก่ 1 จาน","ลูกชิ้นทอด 6 ลูก","วุ้นเส้นผัดไทย กุ้งสด 1 จาน","สปาเกตตี้กระเพรากุ้ง 1 จาน","สปาเก็ตตี้ไก่อบ 1 จาน",
			"สลัดผัก 1 จาน","สลัดเนื้อสันในทอด 1 จาน","สลัดแขก 1 จาน","สุกียากี้แห้งทะเล 1 ถ้วย","สุกี้ยากี้ไก่-น้ำ 1 ชาม",
			"สเต็กปลาย่าง 1 จาน","สเต็กหมู ผักสดคลุก 1 จาน","สเต็กหมู สลัดผักสด 1 จาน","สเต็กไก่ทอด มันบด 1 จาน","ส้มตำปู 1 จาน",
			"ส้มตำไทย 1 จาน","หมี่กรอบราดหน้าหมู 1 จาน","หมี่กะทิ 1 จาน","หมี่ซั่วผัด 1 จาน","หมูย่างเกาหลี 1 ชุด",
			"หมูกรอบ 1 จาน","หมูกะทะ 1 ชุด","หมูคลุกเกร็ดขนมปังทอด ซอส 1 ชุด","หมูจุ่ม 1 ชุด","หมูทอดกระเทียมพริกไทย 3x5 นิ้ว",
			"หมูทอดเนย สลัดน้ำใส 1 จาน","หมูน้ำตก 1 จาน","หมูผัดขิง 1 จาน","หมูฝอย 2 ช้อนโต๊ะ","หมูยอชุบแป้งทอด 2 ชิ้น",
			"หมูหยอง 2 ช้อนโต๊ะ","หมูแผ่น 1 แผ่นกลาง","หลนปูเค็ม ผักสด 1 ถ้วย","หอยแมลงภู่ทอด 1 จาน","หอยแมลงภู่อบหม้อดิน 4-5 ตัว",
			"เกาเหลาลูกชิ้นน้ำใส 1 ถ้วย","เกี๊ยวกรอบราดหน้ากุ้ง 1 จาน","เกี๊ยวน้ำกุ้ง 1 ชาม","เกี๊ยวปลาน้ำ 1 ถ้วย","เครื่องในไก่ผัดขิง 1 จาน",
			"เทมปุระ 3 ชิ้น","เนื้อน้ำตก 1 จาน","เนื้อเค็มทอด 3x5 นิ้ว","เป็ดตุ๋น มะนาวดอง 1 ถ้วย","เป็ดพะโล้ 1 ถ้วย",
			"เฝอ 1 ถ้วย","เย็นตาโฟน้ำ 1 ชาม","เส้นจันท์ผัดปู 1 จาน","เส้นหมี่ลูกชิ้นน้ำใส 1 ชาม","เส้นหมี่ลูกชิ้นหมูแห้ง 1 ถ้วย",
			"เส้นใหญ่ผัดขี้เมา","แกงกะหรี่หมู 1 ถ้วย","แกงกะหรี่ไก่ 1 ถ้วย","แกงขี้เหล็ก 1 ถ้วย","แกงขี้เหล็กหมูย่าง 1 ถ้วย",
			"แกงจืดตำลึงหมูสับ 1 ถ้วย","แกงจืดถั่วงอกหมูสับ 1 ถ้วย","แกงจืดฟักยัดไส้ 1 ถ้วย","แกงจืดมะระยัดไส้ 1 ถ้วย","แกงจืดวุ้นเส้น 1 ถ้วย",
			"แกงจืดเต้าหู้ยัดไส้ 1 ถ้วย","แกงจืดเต้าหู้หมูสับ 1 ถ้วย","แกงจืดไข่เจียว 1 ถ้วย (ไข่ 1 ฟอง)","แกงป่าไก่ 1 ถ้วย","แกงมัสมั่นไก่ 1 ถ้วย",
			"แกงส้มชะอมชุบไข่ทอดกับกุ้ง 1 ถ้วย","แกงส้มดอกแคกับกุ้ง 1 ถ้วย","แกงส้มปลาแปะซะ 1 ถ้วย","แกงส้มผักกะเฉด-ปลา 1 ชาม","แกงส้มผักบุ้ง ปลาช่อน 1 ถ้วย",
			"แกงส้มผักรวม 1 ถ้วย","แกงส้มผักรวมกุ้ง 1 ถ้วย","แกงหมูเทโพ 1 ถ้วย","แกงเขียวหวานปลาดุก 1 ถ้วย","แกงเขียวหวานลูกชิ้นปลากราย 1 ถ้วย",
			"แกงเขียวหวานหมู 1 ถ้วย","แกงเขียวหวานไก่ 1 ถ้วย","แกงเผ็ดฟักทอง ใส่หมู 1 ถ้วย","แกงเผ็ดลูกชิ้นปลา 1 ถ้วย","แกงเผ็ดหมูยอดมะพร้าว 1 ถ้วย",
			"แกงเผ็ดเป็ดย่าง 1 ถ้วย","แกงเผ็ดไก่ใส่มะเขือ 1 ถ้วย","แกงเผ็ดไก่ใส่หน่อไม้ 1 ถ้วย","แกงเลียง 1 ชาม","แกงเหลืองมะละกอกับกุ้ง 1 ถ้วย",
			"แกงเหลืองหน่อไม้ดองกับปลา 1 ถ้วย","แกงไตปลา 1 ถ้วย","แคบหมู มีมัน 5 ชิ้นเล็ก","แคบหมูไร้มัน 5 ชิ้นเล็ก","แจ่วบอง 1 ถ้วย",
			"แหนมสด 1 จาน","โกยซีหมี่ 1 จาน","โจ๊กหมู 1 ถ้วย","โจ๊กหมู ตับ ไข่ลวก 1 ถ้วย","โรตีแกงเนื้อ, หมู 1 ชุด",
			"ไก่ตุ๋นมะนาวดอง 1 ถ้วย","ไก่ทอด 1 น่อง","ไก่ผัดขิง 1 จาน","ไก่ย่าง 1 น่อง","ไข่ดาว 1 ฟอง",
			"ไข่ดาวทรงเครื่อง 1 จาน","ไข่ตุ๋น 1 ฟอง","ไข่ต้ม น้ำปลามะนาว 1 ฟอง","ไข่พะโล้ 1 ถ้วย","ไข่ยัดไส้ 1 จาน",
			"ไข่ลวก 1 ฟอง","ไข่ลูกเขย 1 ฟอง","ไข่เค็ม 1 ฟอง","ไข่เจียว 1 ฟอง","ไข่เจียวหมูสับ 1 ฟอง",
			"ไส้กรอกเนื้อลูกวัวอบ สลัดผัก 1 จาน","ไส้อั่ว 4 ชิ้นพอคำ"

	};

	private String[] text2 ={

			"150","225","240","259","185",
			"235","300","240","235","435",
			"320","440","545","435","225",
			"370","370","180","225","375",
			"420","335","330","520","405",
			"380","50","160","320","450",
			"375","305","560","630","465",
			"495","690","410","395","118",
			"120","120","180","540","580",
			"630","590","595","670","400",
			"460","605","535","405","610",
			"600","575","335","370","665",
			"660","790","630","610","520",
			"590","585","695","180","400",
			"240","240","540","495","540",
			"525","560","385","80","440",
			"480","350","490","445","160",
			"200","420","140","40","15",
			"60","225","210","180","160",
			"90","65","55","80","30",
			"80","130","90","120","60",
			"115","255","230","55","35",
			"210","55","100","195","35",
			"160","515","690","660","540",
			"530","375","300","305","415",
			"370","345","340","155","595",
			"220","220","165","470","280",
			"560","300","155","35","190",
			"415","75","260","115","80",
			"260","310","230","200","210",
			"210","155","190","210","210",
			"185","230","205","210","210",
			"245","265","200","255","210",
			"185","265","200","200","230",
			"215","200","290","250","125",
			"565","350","545","230","125",
			"520","420","400","220","220",
			"185","215","55","275","115",
			"35","310","115","150","120",
			"220","165","165","105","110",
			"125","210","520","485","430",
			"240","490","230","280","345",
			"260","505","375","615","35",
			"55","690","405","395","405",
			"560","375","645","375","245",
			"635","165","275","135","250",
			"75","120","205","605","85",
			"225","635","275","165","200",
			"250","165","280","110","110",
			"240","290","575","225","430",
			"550","325","450","195","245",
			"90","50","90","90","115",
			"110"," 80","220","130","325",
			"270","105","160","110","105",
			"120","105","300","235","240",
			"235","240","250","240","245",
			"240","235","245","115"," 80",
			"80","50","65","50","25",
			"175","550","160","230","675",
			"110","345","210","165","165",
			"250","75","75","180","310",
			"75","205","75","200","250",
			"465","240"

	};

	int textlength = 0;

	ArrayList<String> text_sort = new ArrayList<String>();
	ArrayList<Integer> image_sort = new ArrayList<Integer>();
	ArrayList<String> text_sort2 = new ArrayList<String>();
	public void onCreate(Bundle savedInstanceState)

	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_calories_burn);
		foodData=new DatabaseFood(this);
		dataname=new DatabaseRegister(this);
		Bundle extras = getIntent().getExtras();

		if (extras != null)
		{
			user_accout_id = extras.getString("id");

		}


		dataname_ =dataname.SelectDataCode(user_accout_id);

		TextView  nameTitle = (TextView) findViewById(R.id.textView1);
		nameTitle.setText("เลือกอาหารที่บริโภค");

		edittext = (EditText) findViewById(R.id.EditText01);
		listview = (ListView) findViewById(R.id.ListView01);
		listview.setAdapter(new MyCustomAdapter(text, image,text2));

		edittext.addTextChangedListener(new TextWatcher()
		{

			public void afterTextChanged(Editable s)
			{

			}

			public void beforeTextChanged(CharSequence s, int start,int count, int after)
			{

			}

			public void onTextChanged(CharSequence s, int start, int before, int count)
			{

				textlength = edittext.getText().length();
				text_sort.clear();
				image_sort.clear();
				text_sort2.clear();

				for (int i = 0; i < text.length; i++)
				{
					if (textlength <= text[i].length())
					{
						if (edittext.getText().toString().equalsIgnoreCase((String) text[i].subSequence(0, textlength)))
						{
							text_sort.add(text[i]);
							image_sort.add(image[i]);
							text_sort2.add(text2[i]);
							number = 1;
						}
					}
				}

				listview.setAdapter(new MyCustomAdapter(text_sort, image_sort,text_sort2));

			}
		});


		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

				if (number == 1) {
					for(int g=0;g<text.length;g++){
						if(text[g].equals(text_sort.get(position))){
							count=g;
							alertFormElements();
						}
					}

				} else {
					for(int g=0;g<text.length;g++){
						if(text[g].equals(text[position])){
							count=g;
							alertFormElements();
						}
					}

				}

			}
		});
	}

	class MyCustomAdapter extends BaseAdapter
	{

		String[] data_text;
		int[] data_image;
		String[] data_text2;
		MyCustomAdapter(){}

		MyCustomAdapter(String[] text, int[] image,String[] text2){

			data_text = text;
			data_image = image;
			data_text2 = text2;
		}

		MyCustomAdapter(ArrayList<String> text, ArrayList<Integer> image,ArrayList<String> text2)
		{

			data_text = new String[text.size()];
			data_image = new int[image.size()];
			data_text2 = new String[text2.size()];

			for(int i=0;i<text.size();i++)
			{
				data_text[i] = text.get(i);
				data_image[i] = image.get(i);
				data_text2[i] = text2.get(i);
			}

		}

		public int getCount()
		{
			return data_text.length;
		}

		public String getItem(int position)
		{
			return null;
		}

		public long getItemId(int position)
		{
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent)
		{

			LayoutInflater inflater = getLayoutInflater();
			View row;

			row = inflater.inflate(R.layout.listview_calories1_burn1, parent, false);
			mTypeface = Typeface.createFromAsset(getBaseContext().getAssets(),"fonts/TH_Mali_Grade6_Bold.ttf");
			TextView textview = (TextView) row.findViewById(R.id.listview_item_title_medium);
			ImageView imageview = (ImageView) row.findViewById(R.id.listview_item_image);
			TextView textview2 = (TextView) row.findViewById(R.id.listview_item_title_small);


			textview.setText(data_text[position]);
			imageview.setImageResource(data_image[position]);
			textview2.setText(data_text2[position]+" กิโลแคลอรี่");

			return (row);

		}
	}
	protected void showOneButton() {

		// TODO Auto-generated method stub
		AlertDialog.Builder oneButton = new AlertDialog.Builder(this);

		// Set Icon
		oneButton.setIcon(image[count]);

		// Set Title
		oneButton.setTitle("แคลอรี่ในอาหาร");

		// Set Message
		oneButton.setMessage(" แคลอรี่ในอาหาร :"+text[count]+" : "+text2[count]);

		// Set Positive Button
		oneButton.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Intent to FirstActivity

					}
				});
		oneButton.show();

	}

	public void alertFormElements() {





		final AlertDialog.Builder   alertDialogs = new AlertDialog.Builder(Calories_FOOD.this);
		LayoutInflater inflatersss = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View convertView = (View) inflatersss.inflate(R.layout.witzand2_searchlistview, null);
		ImageView imageView = (ImageView) convertView.findViewById(R.id.list_images);
		TextView type_name = (TextView) convertView.findViewById(R.id.textViewName);
		TextView textViewName = (TextView) convertView.findViewById(R.id.textViewLastName);

		imageView.setBackgroundResource(image[count]);
		type_name.setText(text[count]);
		textViewName.setText(text2[count]+" กิโลแคลอรี่");
		final TextView textViewnumber = (TextView) convertView.findViewById(R.id.textViewnumber);
		ImageButton bntButton1 = (ImageButton) convertView.findViewById(R.id.imageButton1);
		ImageButton bntButton2 = (ImageButton) convertView.findViewById(R.id.ImageButton01s);

		bntButton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count_number<100){
					count_number++;
					textViewnumber.setText(Integer.toString(count_number));
				}

			}
		});
		bntButton2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count_number>1){
					count_number--;
					textViewnumber.setText(Integer.toString(count_number));
				}
			}
		});



		Button button_Submit = (Button) convertView.findViewById(R.id.Submit);
		Button button_Cancle = (Button) convertView.findViewById(R.id.Cancle);

		button_Submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Calendar  cal_Tomorrow= Calendar.getInstance();
				SimpleDateFormat formats = new SimpleDateFormat("yyyy/MM/dd, EEEE");
				String strdate=formats.format(cal_Tomorrow.getTime());
				int foo = Integer.parseInt(text2[count])*count_number;

				foodData.InsertData(null,  Database_File6.Code_Id, text[count], text2[count], Integer.toString(foo), Integer.toString(count_number), " ",strdate, dataname_[8], " ");
			 //  Toast.makeText(getApplicationContext(),"บันทึกข้อมูลเรียบร้อย ครับ/ค่ะ"+dataname_[8] ,Toast.LENGTH_SHORT).show();

				convertView.getRootView().setVisibility(View.GONE);
			}
		});

		button_Cancle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				convertView.getRootView().setVisibility(View.GONE);
			}

		});

		alertDialogs.setView(convertView);
		alertDialogs.show();
		try {

		}
		catch (WindowManager.BadTokenException e) {
			//use a log message
		}


	}
}