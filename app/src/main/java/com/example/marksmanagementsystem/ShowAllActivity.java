package com.example.marksmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowAllActivity extends AppCompatActivity {

    databaseHelper DBHelper;
    RecyclerView recyclerView;
    StudentAdapter adapter;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        DBHelper = new databaseHelper(this);

        recyclerView = findViewById(R.id.recyclerViewID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(adapter);

        Cursor cursor = DBHelper.showData();

        while (cursor.moveToNext()){

            int ID = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_ID));
            String studentID = cursor.getString(cursor.getColumnIndex(DBHelper.COL_STUDENT_ID));
            String subject = cursor.getString(cursor.getColumnIndex(DBHelper.COL_SUBJECT));
            String marks = cursor.getString(cursor.getColumnIndex(DBHelper.COL_MARKS));
            String department = cursor.getString(cursor.getColumnIndex(DBHelper.COL_DEPARTMENT));
            String gender = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GENDER));

            studentList.add(new Student(ID,studentID,subject,marks,department,gender));
            adapter.notifyDataSetChanged();
        }
    }
}