package com.sample.multiLibraryTest.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sample.mathLibrary.MyMath
import com.sample.multiLibraryTest.R
import com.sample.stringLibrary.MyString

class MainActivity : BaseActivity() {

    lateinit var button1: Button
    lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById<Button>(R.id.btn1)
        button2 = findViewById<Button>(R.id.btn2)

        button1.setOnClickListener {
            Log.d("AAAA", "랜덤 숫자 ... ${MyMath.getRandom(100)}")
        }
        button2.setOnClickListener {
            Log.d("AAAA", "랜덤 문자열 ... ${MyString.getRandom(100)}")
        }
    }
}