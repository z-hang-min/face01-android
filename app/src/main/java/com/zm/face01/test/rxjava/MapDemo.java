package com.zm.face01.test.rxjava;

import android.util.Log;

import com.zm.face01.test.Course;
import com.zm.face01.test.Student;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * created by zm on 2024/6/12
 *
 * @Description:
 */
class MapDemo {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            Course course = new Course("历史咳j" + i);
            courses.add(course);
            for (int j = 0; j < 1; j++) {

                Student student = new Student("name" + j, j, j + 10, courses);
                students.add(student);

            }
        }
        Observable.fromIterable(students).flatMap(new Function<Student, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Student student) throws Throwable {
                return Observable.fromIterable(student.getList());
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Throwable {
                System.out.println(o);

            }
        });
    }
}
