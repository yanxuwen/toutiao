package com.example.app.myapplication.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.Gson;
import com.yanxuwen.Base.DB.DBcolumns;
import com.yanxuwen.Base.DB.MyDB;
import com.yanxuwen.retrofit.GsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yanxuwen on 2017/6/23.
 */

public class BannerDB extends MyDB {
    public class BannersBean{
        private String _id;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }
    }


    public BannerDB(Context context,String channelId) {
        //第二个参数用于区分是哪个帐号下的数据库
        super(context,"15060568262");
        onCreateTable("table_banner_"+channelId);
    }

    public void onWrite(final List<BannersBean> list, boolean isAll){
        if(isAll){
            onDelete();
        }
        final SQLiteDatabase SQLdb=onOpenWrite();
        Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                for(BannersBean databean:list){
                    String id=databean.get_id();
                    ContentValues values = new ContentValues();
                    values.put(DBcolumns.ID, id);
                    Gson gson=new Gson();
                    String json=gson.toJson(databean);
                    values.put(DBcolumns.json, json);
                    SQLdb.insert(getTableName(), id, values);
                }

                subscriber.onNext(null);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) //事件发送，即图片加载在IO线程
                .observeOn(AndroidSchedulers.mainThread())  //事件处理，即图片显示在UI线程
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        SQLdb.close();
                    }

                    @Override
                    public void onNext(Void aVoid) {
                        SQLdb.close();
                    }
                });

    }
    public BannersBean  onRead(String id){
        if(id==null)return null;
        BannersBean databean=new  BannersBean();
        Cursor c = onQuerySingle(id);
        if(c==null)return null;
        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                Map<String, String> map = new HashMap<String, String>();
                for (int i = 0; i < c.getColumnCount(); i++) {
                    map.put(c.getColumnName(i), c.getString(i));
                }
                Object object= GsonUtils.fromJson( map.get(json),BannersBean.class);
                if(object!=null){
                    databean=(BannersBean)object;

                }
            } while (c.moveToNext());
        }
        c.close();
        return databean;
    }
    /**
     * 读取的时候一定要在线程读取，可在继承BaseActivity的initData直接读取
     */
    public List<BannersBean> onReadAll(){
        List<BannersBean> list=new ArrayList<>();
        Cursor c = onQuery(getTableName());
        if(c==null)return null;
        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                Map<String, String> map = new HashMap<String, String>();
                for (int i = 0; i < c.getColumnCount(); i++) {
                    map.put(c.getColumnName(i), c.getString(i));
                }
                Object object= GsonUtils.fromJson( map.get(DBcolumns.json),BannersBean.class);
                if(object!=null){
                    BannersBean databean=(BannersBean)object;
                    if(databean!=null) list.add(databean);
                }

            } while (c.moveToNext());
        }
        c.close();
        return list;
    }
    /**
     * 根据id查询时候一定要在线程读取
     */
    public Cursor onQuerySingle(String id) {
        SQLiteDatabase SQLdb = onOpenRead();
        Cursor cursor = null;
        try{
                 cursor=SQLdb.query(getTableName(), null, DBcolumns.ID
                         + "='" + id + "'", null, null, null, null
                         + " asc ");
             }catch (Exception e){}
        return cursor;

    }
}
