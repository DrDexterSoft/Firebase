package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var ref1: DatabaseReference
    lateinit var ref2: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ref1=FirebaseDatabase.getInstance().getReference("pruebas/texto1")
        ref2=FirebaseDatabase.getInstance().getReference("pruebas/texto2")

        button.setOnClickListener(){
            ref1.setValue(edit1.text.toString())
            ref2.setValue(edit2.text.toString())
        }

        ref1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                textView2.setText(""+ value)}
            override fun onCancelled(error: DatabaseError) {textView2.setText("Error al leer datos")}
        })

        ref2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                textView.setText(""+ value)}
            override fun onCancelled(error: DatabaseError) {textView2.setText("Error al leer datos")}
        })
    }


}