package ru.jaguardesign.testnav;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

//import com.google.android.gms.maps.model.LatLng;

public class DB {
	private static final String TAG = "MyApp";
	private static final String DATABASE_NAME = "diet.db";
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_NAME = "food";//
	public static final String UID = "_id";
	public static final String TITLE = "title";//
	public static final String KAL= "kal";//
	public static final String BELKI= "belki";//
	public static final String GIRY = "giry";//
	public static final String UGLEVODY = "uglevody";//
	public static final String KLETCHA = "kletcha";//
    public static final String IB = "ib";//
    public static final String IU = "iu";//
    public static final String IK = "ik";//
    public static final String IG = "ig";//

	public static final String CREATE_DATE = "create_date_note";//����  �������
	public static final String CREATE_TIME = "create_time_note";//�����  �������

	//public static final String DATE_TIME = "date_time_note";

	public static final String TYPE = "type";//����� �������
    public static final String O= "descp";
    public static final String C= "c";
    public static final String A= "a";
    public static final String POLS= "pols";
	private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
			+ TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ TITLE + " TEXT, "+ KAL + " FLOAT, "+ BELKI + " FLOAT, "
            + GIRY + " FLOAT, "+ UGLEVODY + " FLOAT, "+ KLETCHA + " FLOAT ,"+
			TYPE + " INTEGER"+ "," +
            IB +" INTEGER, "+
            IU +" INTEGER, "+
            IK +" INTEGER, "+
            IG +" INTEGER, "+
            O +" TEXT, "+
            C +" INTEGER, "+
            POLS +" INTEGER "+
            ");";
    //A +" INTEGER "+
    private static final String SQL_ALTER_ENTRIES = "ALTER TABLE "
            + TABLE_NAME + " ADD COLUMN "+ A + " INTEGER ";
	private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;


    public static final String TABLE_NAME1 = "cook_food";//
    public static final String UID1 = "_id";
    public static final String ID_FOOD1 = "id_food";//
    public static final String ID_COOKING1= "id_cooking";//

    private static final String SQL_CREATE_ENTRIES1 = "CREATE TABLE "
            + TABLE_NAME1 + " (" + UID1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ID_FOOD1 + " TEXT, "+ ID_COOKING1 + " TEXT "+
            ");";
    private static final String SQL_DELETE_ENTRIES1 = "DROP TABLE IF EXISTS "
            + TABLE_NAME1;

    public static final String TABLE_NAME2 = "cooking";//
    public static final String UID2 = "_id";
    public static final String TITLE2 = "title";//
    public static final String DESCP2= "descp";//
    public static final String IDF= "idf";//
    public static final String FOOD2 = "food";

    private static final String SQL_CREATE_ENTRIES2 = "CREATE TABLE "
            + TABLE_NAME2 + " (" + UID2 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE2 + " TEXT, "+ DESCP2 + " TEXT, "+
            IDF+" TEXT, "+FOOD2+" INTEGER "+");";
    private static final String SQL_DELETE_ENTRIES2 = "DROP TABLE IF EXISTS "
            + TABLE_NAME2;

    public static final String TABLE_NAME3 = "type";//
    public static final String UID3 = "_id";
    public static final String TITLE3 = "title";//
    public static final String DESCP3= "descp";//

    private static final String SQL_CREATE_ENTRIES3 = "CREATE TABLE "
            + TABLE_NAME3 + " (" + UID3 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE3 + " TEXT, "+ DESCP3 + " TEXT "+
            ");";
    private static final String SQL_DELETE_ENTRIES3 = "DROP TABLE IF EXISTS "
            + TABLE_NAME3;


    public static final String TABLE_NAME4 = "about";//
    public static final String UID4 = "_id";
    public static final String SY4 = "sync";//
    public static final String DESCP4= "descp";//

    private static final String SQL_CREATE_ENTRIES4 = "CREATE TABLE "
            + TABLE_NAME4 + " (" + UID4 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SY4 + " INTEGER, "+ DESCP4 + " TEXT "+
            ");";
    private static final String SQL_DELETE_ENTRIES4 = "DROP TABLE IF EXISTS "
            + TABLE_NAME4;

    public static final String TABLE_NAME5 = "spo";//
    public static final String UID5 = "_id";
    public static final String TITLE5 = "title";//
    public static final String DESCP5= "descp";//
    public static final String O5= "o";//
    public static final String TECH5= "tech";//

    private static final String SQL_CREATE_ENTRIES5 = "CREATE TABLE "
            + TABLE_NAME5 + " (" + UID5 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE5 + " TEXT, "+ DESCP5 + " TEXT, "+
            O5 + " INTEGER, "+TECH5 + " TEXT "+
            ");";
    private static final String SQL_DELETE_ENTRIES5 = "DROP TABLE IF EXISTS "
            + TABLE_NAME5;

    public static final String TABLE_NAME7 = "res";//сохранение результата
    public static final String UID7 = "_id";
    public static final String TITLE7 = "title";//
    public static final String DESCP7= "descp";//
    public static final String O7= "o";//
    public static final String O27= "o2";//

    private static final String SQL_CREATE_ENTRIES7 = "CREATE TABLE "
            + TABLE_NAME7 + " (" + UID7 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE7 + " TEXT, "+ DESCP7 + " TEXT, "+
            O7 + " FLOAT, "+O27 + " INTEGER "+
            ");";//o7 - check, o27 - g
    private static final String SQL_DELETE_ENTRIES7 = "DROP TABLE IF EXISTS "
            + TABLE_NAME7;



    public static final String TABLE_NAME8 = "bu";//напоминание
    public static final String UID8 = "_id";
    public static final String TITLE8 = "title";//
    public static final String DESCP8= "descp";//
    public static final String TIME8= "tim";//
    public static final String TIMEM8= "timem";//

    private static final String SQL_CREATE_ENTRIES8 = "CREATE TABLE "
            + TABLE_NAME8 + " (" + UID8 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE8 + " TEXT, "+ DESCP8 + " TEXT, "+
            TIME8 + " TEXT, "+TIMEM8 + " INTEGER "+
            ");";//o7 - check, o27 - g
    private static final String SQL_DELETE_ENTRIES8 = "DROP TABLE IF EXISTS "
            + TABLE_NAME8;

    public static final String TABLE_NAME10 = "gra";//граф
    public static final String UID10 = "_id";
    public static final String TITLE10 = "title";//
    public static final String DESCP10= "descp";//
    public static final String DATE10= "dat";//
    public static final String DATEM10= "date1";//
    public static final String VES10= "ves";//
    public static final String GIM10= "gim";//
    public static final String PRI10= "pri";//
    public static final String ST10= "st";//
    public static final String TAL10= "tal";//
    public static final String SIS10= "sis";//
    public static final String YAG10= "yag";//

    private static final String SQL_CREATE_ENTRIES10 = "CREATE TABLE "
            + TABLE_NAME10 + " (" + UID10 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE10 + " TEXT, "+ DESCP10 + " TEXT, "+
            O7 + " FLOAT, "+TIMEM8 + " INTEGER, "+
            DATE10 + " TEXT, "+DATEM10 + " INTEGER, "+
            VES10 + " FLOAT, "+GIM10 + " FLOAT , "+
            PRI10 + " FLOAT, "+ST10 + " FLOAT, "+
            TAL10 + " FLOAT, "+SIS10 + " FLOAT, "+YAG10 + " FLOAT "+
            ");";//o7 - check, o27 - g
    private static final String SQL_DELETE_ENTRIES10 = "DROP TABLE IF EXISTS "
            + TABLE_NAME10;

    public static final String TABLE_NAME11 = "dn";//
    public static final String UID11 = "_id";
    public static final String TITLE11 = "title";//
    public static final String DESCP11= "descp";//
    public static final String DATE11= "dat";//
    public static final String DATEM11= "date1";//
    public static final String VES11= "ves";//
    //public static final String GIM10= "gim";//
    public static final String UIDF11= "uidf";//
    //public static final String ST10= "st";//


    private static final String SQL_CREATE_ENTRIES11 = "CREATE TABLE "
            + TABLE_NAME11 + " (" + UID11 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE11 + " TEXT, "+ DESCP11 + " TEXT, "+

            DATE11 + " TEXT, "+DATEM11 + " INTEGER, "+
            VES11 + " FLOAT, "+UIDF11 + " INTEGER  "+

            ");";//o7 - check, o27 - g
    private static final String SQL_DELETE_ENTRIES11 = "DROP TABLE IF EXISTS "
            + TABLE_NAME11;
  private final Context mCtx;
  
  
  private DBHelper mDBHelper;
  private SQLiteDatabase mDB;
  private String[] selectionArgs = null;
  private String selection = null;
  public DB(Context ctx) {
    mCtx = ctx;
  }
  
  // ������� �����������
  public void open() {
    mDBHelper = new DBHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
    mDB = mDBHelper.getWritableDatabase();
  }
  
  // ������� �����������
  public void close() {
    if (mDBHelper!=null) mDBHelper.close();
  }
  
  //�������� �� id
  public void delId(int id) {
	  String io= Integer.toString(id);
	  mDB.delete(TABLE_NAME, UID+" = "+id,null );

	  //mDB.de
	  }
  
  
  //����� ������ ��� ������� ��������

 public Cursor newRec() {ContentValues cv = new ContentValues();
 
 Cursor cu=mDB.rawQuery("select _id from notes_table order by _id desc limit 1",null);//"+UID+" from "+TABLE_NAME+" order by "+UID+" desc limit 1",null);
Cursor cur=null;

		 return cur;
		 
 //return newid;

 }

    public Cursor getCook(Long id) {
        selection = FOOD2+"=?";
        selectionArgs = new String[] { id.toString() };
      //  if (BuildConfig.PAID) {
            return mDB.query(TABLE_NAME2, null, selection, selectionArgs, null, null, null);
   //     }
     //   else
         //   return mDB.query(TABLE_NAME2, null, selection, selectionArgs, null, null,  "null LIMIT 2");
    }
    public Cursor getIdCook(Long id) {
        selection = UID2+"=?";
        selectionArgs = new String[] { id.toString() };
        return mDB.query(TABLE_NAME2, null, selection,selectionArgs , null, null, null);
    }
//�������� �� id ������ �� ������� DB_TABLE
 public Cursor getidData(Long id) {
	 selection = UID+"=?";
     selectionArgs = new String[] { id.toString() };
   return mDB.query(TABLE_NAME, null, selection,selectionArgs , null, null, null);
 }
  // �������� ��� ������ �� ������� DB_TABLE
  public Cursor getAllData() {
    return mDB.query(TABLE_NAME, null, null, null, null, null, null);
  }

    public void SetC(int uid, int c) {
        selection = UID+"=?";
        selectionArgs = new String[] { Integer.toString(uid) };
        ContentValues cv = new ContentValues();
        cv.put(C, c);
Log.d("m__",String.valueOf(c));
        mDB.update(TABLE_NAME, cv,selection,selectionArgs);
    }

    public boolean upRecFood(JSONArray array) { //update Tasks on Load
        Cursor cursor; int coun;
        boolean zx=false;
        //mDB.rawQuery("alter table food add column a integer",null);
      //  int z;
        mDB.beginTransaction();
        try {
        Log.d("m__c", Integer.toString(array.length()));
        try {
            for(int i = 0; i < array.length(); i++)
            { coun=0;
                JSONObject obj = array.getJSONObject(i);
                selection = UID+"=?";
                selectionArgs = new String[] {obj.getString("id")  };
                cursor = mDB.query(TABLE_NAME, null, selection, selectionArgs , null, null, null);
                coun=cursor.getCount();

                if(cursor != null)
                    cursor.close();
               // Log.d("m__1", String.valueOf(coun));
                Log.d("m__z", obj.getString("title"));


                //Log.d("m__", array.toString());
                //coun=0;
                if (coun==0)
                {
                    ContentValues cv = new ContentValues();

                    cv.put(UID, obj.getString("id"));
                    cv.put(TITLE, obj.getString("title"));
                 cv.put(KAL, obj.getString("kkal"));
                       cv.put(BELKI, obj.getString("belki"));//}
                    cv.put(GIRY, obj.getString("giry"));
                    cv.put(UGLEVODY, obj.getString("uglevodi"));//}
                    cv.put(KLETCHA, obj.getString("kletchat"));
                    cv.put(IB, obj.getString("ib"));
                    cv.put(IG, obj.getString("ig"));
                    cv.put(IU, obj.getString("iu"));
                    cv.put(IK, obj.getString("ik"));
                    cv.put(C, "1");
                    cv.put(POLS, obj.getString("pols"));
                 //   Log.d("m__11", "zz");
                    if (obj.getString("del").equals("0")) // z=1; else
                    mDB.insert(TABLE_NAME, null, cv);
                    zx=true;
                }
                else
                {
                    selection = UID+"=?";
                    selectionArgs = new String[] {obj.getString("id")  };
                    cursor = mDB.query(TABLE_NAME, null, selection, selectionArgs , null, null, null);
                    cursor.moveToFirst();
                    if (cursor.isNull(cursor.getColumnIndex(C)))
                    {
                        selection = UID+"=?";
                       // Log.d("m__11", "zz");
                        //String k="11";
                        selectionArgs = new String[] {obj.getString("id")};
                        ContentValues cv = new ContentValues();
                        cv.put(C, "1");
                        mDB.update(TABLE_NAME, cv, selection, selectionArgs);
                    }
                    selection = UID+"=?";
                    //String k="11";
                    selectionArgs = new String[] {obj.getString("id")};

                //    Log.d("m__1", obj.getString("del"));
                //    if (obj.getString("del").equals("1")) {
                    if (obj.getString("del").equals("1")) {
mDB.delete(TABLE_NAME,UID+"="+obj.getString("id"),null);
                //        mDB.delete(TABLE_NAME,TITLE+"=''",null);
                    }
                    else {
                        ContentValues cv = new ContentValues();
                        cv.put(UID, obj.getString("id"));
                        cv.put(TITLE, obj.getString("title"));
                        cv.put(KAL, obj.getString("kkal"));
                        cv.put(BELKI, obj.getString("belki"));//}
                        cv.put(GIRY, obj.getString("giry"));
                        cv.put(UGLEVODY, obj.getString("uglevodi"));//}
                        cv.put(KLETCHA, obj.getString("kletchat"));
                        cv.put(IB, obj.getString("ib"));
                        cv.put(IG, obj.getString("ig"));
                        cv.put(IU, obj.getString("iu"));
                        cv.put(IK, obj.getString("ik"));
                        //cv.put(DISTANCE, distance);
                        cv.put(POLS, obj.getString("pols"));
                        mDB.update(TABLE_NAME, cv, selection, selectionArgs);
                        //  Log.d("m__1", obj.getString("title"));
                    }
                }
                //now, get whatever value you need from the object:
                //String placename = obj.getString("descp_seo");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        selection = UID+"=?";
        //selectionArgs = new String[] { id.toString() };
         //}
    mDB.setTransactionSuccessful();
}
finally {
        mDB.endTransaction();
        }
        ContentValues cv = new ContentValues();
        //cv.put(TITLE, title);
        return zx;
        //mDB.update(TABLE_NAME, cv,selection,selectionArgs);
    }

    public boolean upRecFood1(JSONArray array) { //update Tasks on Load
        Cursor cursor; int coun;
        boolean zx=false;
        //  int z;
        mDB.beginTransaction();
        try {
        Log.d("m__c", Integer.toString(array.length()));
        try {
            for(int i = 0; i < array.length(); i++)
            { coun=0;
                JSONObject obj = array.getJSONObject(i);
                selection = UID+"=?";
                selectionArgs = new String[] {obj.getString("id")  };
                        ContentValues cv = new ContentValues();
                        cv.put(UID, obj.getString("id"));

                        cv.put(O, obj.getString("descp"));
                        //cv.put(DISTANCE, distance);
                        mDB.update(TABLE_NAME, cv, selection, selectionArgs);
                        //  Log.d("m__1", obj.getString("title"));

                //now, get whatever value you need from the object:
                //String placename = obj.getString("descp_seo");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        selection = UID+"=?";

         //}
    mDB.setTransactionSuccessful();
}
finally {
        mDB.endTransaction();
        }
        //selectionArgs = new String[] { id.toString() };
        ContentValues cv = new ContentValues();
        //cv.put(TITLE, title);
        return zx;
        //mDB.update(TABLE_NAME, cv,selection,selectionArgs);
    }

    public boolean upRecCook(JSONArray array) { //update Tasks on Load
        Cursor cursor; int coun;
        boolean zx=false;
        //  int z;
        mDB.beginTransaction();
        try {
            Log.d("m__c", Integer.toString(array.length()));
        try {
            for(int i = 0; i < array.length(); i++)
            { coun=0;
                JSONObject obj = array.getJSONObject(i);
                selection = UID2+"=?";
                selectionArgs = new String[] {obj.getString("id")  };
                cursor = mDB.query(TABLE_NAME2, null, selection, selectionArgs , null, null, null);
                coun=cursor.getCount();
                if(cursor != null)
                    cursor.close();
                // Log.d("m__1", String.valueOf(coun));
               // Log.d("m__z", obj.getString("food"));
                //Log.d("m__z", obj.getString("title"));

                //Log.d("m__", array.toString());
                //coun=0;
                if (coun==0)
                {
                    ContentValues cv = new ContentValues();

                    cv.put(UID2, obj.getString("id"));
                    cv.put(TITLE2, obj.getString("title"));
                    cv.put(DESCP2, obj.getString("descp"));
                    cv.put(FOOD2, obj.getString("food"));//}

                    //   Log.d("m__11", "zz");
                    if (obj.getString("del").equals("0")) // z=1; else
                        mDB.insert(TABLE_NAME2, null, cv);
                    zx=true;
                }
                else
                {

                    selection = UID2+"=?";
                    //String k="11";
                    selectionArgs = new String[] {obj.getString("id")};
                  //  Log.d("m__1", obj.getString("del"));
                    //    if (obj.getString("del").equals("1")) {
                    if (obj.getString("del").equals("1")) {
                        mDB.delete(TABLE_NAME2,UID2+"="+obj.getString("id"),null);
                        //        mDB.delete(TABLE_NAME,TITLE+"=''",null);
                    }
                    else {
                        ContentValues cv = new ContentValues();
                        cv.put(UID2, obj.getString("id"));
                        cv.put(TITLE2, obj.getString("title"));
                        cv.put(DESCP2, obj.getString("descp"));
                        cv.put(FOOD2, obj.getString("food"));//}
                        //cv.put(DISTANCE, distance);
                        mDB.update(TABLE_NAME2, cv, selection, selectionArgs);
                        //  Log.d("m__1", obj.getString("title"));
                    }
                }
                //now, get whatever value you need from the object:
                //String placename = obj.getString("descp_seo");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        selection = UID2+"=?";
        //selectionArgs = new String[] { id.toString() };
        ContentValues cv = new ContentValues();
        //cv.put(TITLE, title);
    //}
    mDB.setTransactionSuccessful();
}
finally {
        mDB.endTransaction();
        }
        return zx;
        //mDB.update(TABLE_NAME, cv,selection,selectionArgs);
    }
  // �������� ������ � DB_TABLE
  public void addRec(String title, String descp) {

   // mDB.insert(TABLE_NAME, null, cv);
  }
  
  // ������� ������ �� DB_TABLE
  public void delRec(long id) {
    mDB.delete(TABLE_NAME, UID + " = " + id, null);
  }
    public Cursor getAllDataFood() {
        selection = POLS+"=?";
        selectionArgs = new String[] { "2"  };
        return mDB.query(TABLE_NAME, null, selection, selectionArgs, null, null, TITLE);
    }
    public Cursor getSpo ()
    {
        return mDB.query(TABLE_NAME5, null, selection, selectionArgs , null, null, TITLE5);
    }
    public Cursor getIdSp (Long id)
    {
        selection = UID5+"=?";
        selectionArgs = new String[] { id.toString()  };
        return mDB.query(TABLE_NAME5, null, selection, selectionArgs , null, null, TITLE5);
    }
    public boolean upRecSpo(JSONArray array) { //update Tasks on Load
        Cursor cursor; int coun;
        boolean zx=false;
        //  int z;
        Log.d("m__vc", Integer.toString(array.length()));
        try {
            for(int i = 0; i < array.length(); i++)
            { coun=0;
                JSONObject obj = array.getJSONObject(i);
                selection = UID5+"=?";
                selectionArgs = new String[] {obj.getString("id")  };
                cursor = mDB.query(TABLE_NAME5, null, selection, selectionArgs , null, null, null);
                coun=cursor.getCount();
                if(cursor != null)
                    cursor.close();
                // Log.d("m__1", String.valueOf(coun));
                // Log.d("m__z", obj.getString("food"));
                //Log.d("m__z", obj.getString("title"));

                //Log.d("m__", array.toString());
                //coun=0;
                if (coun==0)
                {
                    ContentValues cv = new ContentValues();

                    cv.put(UID5, obj.getString("id"));
                    cv.put(TITLE5, obj.getString("title"));
                    cv.put(DESCP5, obj.getString("descp"));
                    //cv.put(FOOD2, obj.getString("food"));//}

                    //   Log.d("m__11", "zz");
                    if (obj.getString("del").equals("0")) // z=1; else
                        mDB.insert(TABLE_NAME5, null, cv);
                    zx=true;
                }
                else
                {

                    selection = UID5+"=?";
                    //String k="11";
                    selectionArgs = new String[] {obj.getString("id")};
                    //  Log.d("m__1", obj.getString("del"));
                    //    if (obj.getString("del").equals("1")) {
                    if (obj.getString("del").equals("1")) {
                        mDB.delete(TABLE_NAME5,UID5+"="+obj.getString("id"),null);
                        //        mDB.delete(TABLE_NAME,TITLE+"=''",null);
                    }
                    else {
                        ContentValues cv = new ContentValues();
                        cv.put(UID5, obj.getString("id"));
                        cv.put(TITLE5, obj.getString("title"));
                        cv.put(DESCP5, obj.getString("descp"));
                        //cv.put(FOOD5, obj.getString("food"));//}
                        //cv.put(DISTANCE, distance);
                        mDB.update(TABLE_NAME5, cv, selection, selectionArgs);
                        //  Log.d("m__1", obj.getString("title"));
                    }
                }
                //now, get whatever value you need from the object:
                //String placename = obj.getString("descp_seo");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        selection = UID5+"=?";
        //selectionArgs = new String[] { id.toString() };
        ContentValues cv = new ContentValues();
        //cv.put(TITLE, title);
        return zx;
        //mDB.update(TABLE_NAME, cv,selection,selectionArgs);
    }
    public Cursor getBel ()
    {
     //   selection = IB+"=?";
//        selectionArgs = new String[] {"1"  };
       // Cursor cursor = mDB.rawQuery("select");//query(TABLE_NAME, null, selection, selectionArgs , null, null, null);
  //      Cursor cursor = mDB.query(TABLE_NAME, null, selection, selectionArgs, null, null, "RANDOM()", "1");
        Cursor cursor;
      //  if (BuildConfig.PAID) cursor=mDB.rawQuery("select * from food where c=1 and ib=1 and title!='' order by random() limit 1",null);
      //      else
        cursor=mDB.rawQuery("select * from food where ib=1 and title!='' order by random() limit 1", null);
        return cursor;
    }
    public Cursor getGir ()
    {
        selection = IG+"=?";
        selectionArgs = new String[] {"1"  };
        // Cursor cursor = mDB.rawQuery("select");//query(TABLE_NAME, null, selection, selectionArgs , null, null, null);
        Cursor cursor;
     //   if (BuildConfig.PAID) cursor=mDB.rawQuery("select * from food where c=1 and ig=1 order by random() limit 1",null);
     //   else
         cursor = mDB.query(TABLE_NAME, null, selection, selectionArgs, null, null, "RANDOM()", "1");
        return cursor;
    }
    public Cursor getUgl ()
    {
        selection = IU+"=?";
        selectionArgs = new String[] {"1"  };
        // Cursor cursor = mDB.rawQuery("select");//query(TABLE_NAME, null, selection, selectionArgs , null, null, null);
        Cursor cursor;
     //   if (BuildConfig.PAID) cursor=mDB.rawQuery("select * from food where c=1 and iu=1 order by random() limit 1",null);
     //   else
        cursor = mDB.query(TABLE_NAME, null, selection, selectionArgs, null, null, "RANDOM()", "1");
        return cursor;
    }
    public  Cursor getKl ()
    {
    //    selection = IK+"=?";
//        selectionArgs = new String[] { "1" };
//        return mDB.query(TABLE_NAME, null, selection,selectionArgs , null, null, null);
        Cursor cursor;
    //    if (BuildConfig.PAID) cursor=mDB.rawQuery("select * from food where c=1 and ik=1 order by random() limit 1",null);
     //   else
         cursor=mDB.rawQuery("select * from food where ik=1 and title!='' order by random() limit 1", null);
        return cursor;
    }
    public  Cursor getS ()
    {
            selection = UID4+"=?";
        selectionArgs = new String[] { "1" };
        return mDB.query(TABLE_NAME4, null, selection, selectionArgs, null, null, null);
//        Cursor cursor=mDB.rawQuery("select * from food where ik=1 and title!='' order by random() limit 1",null);
//        return cursor;
    }
    public  int setS (int s)
    {
        selection = UID4+"=?";
        selectionArgs = new String[] { "1" };
        ContentValues cv = new ContentValues();
        cv.put(SY4, s);
        return mDB.update(TABLE_NAME4, cv, selection, selectionArgs);
//        Cursor cursor=mDB.rawQuery("select * from food where ik=1 and title!='' order by random() limit 1",null);
//        return cursor;
    }

    public  void updateRes (ArrayList<Result> res)
    {
        Iterator ite=res.iterator();
        Result te;
        int i=0;
        mDB.delete(TABLE_NAME7, null, null);
        while (i<res.size())
        {
            ContentValues cv = new ContentValues();
            te=res.get(i);
            cv.put(TITLE7, te.title);Log.d("m__",te.title);
            cv.put(O27, te.ves);
            cv.put(O7, 0);
            mDB.insert(TABLE_NAME7, null, cv);
                    i++;
        }

        // mDB.update(TABLE_NAME4, cv, selection, selectionArgs);
//        Cursor cursor=mDB.rawQuery("select * from food where ik=1 and title!='' order by random() limit 1",null);
//        return cursor;
    }
    public Cursor getAllDataRes() {
        //selection = STAT1+"=?";
        //selectionArgs = new String[] { "1"  };
        return mDB.query(TABLE_NAME7, null, null, null, null, null, UID7);
    }
    public void SetC7(int uid, int c) {
        selection = UID7+"=?";
        selectionArgs = new String[] { Integer.toString(uid) };
        ContentValues cv = new ContentValues();
        cv.put(O7, c);
     //   Log.d("m__",String.valueOf(c)+String.valueOf(uid)+"a");
        mDB.update(TABLE_NAME7, cv, selection, selectionArgs);
    }
    public void NewBu(String time,String title)
    {
        ContentValues cv = new ContentValues();
        cv.put(TIME8, time);
        cv.put(TIMEM8, time);
        cv.put(TITLE8,title );
        mDB.insert(TABLE_NAME8, null, cv);
    }
    public void DelBu(int id)
    {

        String io=Integer.toString(id);
        mDB.delete(TABLE_NAME8, UID8 + " = " + id, null);
    }
    public Cursor getBu()
    {

        Cursor cursor = mDB.query(TABLE_NAME8, null, null, null, null, null, TIME8, null);
        return cursor;
    }
    public Cursor gIdBu(int id)
    {

       // Cursor cursor = mDB.query(TABLE_NAME8, null, null, null, null, null, TIME8, null);
        //return cursor;
        selection = UID8+"=?";
        selectionArgs = new String[] { Integer.toString(id)  };
        return mDB.query(TABLE_NAME8, null, selection, selectionArgs, null , null, null );
    }
    public void NewGr(String date,String val)
    {
        //val-value of weight
        ContentValues cv = new ContentValues();
        cv.put(DATE10, date);
        cv.put(VES10, val);
        //cv.put(TITLE8,title );
        mDB.insert(TABLE_NAME10, null, cv);
    }
    public Cursor GetGr()
    {

        Cursor cursor = mDB.query(TABLE_NAME10, null, null, null, null, null, DATE10, null);
        return cursor;
    }
    public void delGr(int id)
    {

        mDB.delete(TABLE_NAME10, UID10 + " = " + id, null);

    }
    public void newRecFood (
            String title,int kal, int bel,
            int dir, int ugl, int kle,
            int ib,int ig, int iu, int ik
    )
    {
        int flag=1;
        //if (kal==0) flag=0;
        //if (bel==0) flag=0;
        //if (dir==0) flag=0;
        //if (ugl==0) flag=0;
        if (title.equals("")) flag=0;
        if (flag==1) {
            ContentValues cv = new ContentValues();
            //int z=400;
            Cursor cu=getidData(Long.parseLong("400"));
            if (cu!=null)
                if (cu.getCount()==0)
                    cv.put(UID, 400);
            cv.put(TITLE, title);
            cv.put(KAL, String.valueOf(kal));
            cv.put(BELKI, String.valueOf(bel));//}
            cv.put(GIRY, String.valueOf(dir));
            cv.put(UGLEVODY, String.valueOf(ugl));//}
            cv.put(KLETCHA, String.valueOf(kle));
            cv.put(IB, String.valueOf(ib));
            cv.put(IG, String.valueOf(ig));
            cv.put(IU, String.valueOf(iu));
            cv.put(IK, String.valueOf(ik));
            //   Log.d("m__11", "zz");
            //if (obj.getString("del").equals("0")) // z=1; else
            cv.put(C, 1);
            mDB.insert(TABLE_NAME, null, cv);
        }//zx=true;
    }
    public   Cursor Searchfood(String s )
    {
        selection = TITLE+"=?";
        selectionArgs = new String[] { s  };
        //return mDB.query(TABLE_NAME, null, selection, selectionArgs, null , null, null );

       return mDB.rawQuery("select * from food where title LIKE '%"+s+"%' ",null);
    }

    public   Cursor Searchfoodt(String s )
    {
        selection = TITLE+"=?";
        selectionArgs = new String[] { s  };
        //return mDB.query(TABLE_NAME, null, selection, selectionArgs, null , null, null );

        //return mDB.rawQuery("select * from food where title LIKE '%"+s+"%' ",null);
        return mDB.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
    }
    public   boolean newdn (String date, int gr,String s )
    {
        boolean f=false;
        Cursor cu=Searchfoodt(s);
//if (date.equals("")) gr=0;
        if (cu!=null)
            if (cu.getCount()>0)
                if (gr>0)
                    if (!date.equals(""))
            {
                cu.moveToFirst();
                ContentValues cv = new ContentValues();
                cv.put(TITLE11, s);
                cv.put(VES11, String.valueOf(gr));
                cv.put(DATE11, date);
                cv.put(UIDF11, cu.getInt(cu.getColumnIndex(DB.UID)));
                f=true;
                mDB.insert(TABLE_NAME11, null, cv);
            }
        //return mDB.query(TABLE_NAME, null, selection, selectionArgs, null , null, null );
        return  f;
    }
    public   Cursor Dne(String s )
    {
        selection = DATE11+"=?";
        selectionArgs = new String[] { s  };
        //return mDB.query(TABLE_NAME, null, selection, selectionArgs, null , null, null );

        //return mDB.rawQuery("select * from food where title LIKE '%"+s+"%' ",null);
        return mDB.query(TABLE_NAME11, null, selection, selectionArgs, null, null, null);
    }
    public Cursor gefData() {
        selection = UID+">?";
        selectionArgs = new String[] { "399" };
        return mDB.query(TABLE_NAME, null, selection,selectionArgs , null, null, null);
    }

    public void deln(int id) {

         mDB.delete(TABLE_NAME, UID+" = "+id, null);
    }
    public void delm(int id) {

        mDB.delete(TABLE_NAME11, UID11 + " = " + id, null);
    }
    public   Cursor CheckDne( )
    {
      //  selection = DATE11+"=?";
      //  selectionArgs = new String[] { s  };
        //return mDB.query(TABLE_NAME, null, selection, selectionArgs, null , null, null );

        //return mDB.rawQuery("select * from food where title LIKE '%"+s+"%' ",null);
        return mDB.query(TABLE_NAME11, null, null, null, null, null, null);
    }
    // ����� �� �������� � ���������� ��
    public Cursor re(Long id) {
        selection = UID+"=?";
        selectionArgs = new String[] { String.valueOf(id) };
        Log.d("m__",String.valueOf(id));
        //return mDB.query(TABLE_NAME, null, selection,selectionArgs , null, null, null);
        Cursor c=mDB.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
        String id1="0";
        if (c!=null)
            if (c.moveToFirst())
                id1=c.getString(c.getColumnIndex(DB.UID));

        Log.d("m__",String.valueOf(id1));
        return c;
    }
  private class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, CursorFactory factory,
        int version) {
      super(context, name, factory, version);
    }

    // ������� � ��������� ��
    @Override
    public void onCreate(SQLiteDatabase db) {
      //try { 
    	//db.execSQL(SQL_DELETE_ENTRIES);  
    	db.execSQL(SQL_CREATE_ENTRIES);
        //db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES1);
        db.execSQL(SQL_CREATE_ENTRIES2);
        db.execSQL(SQL_CREATE_ENTRIES3);
        db.execSQL(SQL_CREATE_ENTRIES4);
        db.execSQL(SQL_CREATE_ENTRIES5);
        db.execSQL(SQL_CREATE_ENTRIES7);
        db.execSQL(SQL_CREATE_ENTRIES8);
        db.execSQL(SQL_CREATE_ENTRIES10);
        db.execSQL(SQL_CREATE_ENTRIES11);
    	//  }
      //catch (Exception exception) {
    	//    Log.e(TAG, "�������� ����������", exception);}
      
      ContentValues cv = new ContentValues();
        cv.put(SY4, 0);
        cv.put(UID4, 1);
        db.insert(TABLE_NAME4, null, cv);
    /* for (int i = 1; i < 5; i++) { //if (i==4) {
    	  cv.put(UID, i+1);
    	  cv.put(TITLE, "фя");

    	  
        //cv.put(DESCP, "somecontent"+ i);
        db.insert(TABLE_NAME, null, cv); }*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
        //    db.execSQL(SQL_ALTER_ENTRIES);
        //    db.execSQL(SQL_CREATE_ENTRIES5);
        }
        if (oldVersion < 3) {
            //    db.execSQL(SQL_ALTER_ENTRIES);
       //     db.execSQL(SQL_CREATE_ENTRIES7);
        }
        if (oldVersion < 4) {
            //    db.execSQL(SQL_ALTER_ENTRIES);
        //    db.execSQL(SQL_CREATE_ENTRIES8);
        //    db.execSQL(SQL_CREATE_ENTRIES10);
        }
        if (oldVersion < 5) {
            //    db.execSQL(SQL_ALTER_ENTRIES);
            //db.execSQL(SQL_CREATE_ENTRIES8);
         //   db.execSQL(SQL_CREATE_ENTRIES11);
        }
    }
      @Override
      public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //   onUpgrade(db);
      }
  }
}
