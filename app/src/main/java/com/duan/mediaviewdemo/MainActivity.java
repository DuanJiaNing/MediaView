package com.duan.mediaviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.duan.mediaviewdemo.view.PlayView;
import com.duan.mediaviewdemo.view.SkipView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        SkipView sv = (SkipView) findViewById(R.id.sv_01);
//        PlayView pv = (PlayView) findViewById(R.id.pv_01);
//
//        sv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        pv.setOnCheckedChangeListener(new PlayView.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(PlayView view, boolean checked) {
//                Toast.makeText(MainActivity.this, "checked:" + checked, Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
