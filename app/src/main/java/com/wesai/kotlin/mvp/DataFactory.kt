package com.wesai.kotlin.mvp

/**
 * Created by long on 2017/12/7.
 */
class DataFactory {

    private constructor() {}

    companion object {
        var inst: DataFactory? = null;

        fun getInstance(): DataFactory? {
            if (inst == null) {
                inst = DataFactory();
            }
            return inst;
        }
    }

    fun loadData(): String {
        return "网络加载来的数据"
    }
}