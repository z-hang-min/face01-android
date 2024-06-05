package com.zm.face01.test.rxjava;

import androidx.annotation.NonNull;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * created by zm on 2024/6/5
 *
 * @Description: rxjava 转换操作符
 */
class TransOperatorDemo {
    public static void main(String[] args) {
        TransOperatorDemo transOperatorDemo = new TransOperatorDemo();
        transOperatorDemo.testMap();

    }

    Observer observer = new Observer<Object>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            System.out.println("onSubscribe");


        }

        @Override
        public void onNext(@NonNull Object o) {
            System.out.println("onNext:  " + o);

        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println("onError");

        }

        @Override
        public void onComplete() {
            System.out.println("onComplete");

        }
    };

    private void testMap() {
        //直接对发射出来的事件进行处理并且产生新的事件，再次发射
        Observable observable = Observable.just("111", "222");
        observable.map(new Function<String, Object>() {
            @Override
            public Object apply(String s) throws Throwable {
                System.out.println("接受到的被观察者发射的数据s==" + s);
                return "map处理后的事件" + s;
            }
        }).subscribe(observer);
        //网络请求使用，注册成功后，用发挥作用的数据再去请求登录，最终把数据传递给观察者
        observable.flatMap(new Function<String, ObservableSource<?>>() {

            @Override
            public ObservableSource<?> apply(String s) throws Throwable {
                return Observable.just("no money");
            }
        }).subscribe(observer);

    }

}
