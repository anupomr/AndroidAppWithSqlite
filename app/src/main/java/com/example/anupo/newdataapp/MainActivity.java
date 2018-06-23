package com.example.anupo.newdataapp;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyData db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            db = new MyData(getApplicationContext());
            //db.createDatabase(getApplicationContext());
            db.dbInitialize("Student", "CREATE TABLE Student (id INTEGER PRIMARY KEY,Sname TEXT ," +
                    "Cname TEXT);");

        }catch(Exception e)
        {
            Log.d("Student", e.getMessage()+"");
        }
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int StudentNo = Integer.parseInt(((EditText)findViewById(R.id.sno)).getText().toString());
                String StudentName = ((EditText)findViewById(R.id.sname)).getText().toString();
                String CourseName = ((EditText)findViewById(R.id.cname)).getText().toString();

                MyData db = new MyData(getApplicationContext());
                ContentValues values = new ContentValues();

                values.put("id",StudentNo);;
                values.put("Sname",StudentName);
                values.put("Cname",CourseName);
                String message="Success";

                try {
                    db.addRow(values);
                    // finish();
                    Log.d("success","Success");
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Log.d("student",e.getMessage());
                }
            }
        });
        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   // ListView list = (ListView) findViewById(R.id.list);
                   Customer student = db.getStudentById(Integer.parseInt(((EditText)findViewById(R.id.sno)).getText().toString()), "id");

                   ((TextView)findViewById(R.id.result)).setText(student.sname.toString()+" "+student.cname.toString());


               }catch(Exception e)
               {
                   Log.d("student",e.getMessage());
               }
           }
        });
    }
}
