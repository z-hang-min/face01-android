package com.zm.face01.test.rxjava;


import java.io.Serializable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * created by zm on 2024/6/4
 *
 * @Description: rxjava的操作符
 */
class CreateOperatorDemo {
    public static void main(String[] args) {
        CreateOperatorDemo createOperatorDemo = new CreateOperatorDemo();
//        createOperatorDemo.test1();
        createOperatorDemo.test2();

    }
    Observer observer=   new Observer<Object>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            System.out.println("onSubscribe");


        }

        @Override
        public void onNext(@NonNull Object o) {
            System.out.println("onNext"+o);

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

    private void test1() {
        Observable observable = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                //事件产生的地方
                emitter.onNext("onNext01");
                emitter.onNext("onNext02");
                emitter.onNext("onNext03");
                emitter.onError(new Throwable("手动异常"));
                emitter.onComplete();
                //耗时操作
                //网络请求
                //异步操作

            }
        });
//observer


       //consumer
        Disposable disposable = observable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Throwable {
                System.out.println("accept");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                System.out.println("accept2");
            }
        });
    }

    private void test2() {
        //
       Observable.just("1", "222", 234).subscribe(observer);
       Observable.fromArray("fromarray1", "fromarray2", 2343,"hellj",1,2,3,4).subscribe(observer);
    }
}
