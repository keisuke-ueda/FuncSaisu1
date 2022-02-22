package com.example.funcsaisu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.funcsaisu.PurchaseDatabase.Purchase_e
import com.example.funcsaisu.UserDatabase.UserDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class Purchase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)

//登録画面ボタンのリスナ
        val btnIn = findViewById<Button>(R.id.p_input)
        val p_in = Purchase_In_Listener()
        btnIn.setOnClickListener(p_in)


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

    //登録機能
    @DelicateCoroutinesApi
    private inner class Purchase_In_Listener : View.OnClickListener {
        override fun onClick(view: View) {

            GlobalScope.launch {
                val db = UserDatabase.getInstance(this@Purchase)
                val newPurchase = Purchase_e(0,
                    "明彰",
                    "デスク",
                    "127",
                    "1"
                    )
                val p_Dao = db.purchaseDao()
                p_Dao.insert(newPurchase)
                //userDao.deleteAll()
                Log.v("TAG", "after insert ${p_Dao.getAll()}")

            }
            Toast.makeText(this@Purchase, R.string.dialog_ok_toast, Toast.LENGTH_SHORT).show()

            finish()
        }
    }





}