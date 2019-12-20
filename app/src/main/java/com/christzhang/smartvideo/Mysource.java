package com.christzhang.smartvideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.christzhang.bean.Resources;
import com.christzhang.player.PlayerActivity;
import com.christzhang.title.TitleBuilder;



public class Mysource extends AppCompatActivity {
private EditText url_text;
private Button btn;
 private  String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysource);
        initTitle();
        url_text=(EditText)findViewById(R.id.url);
        btn=(Button)findViewById(R.id.play);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link=url_text.getText().toString();
                if(link.equals("")||link==null)
                {
                    Toast.makeText(Mysource.this,"播放源不能为空",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent_ad=new Intent(Mysource.this, PlayerActivity.class);
                    Resources video = new Resources();
                    video.setTitle("Null");
                    video.setDescription("Null");
                    video.setLink(link);
                    intent_ad.putExtra("videoType", 0);
                    intent_ad.putExtra("video", video);
                    startActivity(intent_ad);
                }
            }
        });
    }
    private void initTitle() {
        // 1.设置左边的图片按钮显示，以及事件 2.设置中间TextView显示的文字 3.设置右边的图片按钮显示，并设置事件
        new TitleBuilder(this).setLeftImageRes(true, 0)
                .setLeftTextOrImageListener(true, null)
                .setMiddleTitleText("自定义源");
    }
}
