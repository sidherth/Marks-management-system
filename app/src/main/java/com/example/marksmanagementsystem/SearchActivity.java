package com.example.marksmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    EditText idET;
    databaseHelper DBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        idET = findViewById(R.id.idET);
        DBHelper = new databaseHelper(this);

    }

    public void searchBTN(View view) {

        String studentID = idET.getText().toString().trim();

        Cursor cursor = DBHelper.search(studentID);

        while (cursor.moveToNext()){

            int ID = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_ID));
            String studentId = cursor.getString(cursor.getColumnIndex(DBHelper.COL_STUDENT_ID));
            String subject = cursor.getString(cursor.getColumnIndex(DBHelper.COL_SUBJECT));
            String marks = cursor.getString(cursor.getColumnIndex(DBHelper.COL_MARKS));
            String department = cursor.getString(cursor.getColumnIndex(DBHelper.COL_DEPARTMENT));
            String gender = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GENDER));


            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Search Result");
            dialog.setMessage("ID: "+studentID+"\n"+"Subject: "+subject+"\n"+"Marks: "+marks+"\n"+"Department: "+department+"\n"+"Gender: "+gender);
            dialog.setCancelable(true);
            dialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                    Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });

            AlertDialog alertDialog = dialog.create();
            alertDialog.show();
        }

    }
}