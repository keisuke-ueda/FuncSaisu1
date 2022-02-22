package com.example.funcsaisu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Client_Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_menu)

        //値の受け取り
        val c_text = intent.getStringExtra("Client_name")
        val output = findViewById<TextView>(R.id.c_name)
        output.text = c_text

        //買取画面ボタンのリスナ
        val btnPurchase = findViewById<Button>(R.id.Purchase_btn)
        val lvPurchase = PurchaseListener()
        btnPurchase.setOnClickListener(lvPurchase)

        //荷物画面ボタンのリスナ
        val btnLoad = findViewById<Button>(R.id.Load_btn)
        val lvLoad = LoadListener()
        btnLoad.setOnClickListener(lvLoad)

        //廃棄画面ボタンのリスナ
        val btnWaste = findViewById<Button>(R.id.Waste_btn)
        val lvWaste = WasteListener()
        btnWaste.setOnClickListener(lvWaste)

        //顧客情報画面ボタンのリスナ
        val btnClient = findViewById<Button>(R.id.Client_btn)
        val lvClient = ClientListener()
        btnClient.setOnClickListener(lvClient)

        //確認画面ボタンのリスナ
        val btnConfirmation = findViewById<Button>(R.id.Confirmation_btn)
        val lvConfirmation = ConfirmationListener()
        btnConfirmation.setOnClickListener(lvConfirmation)


        // 戻るボタン機能を有効にする
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //戻るボタンの表示と処理
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal = true
        if (item.itemId == android.R.id.home){
            finish()
        }
        else{
            returnVal = super.onOptionsItemSelected(item)
        }
        return returnVal
    }

    //買取画面の表示
    private inner class PurchaseListener : View.OnClickListener {
        override fun onClick(view: View) {
            val intent = Intent(this@Client_Menu ,Purchase::class.java)
            startActivity(intent)
        }
    }

    //荷物画面の表示
    private inner class LoadListener : View.OnClickListener {
        override fun onClick(view: View) {
            val intent = Intent(this@Client_Menu ,Load::class.java)
            startActivity(intent)
        }
    }

    //廃棄画面の表示
    private inner class WasteListener : View.OnClickListener {
        override fun onClick(view: View) {
            val intent = Intent(this@Client_Menu ,Waste::class.java)
            startActivity(intent)
        }
    }

    //顧客画面の表示
    private inner class ClientListener : View.OnClickListener {
        override fun onClick(view: View) {
            val intent = Intent(this@Client_Menu ,Client::class.java)
            startActivity(intent)
        }
    }

    //確認画面の表示
    private inner class ConfirmationListener : View.OnClickListener {
        override fun onClick(view: View) {
            val intent = Intent(this@Client_Menu ,Confirmation::class.java)
            startActivity(intent)
        }
    }












}
