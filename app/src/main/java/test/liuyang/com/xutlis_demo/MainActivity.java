package test.liuyang.com.xutlis_demo;

import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @ViewInject(value = R.id.tv_show)
    private TextView tv_show;

    @ViewInject(value = R.id.img_01)
    private ImageView img_01;
    @ViewInject(value = R.id.btn_change)
    private Button btn;

    @ViewInject(value = R.id.btn_request_http)
    private  Button btn_http;

    @ViewInject(value = R.id.btn_show_imgUrl)
    private  Button btn_show_imgUrl;

    @ViewInject(value = R.id.tv_http_show)
    private  TextView tv_http_show;

    @ViewInject(value = R.id.btn_db)
    private  Button btn_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        x.view().inject(MainActivity.this);

            tv_show.setText("世界你好");

            btn.setText("值被改变");


    }

    @Event(value ={R.id.btn_change,R.id.tv_show,R.id.btn_request_http,R.id.btn_show_imgUrl,R.id.btn_db},type =View.OnClickListener.class )

    private   void  BtnClick(View view){


        switch (view.getId()){

            case  R.id.btn_change:{
                System.out.println("=========");
                Toast.makeText(this,"按钮点击",Toast.LENGTH_SHORT).show();



            }
            break;
            case  R.id.tv_show:{
                Toast.makeText(this,"TextView点击",Toast.LENGTH_SHORT).show();

            }
            break;
            case  R.id.btn_request_http:{

                 getHttp_info();

//                tv_show.setText(s);

            }
            break;
            case  R.id.btn_show_imgUrl:{



//                x.image().bind(img_01,"http://img0.imgtn.bdimg.com/it/u=1864558495,1588336763&fm=21&gp=0.jpg");

                ImageOptions.Builder options=new ImageOptions.Builder();
                // 是否忽略GIF格式的图片
                      options .setIgnoreGif(false)
                        // 图片缩放模式
                        .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                        // 下载中显示的图片
                        .setLoadingDrawableId(R.mipmap.ic_launcher)
                        // 下载失败显示的图片
                        .setFailureDrawableId(R.mipmap.ic_launcher);

                ImageOptions build = options.build();


//                x.image().bind(img_01,"http://img0.imgtn.bdimg.com/it/u=1864558495,1588336763&fm=21&gp=0.jpg",build);



                x.image().bind(img_01, "http://img4q.duitang.com/uploads/item/201505/28/20150528160444_5tLn3.gif", build, new Callback.CommonCallback<Drawable>() {
                    @Override
                    public void onSuccess(Drawable result) {


                        Toast.makeText(MainActivity.this,"下载成功",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });


            }
            break;
            case  R.id.btn_db:{

                System.out.println("已被点击了传递数据");

                RequestParams  params=new RequestParams("http://192.168.178.2:8080/Project_test_0803/mySerlvert");
                File file = new File(Environment.getExternalStorageDirectory() + "/Download/a.mp3");
//                params.addBodyParameter("flag","4");

                boolean exists = file.exists();


                System.out.println(exists+"========");
//params.ad
//                params.addParameter();
                params.setMultipart(true);
                params.addBodyParameter("upload",file);
//                params.
//                BaiduParmars


//                x.http().send


                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });



            }
            break;

        }


    }
    String  st=null;
    private void getHttp_info() {


        RequestParams params=new RequestParams("http://route.showapi.com/9-7");

        params.addBodyParameter("showapi_appid","18603");

        params.addBodyParameter("showapi_sign","65929cb8fe2a41b38586a30626e66bb6");

        params.addBodyParameter("area","天津");
        params.addBodyParameter("month","201601");

//        params.addBodyParameter("file",new File());


        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
//                http://route.showapi.com/9-7

//                        System.out.println(result);

//                tv_http_show.setText(result);
//
//                st=result;
//                System.out.println(result);


                tv_http_show.setText(result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

}
