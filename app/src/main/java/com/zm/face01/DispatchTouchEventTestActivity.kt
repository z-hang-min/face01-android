package com.zm.face01

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import com.zm.face01.databinding.ActivityDispatchTouchEventTestBinding
import com.zm.face01.utils.showToast

class DispatchTouchEventTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityDispatchTouchEventTestBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDispatchTouchEventTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.clContent.setOnClickListener {
//            showToast("clContent")
//        }
//        binding.myview.setOnClickListener {
//            showToast("myview")
//        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("dis", "activity==dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("dis", "activity==onTouchEvent")
//        var x = 0f
//        var y = 0f
//
//        if (event?.action == MotionEvent.ACTION_DOWN) {
//            x = event.x
//            y = event.y
//            Log.e("dis", "activity==ACTION_DOWN-x=$x---y=$y")
//        } else if (event?.action == MotionEvent.ACTION_MOVE) {
//            x = event.x
//            y = event.y
//            Log.e("dis", "activity==ACTION_MOVE-x=$x---y=$y")
//        } else if (event?.action == MotionEvent.ACTION_UP) {
////            x = 0f
////            y = 0f
//            Log.e("dis", "activity==ACTION_UP-x=$x---y=$y")
//        } else {
////            x = 0f
////            y = 0f
//            Log.e("dis", "activity==ACTION_CANCle-x=$x---y=$y")
//        }
        return super.onTouchEvent(event)
    }
}