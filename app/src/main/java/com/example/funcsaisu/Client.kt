package com.example.funcsaisu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.funcsaisu.ClientDatabase.Client_e
import com.example.funcsaisu.UserDatabase.UserDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class Client : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)


//登録画面ボタンのリスナ
        val btnIn = findViewById<Button>(R.id.p_input)
        val c_in = Client_In_Listener()
        btnIn.setOnClickListener(c_in)


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
    private inner class Client_In_Listener : View.OnClickListener {
        override fun onClick(view: View) {
            GlobalScope.launch {
                val db = UserDatabase.getInstance(this@Client)
                val newClient = Client_e(0,
                    "平井明",
                    "江戸川区",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null)
                val c_Dao = db.clientDao()
                c_Dao.insert(newClient)
                //userDao.deleteAll()
                Log.v("TAG", "after insert ${c_Dao.getAll()}")

            }
            Toast.makeText(this@Client, R.string.dialog_ok_toast, Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}
