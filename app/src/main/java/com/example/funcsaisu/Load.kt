package com.example.funcsaisu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.funcsaisu.LoadDatabase.Load_e
import com.example.funcsaisu.UserDatabase.UserDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Load : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

//登録画面ボタンのリスナ
        val btnIn = findViewById<Button>(R.id.p_input)
        val l_in = Load_In_Listener()
        btnIn.setOnClickListener(l_in)


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
    private inner class Load_In_Listener : View.OnClickListener {
        override fun onClick(view: View) {

            GlobalScope.launch {
                val db = UserDatabase.getInstance(this@Load)
                val newLoad = Load_e(0,
                    "sutoaka",
                    "デスク",
                    "127",
                    "1"
                )
                val l_Dao = db.LoadDao()
                l_Dao.insert(newLoad)
                //userDao.deleteAll()
                Log.v("TAG", "after insert ${l_Dao.getAll()}")

            }
            Toast.makeText(this@Load, R.string.dialog_ok_toast, Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}