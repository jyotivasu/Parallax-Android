package com.example.easy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private FrameLayout fl;
    private float previousX;
    private float previousY;
    DisplayMetrics metrics;
    FrameLayout.LayoutParams layoutParamsFrame;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        fl = findViewById(R.id.move_layout);

        //layout params for resizing frame layout container
        layoutParamsFrame = (FrameLayout.LayoutParams) fl.getLayoutParams();
        ImageButton imgBtn = findViewById(R.id.img_button);
        imgBtn.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
                float dx = x - previousX;
                float dy = y - previousY;

                previousX = x;
                previousY = y;

                layoutParamsFrame.width = (int) x;
                fl.setLayoutParams(layoutParamsFrame);
        }
                return true;
    }
}
