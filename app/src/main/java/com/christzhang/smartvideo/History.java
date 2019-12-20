package com.christzhang.smartvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.christzhang.title.TitleBuilder;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initTitle();
    }
    private void initTitle() {
        // 1.设置左边的图片按钮显示，以及事件 2.设置中间TextView显示的文字 3.设置右边的图片按钮显示，并设置事件
        new TitleBuilder(this).setLeftImageRes(true, 0)
                .setLeftTextOrImageListener(true, null)
                .setMiddleTitleText("历史记录");
    }
}
