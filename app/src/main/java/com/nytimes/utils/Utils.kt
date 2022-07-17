package com.nytimes.utils

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.nytimes.R
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc Utils class used for utility operations and methods
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */

@Singleton
open class Utils @Inject constructor(val context: Context) {

     fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        return true
                    }
                }
            } else {
                try {
                    val activeNetworkInfo = connectivityManager.activeNetworkInfo
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                        AppLog.debugI("update_status", "Network is available : true")
                        return true
                    }
                } catch (e: java.lang.Exception) {
                    AppLog.debugI("update_status", "${e.message}")
                }
            }
        }
        AppLog.debugI("update_status", "Network is available : FALSE ")
        return false
    }


    /**
     * @author Misbah
     * @desc This function is used to show Toast Message
     */
    fun showToast(respMsg: String) {
        try {
            Toast.makeText(context, respMsg, Toast.LENGTH_SHORT)
                .show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * @author Misbah
     * @desc This function is used to show Snakebar with provided message
     */
    fun showSnakeBar(view: View, msg: String) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
    }

    fun showMessageDialog(context: Context, msg: String?) {
        val myAlertDialog = AlertDialog.Builder(context)
        myAlertDialog.setTitle(context.getString(R.string.dlg_title_alert))
        myAlertDialog.setCancelable(false)
        myAlertDialog.setMessage(msg)
        myAlertDialog.setPositiveButton(context.getString(R.string.dlg_btn_ok)) { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = myAlertDialog.create()
        dialog.show()
    }

}