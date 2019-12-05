package com.hopemind.learn.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.project.R;

import java.util.Timer;
import java.util.TimerTask;

public class CustomViewActivity extends AppCompatActivity {

    private int mCurrentColor = 0;
    final int[] colors = new int[]{R.color.common_green,R.color.common_yellow,R.color.common_grey,
    R.color.common_orange,R.color.common_red};
    final int[] name = new int[]{R.id.view01,R.id.view02,R.id.view03,R.id.view04,R.id.view05};

    TextView[] views = new TextView[name.length];
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0x123){
                for (int i = 0;i < name.length;i++){
                    views[i].setBackgroundResource(colors[(i+mCurrentColor)%name.length]);
                }
                mCurrentColor++;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        for (int i = 0;i < name.length;i++){
            views[i] = findViewById(name[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,300);
    }
}
