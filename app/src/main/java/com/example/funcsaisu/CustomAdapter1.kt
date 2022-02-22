package com.example.funcsaisu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.funcsaisu.UserDatabase.User


class CustomAdapter1(private val testlList: List<User>): RecyclerView.Adapter<CustomAdapter1.ViewHolder>() {

    //リスナー格納変数
    lateinit var listener: OnItemClickListener

    //インスタンス化
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val ttt1 : TextView

        init {
            ttt1 = view.findViewById(R.id.test1)
        }
    }

    // 表示の値を返す
    override fun getItemCount() = testlList.size

    //レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }

    //インスタンスに値を渡す
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val alist = testlList[position]
        viewHolder.ttt1.text = alist.clientName
        // タップしたとき
        viewHolder.view.setOnClickListener {listener.onItemClickListener(it, position, alist)
        }
    }

    //インターフェースの作成
    interface OnItemClickListener{
        fun onItemClickListener(view: View, position: Int, clickedText: User)
    }

    // リスナー
    fun setOnItemClickListener(listener: OnItemClickListener){
        this@CustomAdapter1.listener = listener
    }
}

