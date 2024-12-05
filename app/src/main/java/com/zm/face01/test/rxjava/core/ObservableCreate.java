package com.zm.face01.test.rxjava.core;

/**
 * created by zm on 2024/6/12
 *
 * @Description:手写create操作符
 */
class ObservableCreate<T> extends Observable<T> {
    final ObservableOnSubscribe<T> source;

    ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    void subscribeActual(Observer observer) {
        observer.onSubscribe();
        CreateEmitter<T> createEmitter = new CreateEmitter<>(observer);
        source.subscribe(createEmitter);


    }

    static class CreateEmitter<T> implements Emitter<T> {
        Observer<T> observer;//观察者
        boolean done;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            if (done) return;
            observer.onNext(t);

        }

        @Override
        public void onComplete() {
            if (done) return;
            observer.onComplete();
            done = true;

        }

        @Override
        public void onError(Throwable throwable) {
            if (done) return;
            observer.onError(throwable);
            done = true;
        }
    }
}
