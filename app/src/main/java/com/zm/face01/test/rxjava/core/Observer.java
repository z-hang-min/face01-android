package com.zm.face01.test.rxjava.core;

/**
 * created by zm on 2024/6/12
 * 观察者
 *
 * @Description:
 */
public interface Observer<T> {
    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
    void onSubscribe();
}
