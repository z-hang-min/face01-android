package com.zm.face01.test.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zm.face01.R
import com.zm.face01.test.rxjava.core.Emitter
import com.zm.face01.test.rxjava.core.Observable
import com.zm.face01.test.rxjava.core.ObservableOnSubscribe
import com.zm.face01.test.rxjava.core.Observer

class TestRxjavaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_rxjava)
        var list = mutableListOf<String>()
        repeat(10) {
            list.add("jjjj--$it")
        }
        Observable.create { emitter ->
            emitter?.onNext("ssssss")
            emitter?.onNext("222")
            emitter?.onNext("3333")
            emitter?.onComplete()
        }.subscribe(object : Observer<Any> {
            override fun onNext(t: Any?) {
                Log.i("TAG", "onNext")
            }

            override fun onComplete() {
                Log.i("TAG", "onComplete")
            }

            override fun onError(throwable: Throwable?) {
                Log.i("TAG", "onError")
            }

            override fun onSubscribe() {
                Log.i("TAG", "onSubscribe")
            }
        })

    }
}