package com.yanxuwen.lib_common.DB

import android.content.ContentValues
import android.content.Context
import com.google.gson.Gson
import com.yanxuwen.Base.DB.DBcolumns
import com.yanxuwen.Base.DB.MyDB
import com.yanxuwen.lib_common.retrofit.model.SearchSuggest.SearchSuggest
import com.yanxuwen.retrofit.GsonUtils
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by yanxuwen on 2018/7/4.
 */
class SearchSuggestDB : MyDB {
    constructor(context: Context, category: String) : super(context,"测试帐号") {
        onCreateTable("table_SearchSuggest_"+category)
    }

    fun onWrite(databean: SearchSuggest.DataBean) {
        onDelete()
        if(databean==null){
            return
        }
        val SQLdb = onOpenWrite()
        Observable.create(Observable.OnSubscribe<Void> { subscriber ->
            val id ="1"
            val values = ContentValues()
            values.put(DBcolumns.ID, id)
            val gson = Gson()
            val json = gson.toJson(databean)
            values.put(DBcolumns.json, json)
            SQLdb.insert(tableName, id, values)
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

    fun onRead(): SearchSuggest.DataBean? {
        val c = onQuery(tableName) ?: return null
        var data :SearchSuggest.DataBean ?=null
        c.moveToFirst()
        if (c.count > 0) {
            do {
                val map = HashMap<String, String>()
                for (i in 0 until c.columnCount) {
                    map.put(c.getColumnName(i), c.getString(i))
                }
                val `object` = GsonUtils.fromJson(map[DBcolumns.json], SearchSuggest.DataBean::class.java)
                if (`object` != null) {
                    val databean = `object` as SearchSuggest.DataBean
                    if (databean != null)data=databean
                }

            } while (c.moveToNext())
        }
        c.close()
        return data
    }
}