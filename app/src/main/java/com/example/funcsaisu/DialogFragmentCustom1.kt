package com.example.funcsaisu

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogFragmentCustom1 : DialogFragment() {
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val dialog = Dialog(context!!)
        val dw = dialog.window
        dw?.let {
            it.requestFeature(Window.FEATURE_NO_TITLE)
            it.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
            )
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.setContentView(R.layout.activity_dialog_fragment_custom1)
        //dialog.findViewById<TextView>(R.id.time_textView).text = ""
        dialog.findViewById<TextView>(R.id.OKbutton).setOnClickListener {
            //クリック時実行したい処理を記述
            val input = findViewById<EditText>(R.id.c_name)
            //Toast.makeText(context, input, Toast.LENGTH_SHORT).show()

            //動作デモではここでChromeCustomTabを開いています。
        }
        return dialog
    }

    private fun <T> findViewById(cName: Int) {
    }

}