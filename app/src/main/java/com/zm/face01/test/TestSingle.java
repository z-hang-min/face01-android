package com.zm.face01.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created by zm on 2024/5/23
 *
 * @Description:
 */
class TestSingle {
    private static volatile TestSingle _instance;

    private TestSingle() {
        ExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(2);
        ArrayList<String> list=new ArrayList<>();
        list.add("");
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("hello");
        linkedList.add(10,"hello");
    }

    public static synchronized TestSingle getInstance() {
        if (_instance == null) {
            synchronized (TestSingle.class) {
                if (_instance == null) {
                    _instance = new TestSingle();

                }

            }
        }
        return _instance;
    }
}
