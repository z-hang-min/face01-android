package com.zm.face01.test.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.viewbinding.ViewBinding
import com.zm.face01.databinding.ActivityHandlerTestBinding
import com.zm.face01.test.eventbus.LoginEvent
import org.greenrobot.eventbus.EventBus
import kotlin.concurrent.thread

class HandlerTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandlerTestBinding
    private var handler: Handler = Handler(Looper.getMainLooper(), object : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            binding.tvContent.text = msg.obj.toString()
            return false
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnSend.setOnClickListener {
                val msg = Message.obtain()
                msg.what = 1
                msg.obj = "hello"
                handler.sendMessage(msg)
                handler.postDelayed({ tvContent.setText("hhhhh") }, 1000L)
            }
            btnTest.setOnClickListener {
                thread {
                    EventBus.getDefault().post(LoginEvent("ttttt"))
                }

            }
        }

    }
}