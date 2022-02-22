package com.example.funcsaisu
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog
import com.example.funcsaisu.UserDatabase.User
import com.example.funcsaisu.UserDatabase.UserDao
import com.example.funcsaisu.UserDatabase.UserDatabase
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class DialogFragment_1 : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = activity?.let{
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.dialog_title)
            builder.setMessage(R.string.dialog_msg)
            builder.setPositiveButton(R.string.dialog_btn_ok,DialogButtonClickListener())
            builder.setNegativeButton(R.string.dialog_btn_ng,DialogButtonClickListener())
            builder.create()
        }
        return dialog ?:throw IllegalStateException("nullです")
    }

    private inner class DialogButtonClickListener:DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface, which:Int) {
            var msg = ""
            when(which){
                DialogInterface.BUTTON_POSITIVE ->{

                    Toast.makeText(activity,"テスト",Toast.LENGTH_LONG).show()
                }
                DialogInterface.BUTTON_NEGATIVE ->{
                    msg = getString(R.string.dialog_ng_toast)
                    Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
