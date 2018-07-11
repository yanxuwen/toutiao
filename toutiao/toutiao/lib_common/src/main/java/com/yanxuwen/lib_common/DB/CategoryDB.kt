package com.yanxuwen.lib_common.DB

import android.content.ContentValues
import android.content.Context
import com.google.gson.Gson
import com.yanxuwen.Base.DB.DBcolumns
import com.yanxuwen.Base.DB.MyDB
import com.yanxuwen.lib_common.retrofit.model.Category.Category
import com.yanxuwen.retrofit.GsonUtils
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by yanxuwen on 2018/7/4.
 */
class CategoryDB : MyDB {
    constructor(context: Context) : super(context,"测试帐号") {
        onCreateTable("table_category_");
    }

    fun onWrite(list: List<Category.DataBeanX.DataBean>, isAll: Boolean) {
        if (isAll) {
            onDelete()
        }
        if(list==null){
            return
        }
        val SQLdb = onOpenWrite()
        Observable.create(Observable.OnSubscribe<Void> { subscriber ->
            for (databean in list) {
                val id = databean.concern_id
                val values = ContentValues()
                values.put(DBcolumns.ID, id)
                val gson = Gson()
                val json = gson.toJson(databean)
                values.put(DBcolumns.json, json)
                SQLdb.insert(tableName, id, values)
            }

            subscriber.onNext(null)
            subscriber.onCompleted()
        })
                .subscribeOn(Schedulers.io()) //事件发送，即图片加载在IO线程
                .observeOn(AndroidSchedulers.mainThread())  //事件处理，即图片显示在UI线程
                .subscribe(object : Subscriber<Void>() {
                    override fun onCompleted() {}

                    override fun onError(e: Throwable) {
                        SQLdb.close()
                    }

                    override fun onNext(aVoid: Void) {
                        SQLdb.close()
                    }
                })
    }

    fun onReadAll(): List<Category.DataBeanX.DataBean>? {
        val list = ArrayList<Category.DataBeanX.DataBean>()
        val c = onQuery(tableName) ?: return null
        c.moveToFirst()
        if (c.count > 0) {
            do {
                val map = HashMap<String, String>()
                for (i in 0 until c.columnCount) {
                    map.put(c.getColumnName(i), c.getString(i))
                }
                val `object` = GsonUtils.fromJson(map[DBcolumns.json], Category.DataBeanX.DataBean::class.java)
                if (`object` != null) {
                    val databean = `object` as Category.DataBeanX.DataBean
                    if (databean != null) list.add(databean)
                }

            } while (c.moveToNext())
        }
        c.close()
        return list
    }
}