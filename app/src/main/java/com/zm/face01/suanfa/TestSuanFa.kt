package com.zm.face01.suanfa

/**
 * created by zm on 2024/11/20

 * @Description:

 */
object TestSuanFa {
    fun sortSf(arry: Array<Int>) {
        for (i in arry.indices) {
            for (j in 0 until arry.size - i - 1) {
                var tem = 0
                if (arry[j] > arry[j + 1]) {
                    tem = arry[j]
                    arry[j] = arry[j + 1]
                    arry[j + 1] = tem
                }
            }

        }

    }
}