package app.HealthFit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import app.HealthFit.fileconfixe.DatabaseFood;
import app.HealthFit.fileconfixe.DatabaseRegister;


public class Calories_SWEET extends Activity {
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
//หน้าข้อมูลของหวาน
	private int[] image  = {
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,R.drawable.ico_cate2,
			R.drawable.ico_cate2,R.drawable.ico_cate2

	};

	private String[] text = {
			"กระทงทอง ไส้ไก่ ซอสขาว 3 ชิ้น","กระทงทองไส้ข้าวโพด 3 ชิ้น","กระท้อนทรงเครื่อง 1 ผล","กระยาสารท 1x3 นิ้ว","กล้วยคลุกมะพร้าว 1 ถ้วย",
			"กล้วยฉาบ 9 ชิ้น","กล้วยต้มจิ้มมะพร้าว 1 จาน(2ผล)","กล้วยน้ำว้าปิ้ง 1 ผล","กล้วยบวชชี 1 ถ้วย","กล้วยปิ้งชุบกะทิ 1 ผล",
			"กล้วยแขก 3 ชิ้น","กล้วยไข่เชื่อม 1 จาน(2ผล)","กะละแม 3 ห่อเล็ก","กะหรี่พัฟ 2 ชิ้น","กุ่ยช่าย(นึ่ง) 1 อัน",
			"ขนมกรวย 3 กรวย","ขนมกล้วย 2 ห่อ","ขนมขี้หนู 1 ถ้วย","ขนมครก 2 คู่","ขนมจีบ 3 ลูก",
			"ขนมชั้น 2 ชิ้น","ขนมตาล 2 กระทง","ขนมต้มขาว 4 ลูก","ขนมถั่วแปป 1 จาน(3ตัว)","ขนมถ้วย 2 ถ้วย",
			"ขนมน้ำดอกไม้ 1 จาน(9ชิ้น)","ขนมบ้าบิ่น 1 ชิ้น","ขนมปลากริมไข่เต่า 1 ถ้วย","ขนมปังกระเทียม 2 ชิ้น","ขนมปังขาไก่ 1 ชิ้น",
			"ขนมปังน้ำสลัดหมูหยอง 1 ชิ้น","ขนมปังปอนด์ 1 แผ่น","ขนมปังมะพร้าว 1 ชิ้น","ขนมปังสังขยา 1 ชิ้น","ขนมปังอบกรอบ 4 แผ่นเล็ก",
			"ขนมปังฮาวายเอี้ยน 1 ชิ้น","ขนมปังไส้กรอก 1 ชิ้น","ขนมปังไส้หมูหยอง 1 ชิ้น","ขนมปังไส้ไก่ 1 ชิ้น","ขนมฝักบัว 2 ชิ้น",
			"ขนมสอดไส้ 3 ห่อเล็ก","ขนมหม้อแกง 1 ชิ้น","ขนมเข่ง 1 กระทง","ขนมเทียน 2 อัน","ขนมเบื้องญวณ 1 แผ่น",
			"ขนมเบื้องไทยไส้หวาน 1 แผ่น","ขนมเบื้องไทยไส้เค็ม 1 แผ่น","ขนมเปียกปูน 1 ชิ้น","ขนมเปี๊ยะไส้ถั่ว 2 ชิ้น","ขนมเล็บมือนาง 1 จานเล็ก",
			"ขนมไหว้พระจันทร์ไส้ทุเรียนกวน 1 ชิ้น","ขนมไหว้พระจันทร์ไส้ลูกบัว-ไข่เค็ม 1 ชิ้น","ข้าวตังหน้าตั้ง 3 ชิ้น","ข้าวตังหมูหยอง 2 แผ่น","ข้าวต้มมัด 1 มัด",
			"ข้าวหลาม 1 กระบอก","ข้าวเกรียบกุ้ง 3 แผ่น","ข้าวเกรียบปากหม้อ 4 ชิ้น","ข้าวเม่าทอด 2 ลูก","ข้าวเหนียวกะทิทุเรียน 1 ถ้วย",
			"ข้าวเหนียวดำเปียก 1 ถ้วย","ข้าวเหนียวตัด 1 ชิ้น","ข้าวเหนียวมูลน้ำกะทิ 1 ชิ้นเล็ก","ข้าวเหนียวสังขยา 1 ห่อ","ข้าวเหนียวหน้ากุ้ง 1 ห่อ",
			"ข้าวแตน (ข้าวพองราดน้ำตาล) 1 แผ่น","ข้าวโพดคลุก 1 จานเล็ก","ข้าวโพดคั่ว (เคลือบน้ำตาล) 1 ถ้วย","ข้าวโพดต้ม 1 ฝักเล็ก","ครองแครง 22 ตัว",
			"ครองแครงกะทิ 1 ถ้วย","ครีมโรล 1 ชิ้น","คัสตาร์ดน้ำตาลไหม้ 1 ชิ้น","คุ้กกี้ข้าวโอ๊ต 2 ชิ้น","คุ้กกี้ชาเขียว 1 ชิ้น",
			"คุ้กกี้ช็อคโกแลตชิพ 2 ชิ้น","คุ้กกี้สิงคโปร์ 2 ชิ้น","คุ้กกี้เนย 2 ชิ้น","คุ้กกี้ไส้สับปะรด 1 ชิ้น","จาวตาลเชื่อม 1 ลูก",
			"ชิฟฟอนกาแฟ 1 ชิ้น","ชิฟฟอนคัสตาร์ดเค้ก 1 ชิ้น","ช็อคโกแลต 1 ชิ้นพอคำ","ซาลาเปาไส้หมู 1 ลูก","ซ่าหริ่ม 1 ถ้วย",
			"ตะโก้แห้ว 3 กระทงเล็ก","ถั่วลิสงต้ม 1 ช้อนโต๊ะ","ถั่วลิสงแผ่นทอด 1 แผ่น","ถั่วเขียวต้มน้ำตาล 1 ถ้วย","ถั่วแระต้ม 1 ช้อนโต๊ะ",
			"ทองม้วน 3 อันเล็ก","ทองหยิบ 2 ดอก","ทับทิมกรอบ 1 ถ้วย","ทุเรียนกวน 1 ช้อนโต๊ะ","ทุเรียนทอดกรอบ 7-8 ชิ้น",
			"ท๊อฟฟี่นม 1 เม็ด","บราวนี่ 1 ชิ้น","บะจ่าง 1 ลูก","บัวลอย 1 ถ้วย","บัวลอยน้ำขิง 1 ถ้วย",
			"บัวลอยเผือก 1 ถ้วย","บูลเบอร์รี่ชีสเค้ก 1 ชิ้น","ปอเปี๊ยะทอด 2 ชิ้น","ปอเปี๊ยะสด 1 ชิ้น","ปาท่องโก๋ 1 คู่กลาง",
			"ป๊อปคอร์น 1 ถ้วย","ฝอยทอง 1 แพ","พายกรอบ (โรยน้ำตาล) 2 ชิ้น","พายชีสบูลเบอร์รี่ 1 ชิ้น","พายทูน่า 1 ชิ้น",
			"พายสับปะรด 1 ชิ้น","พายเผือก 1 ชิ้น","พายไส้กรอก 1 ชิ้น","พายไส้แฮม 1 ชิ้น","พายไส้ไก่ 1 ชิ้น",
			"พิซซ่าขอบไส้กรอกชีส 1 ชิ้น","พิซซ่าทะเล 1 ชิ้น","พิซซ่าฮาวายเอี้ยน 1 ชิ้น","พิซซ่าไส้กรอก 1 ชิ้น","ฟรุตสลัด 1 ถ้วย",
			"ฟรุตเค้ก 1 ชิ้น","ฟรุ้ตบาร์ 1 ชิ้น","ฟักทองนึ่งโรยมะพร้าว 1 จานเล็ก","ฟักทองเชื่อม 1 จานเล็ก","ฟักทองแกงบวด 1 ถ้วย",
			"มะกอกทรงเครื่อง 5 ผล","มะกอกแช่อิ่ม 5 ผล","มะขามคลุก 6 เม็ด","มะดันแช่อิ่ม 1 ผล","มะม่วงน้ำปลาหวาน 5 ชิ้น",
			"มะยมหยี 5 เม็ด","มะยมเชื่อม 5 เม็ด","มันทอด 2 ชิ้น","มันฝรั่งแผ่นทอด (Chip) 6 ชิ้น","มันรังนก 2 ก้อน",
			"มันสำปะหลังปิ้งชุบกะทิ 1 ชิ้น","มันเทศเชื่อม 1 จานเล็ก","มันแกงบวด 1 ถ้วย","รวมมิตร 1 ถ้วย","ลอดช่องน้ำกะทิ 1 ถ้วย",
			"ลอดช่องสิงคโปร์ 1 ถ้วย","ลำใยในน้ำเชื่อม 1 ถ้วย","ลิ้นจี่ในน้ำเชื่อม 1 ถ้วย","ลูกชิ้นปิ้ง 1 ไม้","ลูกชุบ 3 ชิ้น",
			"ลูกตาลลอยแก้ว 1 ถ้วย","ลูกเดือยต้มน้ำตาล 1 ถ้วย","วุ้นกะทิ 1 ชิ้น","วุ้นมะพร้าวอ่อน 1 ชิ้น","สังขยา 1 ชิ้นเล็ก",
			"สังขยาฟักทอง 1 ชิ้นเล็ก","สังขยาเผือก 1 ชิ้นเล็ก","สาคูบัวลอย 1 ถ้วย","สาคูเปียกรวมมิตร 1 ถ้วย","สาคูไส้หมู 4 ลูก",
			"สาลี่ 1 ชิ้น","สาเกเชื่อมราดกะทิ 1 ชิ้น","หมูปิ้ง 2 ไม้","หมูสะเต๊ะ 2 ไม้","อัพไซด์ดาวน์เค้ก 1 ชิ้น",
			"อัลมอนต์อบเกลือ 1 ช้อนโต๊ะ","อาลัว 4 ชิ้น","เกี๊ยวกรอบ 3 ชิ้น","เกี๊ยวซ่า 3 ชิ้น","เค้กกล้วยตาก 1 ชิ้น",
			"เค้กกล้วยหอม 1 ชิ้น","เค้กช็อคโกแลต 1 ชิ้น","เค้กเนย 1 ชิ้น","เค้กเนยแต่งหน้า 1 ชิ้น","เค้กใบเตย 1 ชิ้น",
			"เฉาก๊วย 1 ถ้วย","เดนิสแฮม 1 ชิ้น","เต้าส่วน 1 ถ้วย","เต้าหู้ทอด 3 ชิ้น","เต้าหู้นมสด 1 ถ้วย",
			"เต้าฮวยน้ำขิง 1 ถ้วย","เต้าฮวยฟรุตสลัด 1 ถ้วย","เผือกน้ำกะทิ 1 ถ้วย","เผือกสอดไส้ทอด 1 ชิ้น","เผือกเชื่อม 1 จานเล็ก",
			"เฟรนฟรายด์ (French Fried) 6 ชิ้น","เมล็ดทานตะวันอบกรอบ 1 ช้อนโต๊ะ","เมล็ดฟักทองอบกรอบ 1 ช้อนโต๊ะ","เมล็ดแตงโมแห้ง 1 ช้อนโต๊ะ","เมี่ยงก๋วยเตี๋ยว 3 คำ",
			"เมี่ยงคะน้า 3 คำ","เมี่ยงคำ 3 คำ","เม็ดขนุน 5 เม็ด","เม็ดมะม่วงหิมพานต์อบเนย 8-10 เม็ด","เยลลี่ถ้วย 2 ถ้วย",
			"เอแคร์ไส้ครีม 1 ชิ้น","แซนวิชทูน่า 1 คู่","แซนวิชแฮม ชีส 1 คู่","แซนวิชไก่ 1 คู่","แบล็กฟลอเรสต์เค้ก 1 ชิ้น",
			"แมงลักน้ำกะทิ 1 ถ้วย","แยมโรล 1 ชิ้น","แหนมสด ข้าวทอด 1 จาน","แฮมเบอร์เกอร์ชีส ไก่ 1 ชิ้น","แฮมเบอร์เกอร์หมู 1 ชิ้น",
			"โก๋แก่รสต่าง ๆ 15 เม็ด","โดนัท แยม น้ำตาล 1 ชิ้น","โดนัทยีสต์ 1 ชิ้น","โรตี (ใส่นมข้น+น้ำตาล+ใส่ไข่)","โรตีสายไหม 1 อัน",
			"ไก่ทอด 1 น่อง","ไก่ย่าง 1 น่อง","ไข่นกกระทา 11 ใบ","ไข่หงส์ 3 ใบ","ไส้กรอกทอด 1 ชิ้น",
			"ไส้กรอกอีสาน 1 อัน","ไอศกรีมกะทิ 2 ก้อน","ไอศกรีมกาแฟ 1 ก้อน","ไอศกรีมชอกโกแล็ต 1 ก้อน","ไอศกรีมวนิลลา 1 ก้อน",
			"ไอศกรีมสตรอเบอรี่ 1 ก้อน","ไอศกรีมเรซิน 1 ก้อน"


	};

	private String[] text2 ={
			"280","215","205","210","100",
			"200","180","90","230","145",
			"255","177","195","380","140",
			"190","240","165","210","120",
			"184","115","165","43","265",
			"190","130","250","170","65",
			"230","80","235","230","80",
			"300","130","185","223","140",
			"380","179","120","205","280",
			"60","50","95","300","27",
			"340","375","280","160","285",
			"230","110","205","418","225",
			"205","210","197","370","179",
			"150","156","60","200","425",
			"250","360","230","150","150",
			"235","190","210","190","190",
			"275","340","170","120","275",
			"235","45","150","160","25",
			"105","210","250","115","50",
			"20","340","300","223","160",
			"300","285","315","175","270",
			"65","146","235","350","280",
			"505","425","400","400","405",
			"340","335","345","290","180",
			"400","305","188","167","185",
			"165","135","10","60","165",
			"135","135","248","80","95",
			"165","230","184","230","210",
			"215","180","110","165","170",
			"180","140","215","80","204",
			"288","222","162","170","205",
			"116","235","150","230","395",
			"45","145","235","190","305",
			"370","275","255","405","250",
			"90","385","215","260","150",
			"130","150","250","260","220",
			"220","45","55","45","60",
			"60","90","174","110","80",
			"225","180","290","240","470",
			"112","310","290","280","245",
			"55","270","250","590","145",
			"345","165","191","174","280",
			"90","215","142","110","140",
			"110","264"


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
		if (extras != null) {
			user_accout_id = extras.getString("id");

		}
		dataname_ =dataname.SelectDataCode(user_accout_id);

		TextView  nameTitle = (TextView) findViewById(R.id.textView1);
		nameTitle.setText("เลือกของหวานที่บริโภค");

		edittext = (EditText) findViewById(R.id.EditText01);
		listview = (ListView) findViewById(R.id.ListView01);
		listview.setAdapter(new MyCustomAdapter(text, image,text2));

		edittext.addTextChangedListener(new TextWatcher()
		{

			public void afterTextChanged(Editable s)
			{

			}

			public void beforeTextChanged(CharSequence s, int start,
										  int count, int after)
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
						if (edittext.getText().toString().equalsIgnoreCase((String) text[i].subSequence(0, textlength))){

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

		MyCustomAdapter(String[] text, int[] image,String[] text2)
		{

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


		final AlertDialog.Builder alertDialogs = new AlertDialog.Builder(Calories_SWEET.this);
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
		alertDialogs.setView(convertView);


		Button button_Submit = (Button) convertView.findViewById(R.id.Submit);
		Button button_Cancle = (Button) convertView.findViewById(R.id.Cancle);

		button_Submit.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Calendar  cal_Tomorrow= Calendar.getInstance();
				SimpleDateFormat formats = new SimpleDateFormat("yyyy/MM/dd, EEEE");
				String strdate=formats.format(cal_Tomorrow.getTime());

				int foo = Integer.parseInt(text2[count])*count_number;

				foodData.InsertData(null, 		Database_File6.Code_Id, text[count], text2[count], Integer.toString(foo), Integer.toString(count_number), " ",strdate, dataname_[8], " ");
				//Toast.makeText(getApplicationContext(),"บันทึกข้อมูลเรียบร้อย ครับ/ค่ะ"+dataname_[8] ,Toast.LENGTH_SHORT).show();
				convertView.getRootView().setVisibility(View.GONE);
			}
		});

		button_Cancle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				convertView.getRootView().setVisibility(View.GONE);
			}

		});
		alertDialogs.show();

	}
}