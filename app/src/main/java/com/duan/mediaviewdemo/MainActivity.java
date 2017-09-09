package com.duan.mediaviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.duan.mediaviewdemo.view.PlayView;
import com.duan.mediaviewdemo.view.SkipView;
import com.nispok.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void pre(View view) {
        Snackbar.with(this).text("click pre by " + view.hashCode()).duration(300).show(this);
    }

    public void next(View view) {
        Snackbar.with(this).text("click next by " + view.hashCode()).duration(300).show(this);
    }

    public void play(View view) {
        PlayView p = (PlayView) view;
        String status = p.isChecked() ? "play" : "pause";
        Snackbar.with(this).text("click play by " + view.hashCode() + " " + status).duration(300).show(this);
    }

}
