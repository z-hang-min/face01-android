package com.zm.face01.test.rxjava;

import androidx.annotation.NonNull;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * created by zm on 2024/6/6
 *
 * @Description:转化操作符
 */
class MergeOperatorDemo {

    public static void main(String[] args) {
        MergeOperatorDemo transOperatorDemo = new MergeOperatorDemo();
        transOperatorDemo.testContact();

    }

    void testContact() {
        Observable.concat(Observable.just("01","02"), Observable.fromArray("222", 333)).buffer(10).subscribe(observer);

    }
    void testZip(){
//        Observable.zip(new ObservableSource<Object>() {
//            @Override
//            public void subscribe(@io.reactivex.rxjava3.annotations.NonNull Observer<? super Object> observer) {
//
//            }
//        }){
//
//        }

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

}
