package com.example.marksmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class DeleteActivity extends AppCompatActivity {

    EditText idET;
    databaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        idET = findViewById(R.id.idET);
        DBHelper = new databaseHelper(this);


    }

    public void delete(View view) {

        String id = idET.getText().toString();

        if(id.isEmpty()){
            Toast.makeText(this, "Please Search First", Toast.LENGTH_SHORT).show();
        }
        else {
            int check = DBHelper.deleteData(id);

            if(check>0){
                Toast.makeText(this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DeleteActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}