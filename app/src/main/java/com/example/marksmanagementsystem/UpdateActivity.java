package com.example.marksmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText studentIdET,subjectET,marksET,departmentET,genderET;
    databaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);



        studentIdET = findViewById(R.id.studentIdET);
        subjectET = findViewById(R.id.subjectET);
        marksET = findViewById(R.id.marksET);
        departmentET = findViewById(R.id.departmentET);
        genderET = findViewById(R.id.genderET);

        DBHelper = new databaseHelper(this);


    }

    public void search(View view) {

        String ID = studentIdET.getText().toString();

        if(ID.isEmpty()){
            Toast.makeText(this, "Enter ID for Search", Toast.LENGTH_SHORT).show();
        }
        else {
            Cursor cursor = DBHelper.search(ID);

            while (cursor.moveToNext()){

                String studentId = cursor.getString(cursor.getColumnIndex(DBHelper.COL_STUDENT_ID));
                String subject = cursor.getString(cursor.getColumnIndex(DBHelper.COL_SUBJECT));
                String marks = cursor.getString(cursor.getColumnIndex(DBHelper.COL_MARKS));
                String department = cursor.getString(cursor.getColumnIndex(DBHelper.COL_DEPARTMENT));
                String gender = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GENDER));

                studentIdET.setText(studentId);
                subjectET.setText(subject);
                marksET.setText(marks);
                departmentET.setText(department);
                genderET.setText(gender);
            }

        }

    }

    public void update(View view) {

        String ID = studentIdET.getText().toString();
        String subject = subjectET.getText().toString();
        String marks = marksET.getText().toString();
        String department = departmentET.getText().toString();
        String gender = genderET.getText().toString();


        if(subject.isEmpty() || marks.isEmpty() || department.isEmpty() || gender.isEmpty()){
            Toast.makeText(this, "Please Search First", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean check = DBHelper.updateData(ID,subject,marks,department,gender);

            if(check){
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        }


    }
}