package com.example.funcsaisu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.funcsaisu.UserDatabase.User
import com.example.funcsaisu.UserDatabase.UserDao
import com.example.funcsaisu.UserDatabase.UserDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class Record : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

        /*
        GlobalScope.launch{
            val db = UserDatabase.getInstance(this@Record)
            val userDao = db.userDao()
            val newUser = User(0, "Field-UP", "上田敬介", null)
            userDao.insert(newUser)
            //userDao.deleteAll()
            Log.v("TAG", "after insert ${userDao.getAll()}")
        }
         */


        //OKボタンのリスナ
        val btnOK = findViewById<Button>(R.id.OK_btn)
        val c_edit = findViewById<EditText>(R.id.c_name)
            //イベントリスナ
        btnOK.setOnClickListener {
            //バリデーションチェックの結果
            val check = validationCheck(c_edit)

            //エラーがない場合に登録完了
            if(check){
                User_In_Listener()
            }
        }

        /*
        //テストボタンのリスナ(通常ダイアログ)
        val btnDialog1 = findViewById<Button>(R.id.test_button)
        btnDialog1.setOnClickListener {Dialog1Listener()}

         */


        //テストボタンのリスナ(カスタムダイアログ)
        //val btnDialog2 = findViewById<Button>(R.id.test_button)
        //btnDialog2.setOnClickListener {Dialog2Listener()}




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

    //User追加
    @DelicateCoroutinesApi
    private fun User_In_Listener() {

        GlobalScope.launch {
            val c_edit = findViewById<EditText>(R.id.c_name)
            val item = c_edit.text.toString()

            val db = UserDatabase.getInstance(this@Record)
            val newUser = User(0, item, "上田敬介", null)
            val userDao = db.userDao()
            userDao.insert(newUser)
            //userDao.deleteAll()
            //Log.v("TAG", "after insert ${userDao.getAll()}")

        }
            Toast.makeText(this@Record,R.string.dialog_ok_toast,Toast.LENGTH_SHORT).show()

            finish()
    }

    /*
    //Dialog1の表示
    private fun Dialog1Listener() {
        val dialogFragment = DialogFragment_1()
        dialogFragment.show(supportFragmentManager, "[DialogFragmet]")
        }

     */

    //Dialog2の表示

    private fun Dialog2Listener() {
        val dialogFragment = DialogFragmentCustom1()
        dialogFragment.show(supportFragmentManager, "[DialogFragmetAc2]")
        }


    //バリデーションチェックメソッド
    private fun validationCheck(id_et : EditText) : Boolean{
        //IDの入力値がない場合
        if(id_et.text.toString().isEmpty()){
            //IDの入力エリアをフォーカスさせる
            id_et.requestFocus()
            //画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "値を入力してください。", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}