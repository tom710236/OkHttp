package com.example.user.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="http://demo.shinda.com.tw/ModernWebApi/WebApiLogin.aspx";

        OkHttpClient client = new OkHttpClient();                                                                //1、
                RequestBody body2 = new FormBody.Builder()
                .add("postdata", "{\"cAccount\":\"carlos\",\"cPassword\":\"123\"}")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body2)
                .build();                                                                                        //2、
        Call call = client.newCall(request);                                                                    //3、
        call.enqueue(new Callback() {                                                                            //4、
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("OkHttp ",response.toString());                                                            //5、
                Log.e("OkHttp2", response.body().string());

                response.close();
            }
        });


    }

}
