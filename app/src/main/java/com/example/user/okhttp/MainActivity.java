package com.example.user.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

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

        OkHttpClient client = new OkHttpClient();
                RequestBody body2 = new FormBody.Builder()
                .add("postdata", "{\"cAccount\":\"carlos\",\"cPassword\":\"123\"}")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body2)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.e("OkHttp ",response.toString());
                Log.e("OkHttp2", json);

                parseJson(json);


            }
            private void parseJson(String json) {

                try {
                    String cStatus = new JSONObject(json).getString("cStatus");

                    Log.e("JSOM",cStatus);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });






    }

}
