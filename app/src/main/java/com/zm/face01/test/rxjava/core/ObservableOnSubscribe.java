package com.zm.face01.test.rxjava.core;

/**
 * created by zm on 2024/6/12
 * 用了吧emitter和被观察者建立关系
 *
 * @Description:
 */
public interface ObservableOnSubscribe<T> {

    void subscribe(Emitter<T> emitter);
}
