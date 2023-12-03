package com.example.database_connection

import android.widget.Toast
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: MyDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = MyDatabaseHelper(this)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextCourse: EditText = findViewById(R.id.editTextCourse)
        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener{
            val name = editTextName.text.toString()
            val course = editTextCourse.text.toString()

            //Insert values in database

            dbHelper.insertData(name,course)

            //clear input fields if needed

            editTextName.text.clear()
            editTextCourse.text.clear()
        }
    }


    fun insertDataAndShowToast(name: String, course: String) {
        val dbHelper = MyDatabaseHelper(this)
        val id = dbHelper.insertData(name, course)

        if (id > 0) {
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show()
        }
    }
}