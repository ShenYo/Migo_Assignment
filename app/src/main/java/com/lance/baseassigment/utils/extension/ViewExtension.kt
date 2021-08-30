package com.lance.baseassigment.utils

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2020/5/4
 */


fun View.showMessageToUser(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun Context.showMessageToUser(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}