package com.example.administrator.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/8/28.
 */

public class WelcomeActivity extends AppCompatActivity {
//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 5*6:
//                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                    break;
//            }
//        }
//    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MyThread thread = new MyThread();
//        thread.start();
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();

    }

//    private class MyThread  extends Thread{
//        @Override
//        public void run() {
//            super.run();
//            try {
//                sleep(6000);
//                Message message = new Message();
//                message.what = 5*6;
//                handler.sendMessage(message);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
