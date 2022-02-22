package com.example.funcsaisu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class Waste : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waste)

//登録画面ボタンのリスナ
        val btnIn = findViewById<Button>(R.id.p_input)
        val lvIn = InListener()
        btnIn.setOnClickListener(lvIn)


// 戻るボタン機能を有効にする
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    //戻るボタンの表示と処理
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal = true
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            returnVal = super.onOptionsItemSelected(item)
        }
        return returnVal
    }

    //登録画面の表示
    private inner class InListener : View.OnClickListener {
        override fun onClick(view: View) {
            Toast.makeText(this@Waste, "登録しました", Toast.LENGTH_LONG).show()
        }

    }
}