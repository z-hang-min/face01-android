package com.zm.face01.test.rxjava.core;

/**
 * created by zm on 2024/6/12
 * 被观察者的顶层接口
 *
 * @Description:
 */
public interface ObservableSource<T> {
    /**
     * addObserver
     *
     * @author zm
     * create at 2024/6/12 10:02
     **/
    void subscribe(Observer observer);
}
