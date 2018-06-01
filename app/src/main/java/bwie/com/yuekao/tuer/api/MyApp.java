package bwie.com.yuekao.tuer.api;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.drawee.backends.pipeline.Fresco;

import bwie.com.yuekao.Dao.DaoMaster;
import bwie.com.yuekao.Dao.DaoSession;

/**
 * Created by zld on 2018.06.01.
 */

public class MyApp extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static MyApp instances;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        instances = this;
        setDatabase();
    }

    public static MyApp getInstances() {
        return instances;
    }

    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "sport-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
