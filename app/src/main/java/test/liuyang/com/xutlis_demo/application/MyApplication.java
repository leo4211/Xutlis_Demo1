package test.liuyang.com.xutlis_demo.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/8/10.
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);


    }
}
