package com.zm.face01.test.surface

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import com.zm.face01.R
import com.zm.face01.databinding.ActivitySurfaceViewBinding
import java.util.Random

class SurfaceViewActivity : AppCompatActivity(), SurfaceHolder.Callback {
    private lateinit var viewBinding: ActivitySurfaceViewBinding
    private lateinit var mSurfaceHolder: SurfaceHolder
    private lateinit var mThread: Thread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySurfaceViewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        mSurfaceHolder = viewBinding.surfaceview.holder
        mSurfaceHolder.addCallback(this)
    }

    private var mIsDrawing = false
    override fun surfaceCreated(holder: SurfaceHolder) {
        mIsDrawing = true
//surfaceview 创建时调用，可以在这里进行绘制初始化操作
        //进行实际的绘制操作，需要获取canvas对象，代码如下
        val canvas = holder.lockCanvas()
        val paint = Paint()
        paint.color = Color.RED
//        canvas.drawRect(100f, 100f, 200f, 200f, paint)
        mThread = Thread {
            while (mIsDrawing) {
                val start = System.currentTimeMillis()
                draw(canvas, paint,holder)
                val end = System.currentTimeMillis()
                if (end - start < 16) {
                    Thread.sleep(16 - (end - start))
                }
            }
        }
        mThread.start()


    }

    fun draw(canvas: Canvas, paint: Paint,holder:SurfaceHolder) {
        try {
            val random = Random()
            val points = arrayListOf<Point>()
            for (i in 1..10) {
                val x = random.nextInt(canvas.width)
                val y = random.nextInt(canvas.height)
                points.add(Point(x, y))
            }
            val length=points.size
            for (item in 0..<length-1) {
                val p1 = points[item]
                val p2 = points[item + 1]
                canvas.drawLine(p1.x.toFloat(), p1.y.toFloat(), p2.x.toFloat(), p2.y.toFloat(), paint)

            }
            holder.unlockCanvasAndPost(canvas)
        } catch (e: Exception) {
        }


    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
//surfaceview尺寸变化时调用，可以在这里进行布局调整操作

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        ///surfaceview销毁时进行资源释放操作
        mIsDrawing = false
        try {
            mThread.join()
        } catch (e: Exception) {
        }

    }
}