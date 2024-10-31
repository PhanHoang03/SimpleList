package com.example.simplelist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber: EditText
    private lateinit var rbEven: RadioButton
    private lateinit var rbOdd: RadioButton
    private lateinit var rbSquare: RadioButton
    private lateinit var btnShow: Button
    private lateinit var tvError: TextView
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber = findViewById(R.id.etNumber)
        rbEven = findViewById(R.id.rbEven)
        rbOdd = findViewById(R.id.rbOdd)
        rbSquare = findViewById(R.id.rbSquare)
        btnShow = findViewById(R.id.btnShow)
        tvError = findViewById(R.id.tvError)
        listView = findViewById(R.id.listView)

        btnShow.setOnClickListener {
            val input = etNumber.text.toString()

            if (input.isEmpty()) {
                tvError.text = "Hay nhap mot so."
                return@setOnClickListener
            }

            val n = input.toIntOrNull()
            if (n == null || n <= 0) {
                tvError.text = "Hay nhap mot so nguyen duong."
                return@setOnClickListener
            }

            tvError.text = ""
            val resList = mutableListOf<Int>()

            when {
                rbEven.isChecked -> {
                    for (i in 0..n step 1) {
                        if (i % 2 == 0) resList.add(i)
                    }
                }
                rbOdd.isChecked -> {
                    for (i in 0..n step 1) {
                        if (i % 2 == 1) resList.add(i)
                    }
                }
                rbSquare.isChecked -> {
                    var i = 0
                    while (i * i <= n) {
                        resList.add(i * i)
                        i++
                    }
                }
                else -> {
                    tvError.text = "Hay chon mot loai so."
                    return@setOnClickListener
                }
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resList)
            listView.adapter = adapter
        }
    }
}
