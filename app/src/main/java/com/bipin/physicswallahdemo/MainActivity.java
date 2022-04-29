package com.bipin.physicswallahdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread thread= new Thread(){

            @Override
            public void run() {

                try {
                    sleep(2*1000);
                    Intent i=new Intent(getBaseContext(),ViewUserList.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                }
            }
        };

        thread.start();
    }






//    Thread background = new Thread() {
//        @Override
//        public void run() {
//
//        }
//    }.start();
//    // start thread
//		background.start();
}