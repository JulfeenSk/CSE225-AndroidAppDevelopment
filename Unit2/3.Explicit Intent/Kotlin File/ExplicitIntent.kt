package com.examples.unit2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView


class ExplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        val editName = findViewById<EditText>(R.id.editName)
        val editPass = findViewById<EditText>(R.id.editPass)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editDate = findViewById<EditText>(R.id.editDate)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val btn = findViewById<Button>(R.id.btn_submit)
        val res = findViewById<TextView>(R.id.res)
        var spinner = findViewById<Spinner>(R.id.dropdown)


        var course = arrayOf("B-tech", "B.C.A.", "B.Sc.", "M.C.A.", "B.B.A.", "M.B.A.")

        var option = ""

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, course
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    option = course[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }


            btn.setOnClickListener()
            {
                val t1 = editName.text.toString()
                val t2 = editPass.text.toString()
                val t3 = editEmail.text.toString()
                val t4 = editDate.text.toString()
                val t5 = editPhone.text.toString()

                if (t1.isEmpty() || t2.isEmpty() ||
                    t3.isEmpty() || t4.isEmpty() || t5.isEmpty()
                ) {
                    res.text = "Enter All The Values"
                } else {
                    val intent = Intent(this,IntentDisplay::class.java)
                    intent.putExtra("name",t1)
                    intent.putExtra("pass",t2)
                    intent.putExtra("email",t3)
                    intent.putExtra("date",t4)
                    intent.putExtra("phone",t5)
                    intent.putExtra("course",option)
                    startActivity(intent)
                }
            }
        }
    }
}