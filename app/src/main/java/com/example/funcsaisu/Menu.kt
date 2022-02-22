package com.example.funcsaisu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.funcsaisu.UserDatabase.User
import com.example.funcsaisu.UserDatabase.UserDatabase
import kotlinx.android.synthetic.main.activity_client_menu.*
import kotlinx.android.synthetic.main.activity_record.*
import kotlinx.android.synthetic.main.list_item.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList


@DelicateCoroutinesApi
class Menu : AppCompatActivity() {

    @SuppressLint("CutPasteId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //リサイクルビュー
        GlobalScope.launch {

            val db = UserDatabase.getInstance(this@Menu)
            val userDao = db.userDao()
            //val newUser = User(0, "teste", "上田敬介", null)
            //userDao.insert(newUser)
            var data: List<User> = userDao.getClient()
            //mtestlList = userDao.deleteAll()

            //Log.v("TAG", "after insert ${userDao.getClient()}")

            // RecyclerViewの取得
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            // LayoutManagerの設定
            recyclerView.layoutManager = LinearLayoutManager(this@Menu)
            // CustomAdapterの生成と設定
            val adapter1 = CustomAdapter1(data)
            recyclerView.adapter = adapter1

            // インターフェースの実装
            adapter1.setOnItemClickListener(object:CustomAdapter1.OnItemClickListener {
                override fun onItemClickListener(view: View, position: Int, clickedText: User) {

                    //トースト表示
                    Toast.makeText(applicationContext, "${clickedText}がタップされました", Toast.LENGTH_LONG).show()

                    //画面遷移
                    //val item = view.getItemAtPosition(position) as String
                    //val show = "選択した顧客は:$item"
                    //Toast.makeText(this@Menu,show,Toast.LENGTH_LONG).show()

                    val intent = Intent(this@Menu, Client_Menu::class.java)
                    intent.putExtra("Client_name",clickedText.clientName)
                    //intent.putExtra(,clickedText)
                    startActivity(intent)
                }
            })
        }


        //RoomDB作成
        /*
        GlobalScope.launch{
            val db = UserDatabase.getInstance(this@Menu)
            val userDao = db.userDao()
            val newUser = User(0, "Field-UP", "上田敬介", null)
            userDao.insert(newUser)
            //userDao.deleteAll()
            Log.v("TAG", "after insert ${userDao.getAll()}")
        }

        //動的リストの作成
        val data:ArrayList<Any> = arrayListOf()
        data += "Field-UP"
        //data -= "Field-UP"

        val listView = findViewById<ListView>(R.id.ClientList)
        val adapter = ArrayAdapter(this@Menu,android.R.layout.simple_list_item_1,data)
        listView.adapter = adapter

        //リストのリスナ
        val lvmate = findViewById<ListView>(R.id.ClientList)
        lvmate.onItemClickListener = ListItemClickListener()
         */


    //新規登録画面ボタンのリスナ
        val btnNew = findViewById<Button>(R.id.create_btn)
        val lvNew = NewListener()
        btnNew.setOnClickListener(lvNew)

    //コンテキストメニューリスナ
        //registerForContextMenu(lvmate)
        //registerForContextMenu(recyclerView)


    // 戻るボタン機能を有効にする
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //再表示したときのメソッド



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

    //新規登録画面の表示
    private inner class NewListener : View.OnClickListener {
        override fun onClick(view: View) {
            val intent = Intent(this@Menu, Record::class.java)
            startActivity(intent)
        }
    }

    //リストリスナの判定
    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>, view: View,
                                 position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as String
            //val show = "選択した顧客は:$item"
            //Toast.makeText(this@Menu,show,Toast.LENGTH_LONG).show()

            val intent = Intent(this@Menu, Client_Menu::class.java)
            intent.putExtra("Client_name",item)
            startActivity(intent)

        }
    }

    //コンテキストメニューを作る
    override fun onCreateContextMenu(menu: ContextMenu, view: View, menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu,view,menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
    }

    //コンテキストメニューの処理
    override fun onContextItemSelected(item: MenuItem): Boolean {
        //長押しされたビューに関する情報が格納されたオブジェクトを取得
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        //val listPosition = info.position
        //val menu = _lvmate[listPosition]

        when (item.itemId) {
            R.id.co_m1 -> {
                Toast.makeText(this@Menu,"コンテキスト", Toast.LENGTH_LONG).show()
            }
            R.id.co_m2 -> {
                //更新を押されたときの処理
            }
            R.id.co_m3 -> {

            }
        }
        return super.onContextItemSelected(item)
    }


    //ヘルパーの解放
    /*
    override fun onDestroy() {
        _helper.close()
        super.onDestroy()
    }
*/


}



