package com.zm.face01.test.rxjava.core;

/**
 * created by zm on 2024/6/12
 *
 * @Description:事件发射器
 */
public interface Emitter<T> {
    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
}
