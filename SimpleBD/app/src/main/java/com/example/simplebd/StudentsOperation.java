package com.example.simplebd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentsOperation {

    private SimpleBDWrapper dbHelper;
    private String[] STUDENT_TABLE_COLUMNS = {SimpleBDWrapper.STUDENTS_ID, SimpleBDWrapper.STUDENTS_NAME};
    private SQLiteDatabase database;

    public StudentsOperation(Context context) {
        this.dbHelper = new SimpleBDWrapper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public Student addStudent(String name){

        ContentValues values = new ContentValues();

        values.put(SimpleBDWrapper.STUDENTS_NAME, name);

        long studId = database.insert(SimpleBDWrapper.STUDENTS, null, values);

        Cursor cursor = database.query(SimpleBDWrapper.STUDENTS, STUDENT_TABLE_COLUMNS, SimpleBDWrapper.STUDENTS_ID + " = " + studId, null, null, null, null);
        cursor.moveToFirst();

        Student newComment = parseStudent(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteStudent(Student comment){
        long id = comment.getId();
        database.delete(SimpleBDWrapper.STUDENTS, SimpleBDWrapper.STUDENTS_ID + " = " + id, null);
    }

    public List getAllStudents(){

        List students = new ArrayList();

        Cursor cursor = database.query(SimpleBDWrapper.STUDENTS, STUDENT_TABLE_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Student student = parseStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();
        return students;
    }

    private Student parseStudent(Cursor cursor){

        Student student = new Student();
        student.setId(cursor.getInt(0));
        student.setName(cursor.getString(1));

        return student;
    }
}
