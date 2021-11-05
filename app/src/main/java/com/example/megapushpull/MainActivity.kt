package com.example.megapushpull

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val age = findViewById<EditText>(R.id.age)
        val city = findViewById<EditText>(R.id.city)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val addData = MyRecord(fname = name.text.toString().trim(),fage = age.text.toString().trim(),fcity = city.text.toString().trim())
            db.collection("pushrepo").add(addData)
                .addOnSuccessListener {
                Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"failure",Toast.LENGTH_LONG).show()
                }
        }
    }
}