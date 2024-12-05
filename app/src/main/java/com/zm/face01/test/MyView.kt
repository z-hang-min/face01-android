package com.zm.face01.test

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * created by zm on 2024/10/18

 * @Description:

 */
class MyView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("myview", "myview=onTouchEvent")
        return true
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.e("myview", "myview=dispatchTouchEvent")
        return super.dispatchTouchEvent(event)
    }
}