package com.zm.face01.test.rxjava.core;

/**
 * created by zm on 2024/6/12
 *
 * @Description: 被观察者
 */
public abstract class Observable<T> implements ObservableSource<T> {
    @Override
    public void subscribe(Observer observer) {
        //和谁建立订阅，怎么订阅，
        //为了保证拓展性，交给具体的开发人员实现，这里提供一个抽象的方法
        subscribeActual(observer);

    }

    abstract void subscribeActual(Observer observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
        return new ObservableCreate<>(source);

    }
}
