package com.leandro1995.mvi.util

import android.app.Activity
import com.leandro1995.mvi.config.callback.WarningCallBack
import com.leandro1995.mvi.dialog.WarningDialog

class DialogUtil {

    companion object {

        fun warningDialog(activity: Activity, message: String) {

            WarningDialog(activity = activity, message = message).apply {

                warningCallBack = object : WarningCallBack {

                    override fun acceptButton() {

                        cancel()
                    }
                }

                show()
            }
        }
    }
}