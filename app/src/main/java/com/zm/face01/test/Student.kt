package com.zm.face01.test

/**
 * created by zm on 2024/5/22

 * @Description:

 */
class Student(var name: String, var age: Int, var score: Int, var list: List<Course>) {

    override fun equals(other: Any?): Boolean {
        if (other is Student) {
            if (name == other.name && age == other.age)
                return true
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return 1000
    }

}

class Course(var name: String) {
    override fun toString(): String {
        return name
    }
}