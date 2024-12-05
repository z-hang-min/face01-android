package com.zm.face01.test.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.provider.CalendarContract.Colors
import android.util.AttributeSet
import android.view.View
import kotlin.math.sqrt

/**
 * created by zm on 2024/10/22

 * @Description:

 */
class MyCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) :
    View(context, attrs, defStyleAttr) {
    private var mPaint: Paint = Paint()

    init {
        mPaint.color = Color.RED
        mPaint.strokeWidth = 3f

    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(0f, 0f, (height / 2).toFloat(), (width / 2).toFloat(), mPaint)
        val rectF = RectF()
        rectF.left = width / 3f
        rectF.right = width / 1f
        rectF.top = 0f
        rectF.bottom = height / 3f
        mPaint.style = Paint.Style.STROKE
        canvas.drawRect(rectF, mPaint)
        mPaint.strokeWidth = 5f

        canvas.drawCircle(width / 2f, height / 2f, width / 3f, mPaint)
        mPaint.color = Color.GREEN
        mPaint.textSize = 20f
        canvas.drawText("hello,swetty", width / 2f, height / 2f, mPaint)
    }
}