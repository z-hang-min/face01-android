package com.zm.face01.test

/**
 * created by zm on 2024/5/22

 * @Description:

 */
class Student {
    private var name = ""
    private var age = 0
    private var score = 0

    constructor(name: String, age: Int, score: Int) {
        this.name = name
        this.age = age
        this.score = score
    }

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