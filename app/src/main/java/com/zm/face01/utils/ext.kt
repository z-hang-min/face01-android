package com.zm.face01.utils

import android.content.Context
import android.widget.Toast

/**
 * created by zm on 2024/10/18

 * @Description:

 */


fun Context.showToast(des: String) {
    Toast.makeText(this, des, Toast.LENGTH_SHORT).show()
}