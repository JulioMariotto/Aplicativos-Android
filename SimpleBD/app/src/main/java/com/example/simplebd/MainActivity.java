package com.example.simplebd;

import android.icu.util.ValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentsOperation studentsDBoperations;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentsDBoperations = new StudentsOperation(this);
        studentsDBoperations.open();

        List values = studentsDBoperations.getAllStudents();
        //List values = new ArrayList();
        //values.add(new Student(0 , "Julio"));
        //values.add(new Student(1, "Leticia"));

        list = findViewById(R.id.list);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);

        list.setAdapter(adapter);
    }

    public void addUser(View view){

        ArrayAdapter adapter = (ArrayAdapter) list.getAdapter();

        EditText edt = findViewById(R.id.editText);
        Student student = studentsDBoperations.addStudent(edt.getText().toString());

        adapter.add(student);
    }

    public void deleteFirstStudent (View view) {

        ArrayAdapter adapter = (ArrayAdapter) list.getAdapter();

        Student stud = null;
        if(list.getAdapter().getCount() > 0){
            stud = (Student) list.getAdapter().getItem(0);
            studentsDBoperations.deleteStudent(stud);
            adapter.remove(stud);
        }
    }

    @Override
    protected void onResume() {
        studentsDBoperations.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        studentsDBoperations.close();
        super.onPause();
    }
}
