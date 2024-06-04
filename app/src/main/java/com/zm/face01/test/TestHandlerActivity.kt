package com.zm.face01.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import com.zm.face01.R
import com.zm.face01.databinding.ActivityTestHandlerBinding

class TestHandlerActivity : AppCompatActivity() {
    private lateinit var mHandlerThread: HandlerThread
    private lateinit var handler1: Handler
    private lateinit var handler: Handler
    private lateinit var viewBinding: ActivityTestHandlerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityTestHandlerBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)
        mHandlerThread = HandlerThread("test")
        mHandlerThread.start()
        handler1 = Handler(Looper.getMainLooper())
        handler = Handler(Looper.getMainLooper())
        handler.post {
            viewBinding.tvShow.text = "ssshell"
        }
        handler1.postDelayed({
            viewBinding.tvShow.text = "ssshelldelay"
        },3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandlerThread.quit()
    }
}