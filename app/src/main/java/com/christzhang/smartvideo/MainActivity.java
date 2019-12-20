package com.christzhang.smartvideo;

import com.christzhang.bean.Resources;
import com.christzhang.customwidgets.Customtimeout;
import com.christzhang.player.PlayerActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


;import static com.christzhang.customwidgets.Customtimeout.*;

public class MainActivity extends AppCompatActivity {
    private Customtimeout skip_ctrl;
    private ImageView home_img;
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        skip_ctrl=(Customtimeout)findViewById(R.id.skip_control);
        skip_ctrl.start();
        skip_ctrl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                skip_ctrl.stop();
                finish();
            }
        });
        skip_ctrl.setProgressListener( new Customtimeout.OnProgressListener() {
            @Override
            public void onProgress(int progress) {
                if(progress==0)
                {
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        home_img=(ImageView)findViewById(R.id.ad_imgshow);
        home_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                skip_ctrl.stop();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("adclicked", 1);
                startActivity(intent);
                finish();
            }
        });
    }
    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View. SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
