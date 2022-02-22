package com.example.funcsaisu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//メニュー画面ボタンのリスナ
        val btnNew = findViewById<Button>(R.id.mainBtn)
        val lvNew = NewListener()
        btnNew.setOnClickListener(lvNew)

    }

    //メニュー画面の表示
    private inner class NewListener : View.OnClickListener {
        override fun onClick(view: View) {
            val intent = Intent(this@MainActivity, Menu::class.java)
            startActivity(intent)
        }
    }

}