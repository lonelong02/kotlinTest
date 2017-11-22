package com.wesai.kotlin.greenDao

import com.wesai.kotlin.AppApplication

/**
 * Created by long on 2017/11/20.
 */
object GreenDaoFactory {
    var daoMaster: DaoMaster;
    var daoSession: DaoSession? = null;

    init {
        var tem = DaoMaster.DevOpenHelper(AppApplication.instance, "testDao");
        daoMaster = DaoMaster(tem.writableDb);
    }

    private fun getSession(): DaoSession? {
        if (daoSession == null) {
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
    /*添加*/
    fun insert(bean: GreenJava) {
        getSession()?.insert(bean);
    }

    /*修改*/
    fun update(bean: GreenJava) {
        getSession()?.update(bean);
    }

    /*查询全部*/
    fun loadAll(): List<GreenJava> {
        return getSession()?.greenJavaDao!!.loadAll();
    }

}