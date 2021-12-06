package com.leandro1995.mvi.dialog

import android.app.Activity
import android.app.AlertDialog
import android.widget.Button
import android.widget.TextView
import com.leandro1995.mvi.R
import com.leandro1995.mvi.config.callback.WarningCallBack

class WarningDialog constructor(activity: Activity, message: String) {

    private val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
    private var alertDialog: AlertDialog

    lateinit var warningCallBack: WarningCallBack

    init {
        val view = activity.layoutInflater.inflate(R.layout.dialog_warning, null)

        view.apply {

            findViewById<TextView>(R.id.messageText).text = message
            findViewById<Button>(R.id.acceptButton).setOnClickListener {
                warningCallBack.acceptButton()
            }
        }

        builder.setView(view)
        alertDialog = builder.create()
    }

    fun show() {

        alertDialog.show()
    }

    fun cancel() {

        alertDialog.cancel()
    }
}