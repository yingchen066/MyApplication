package com.example.yingchen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG","onCreate");
        x.http().get(new RequestParams("http://192.168.32.169:8080/geoserver/urbanlayer/wms?service=WMS&version=1.1.0&request=GetMap&layers=urbanlayer:cell&styles=&bbox=-4.95395959010755E11,-4.95395959010755E11,4.95395959010755E11,4.95395959010755E11&width=512&height=512&srs=EPSG:2364&format=application/openlayers"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG",result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG","error:"+ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG","cancel");
            }

            @Override
            public void onFinished() {
                Log.e("TAG","finish");
            }
        });
    }

    private void showMsg() {
        Toast.makeText(this, "Hoho", Toast.LENGTH_LONG).show();
    }
}
