package com.example.marksmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "User.db";
    private static String TABLE_NAME = "User";
    public static String COL_ID = "Id";
    public static String COL_STUDENT_ID = "studentID";
    public static String COL_SUBJECT = "subject";
    public static String COL_MARKS = "marks";
    public static String COL_DEPARTMENT = "department";
    public static String COL_GENDER = "gender";
    private static int VERSION = 1;

    private String CREATE_TABLE = "create table "+TABLE_NAME+" ("+COL_ID+" Integer primary key autoincrement, "+COL_STUDENT_ID+" TEXT, "+COL_SUBJECT+" TEXT, "+COL_DEPARTMENT+" TEXT, "+COL_MARKS+" TEXT, "+COL_GENDER+" TEXT)";


    public databaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public long insertData(String studentID,String subject,String marks,String department, String gender){

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_STUDENT_ID,studentID);
        contentValues.put(COL_SUBJECT,subject);
        contentValues.put(COL_MARKS,marks);
        contentValues.put(COL_DEPARTMENT,department);
        contentValues.put(COL_GENDER,gender);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long id = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();

        return id;
    }


    public Cursor search(String studentID){
        String SEARCH_DATA_QUERY = "select * From "+TABLE_NAME+" where "+COL_STUDENT_ID+" = "+studentID;

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SEARCH_DATA_QUERY,null);

        return cursor;
    }

    public Cursor showData(){

        String ALL_DATA_QUERY = "select * From "+TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(ALL_DATA_QUERY,null);

        return cursor;
    }

    public boolean updateData(String studentID,String subject,String marks,String department, String gender) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_STUDENT_ID,studentID);
        contentValues.put(COL_SUBJECT,subject);
        contentValues.put(COL_MARKS,marks);
        contentValues.put(COL_DEPARTMENT,department);
        contentValues.put(COL_GENDER,gender);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME, contentValues, COL_STUDENT_ID + " = ? ", new String[]{String.valueOf(studentID)});

        return true;
    }

    public int deleteData(String studentID){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int check = sqLiteDatabase.delete(TABLE_NAME,COL_STUDENT_ID+" = ? ",new String[]{studentID});

        return check;
    }

}
