package com.zm.face01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import com.zm.face01.databinding.ActivityMainBinding
import com.zm.face01.test.Student
import com.zm.face01.test.TestHandlerActivity
import com.zm.face01.test.surface.SurfaceViewActivity

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val student01 = Student("piter", 10, 100)
        val student02 = Student("piter", 10, 90)
        Log.e("test", "${student01 == student02}")
        //thread 的实现方式 runnable 继承Thread

        val thread = TestThread()
        Log.e("test", "${thread.name}")
        thread.start()
        val thread2 = Thread {
            Log.e("test", "i am implentes Runnable")
        }
        with(binding) {
            btnTest.setOnClickListener(this@MainActivity)
            btnSurfaceview.setOnClickListener(this@MainActivity)
        }

    }

    class TestThread : Thread() {
        override fun run() {
            super.run()
            Log.e("test", "i am extends Thread")
        }

    }

    override fun onClick(v: View?) {
        with(binding) {
            if (v != null) {
                when (v.id) {
                    R.id.btn_test -> {
                        startActivity(Intent(this@MainActivity, TestHandlerActivity::class.java))

                    }

                    R.id.btn_surfaceview -> {
                        startActivity(Intent(this@MainActivity, SurfaceViewActivity::class.java))

                    }

                    else -> {}


                }
            }
        }

    }
}

