package app.HealthFit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Health_Tips_DB extends SQLiteOpenHelper {

    private static final String DB_NAME = "HealthTips";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME1 = "Tips01";
    public static final String TABLE_NAME2 = "Tips02";
    public static final String TABLE_NAME3 = "Tips03";
    public static final String TABLE_NAME4 = "Tips04";


    public static final String COL_ID = "ID";
    public static final String COL_Name = "Name";
    public static final String COL_Detail1 = "Detail1";
    public static final String COL_Detail2 = "Detail2";

    public Health_Tips_DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) { }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }
}
