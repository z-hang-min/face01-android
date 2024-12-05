package com.zm.face01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zm.face01.databinding.ActivityMainBinding
import com.zm.face01.test.H5Activity
import com.zm.face01.test.Student
import com.zm.face01.test.TestHandlerActivity
import com.zm.face01.test.eventbus.LoginEvent
import com.zm.face01.test.handler.HandlerTestActivity
import com.zm.face01.test.rxjava.TestRxjavaActivity
import com.zm.face01.test.surface.SurfaceViewActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    val list = arrayListOf<String>(
        "111",
        "222",
        "333",
        "4444",
        "5kkkjkj",
        "6kkkjkj",
        "7kkkjkj",
        "8kkkjkj",
        "9kkkjkj",
        "10kkkjkj",
    )
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val student01 = Student("piter", 10, 100)
        val student02 = Student("piter", 10, 90)
        //main test
        Log.e("test", "${student01 == student02}")
        thread 的实现方式 runnable 继承Thread

        val thread = TestThread()
        Log.e("test", "${thread.name}")
        thread.start()
        val thread2 = Thread {
            Log.e("test", "i am implentes Runnable")
        }
        with(binding) {

            val manager = GridLayoutManager(this@MainActivity, 3)
            binding.recycler.layoutManager = manager
            mainAdapter = MainAdapter(this@MainActivity, list)
            binding.recycler.adapter = mainAdapter
            binding.recycler.itemAnimator = MainItemAnimator()
            btnTest.setOnClickListener(this@MainActivity)
            btnSurfaceview.setOnClickListener(this@MainActivity)
            btnRxjava.setOnClickListener(this@MainActivity)
            btnDisp.setOnClickListener(this@MainActivity)
            btnHandler.setOnClickListener(this@MainActivity)
            btnWebview.setOnClickListener(this@MainActivity)
        }
        EventBus.getDefault().register(this)


    }

    class TestThread : Thread() {
        override fun run() {
            super.run()
            Log.e("test", "i am extends Thread")
        }

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    fun onEvent(event: LoginEvent) {
//        binding.btnHandler.text = "eventBus"
        println("hhhh--" + Thread.currentThread().name)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
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

                    R.id.btn_rxjava -> {
                        startActivity(Intent(this@MainActivity, TestRxjavaActivity::class.java))

                    }

                    R.id.btn_disp -> {
                        startActivity(
                            Intent(
                                this@MainActivity,
                                DispatchTouchEventTestActivity::class.java
                            )
                        )

                    }

                    R.id.btn_handler -> {
                        startActivity(
                            Intent(
                                this@MainActivity,
                                HandlerTestActivity::class.java
                            )
                        )

                    }

                    R.id.btn_webview -> {
//                        startActivity(
//                            Intent(
//                                this@MainActivity,
//                                H5Activity::class.java
//                            )
//                        )
                        list.removeAt(2)
                        mainAdapter.removeItem(2)

                    }

                    else -> {}


                }
            }
        }

    }
}

