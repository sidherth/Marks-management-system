package com.example.marksmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idET,subjectET,marksET;
    RadioGroup radioGroupID;
    RadioButton radioButton;
    Spinner spinnerID;
    databaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idET = findViewById(R.id.idET);
        subjectET = findViewById(R.id.subjectET);
        marksET = findViewById(R.id.marksET);
        radioGroupID = findViewById(R.id.radioGroupID);
        spinnerID = findViewById(R.id.spinnerID);

        DBHelper = new databaseHelper(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.departmentArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerID.setAdapter(adapter);

    }

    public void addBTN(View view) {

        radioButton = findViewById(radioGroupID.getCheckedRadioButtonId());


        String studentId = idET.getText().toString().trim();
        String subject = subjectET.getText().toString().trim();
        String marks = marksET.getText().toString().trim();
        String department = spinnerID.getSelectedItem().toString();
        String gender = radioButton.getText().toString();



        if(studentId.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter  name", Toast.LENGTH_SHORT).show();
        }
        else if(subject.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter ID", Toast.LENGTH_SHORT).show();
        }
        else if(marks.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter Department", Toast.LENGTH_SHORT).show();
        }
        else if(department.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter contact Number", Toast.LENGTH_SHORT).show();
        }
        else if(gender.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter gender", Toast.LENGTH_SHORT).show();
        }
        else {

            long colID = DBHelper.insertData(studentId,subject,marks,department,gender);

            Toast.makeText(MainActivity.this, "Data insert", Toast.LENGTH_SHORT).show();

            idET.setText("");
            subjectET.setText("");
            marksET.setText("");

        }
    }

    public void searchBTN(View view) {
        Intent intent = new Intent(MainActivity.this,SearchActivity.class);
        startActivity(intent);
    }

    public void showAllBTN(View view) {
        Intent intent = new Intent(MainActivity.this,ShowAllActivity.class);
        startActivity(intent);
    }

    public void updateBTN(View view) {
        Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
        startActivity(intent);
    }

    public void deleteBTN(View view) {
        Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
        startActivity(intent);
    }

    public void aboutBTN(View view) {
        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
        startActivity(intent);
    }
}