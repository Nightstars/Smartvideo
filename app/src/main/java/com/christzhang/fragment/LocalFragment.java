package com.christzhang.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.christzhang.bean.Resources;
import com.christzhang.player.PlayerActivity;
import com.christzhang.smartvideo.Activity_loc;
import com.christzhang.smartvideo.R;



/**
 * 看点页面
 */

public class LocalFragment extends Fragment {
    ImageView showmovies;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showmovies=(ImageView)getActivity().findViewById(R.id.loadingmovies);
        showmovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                Resources mVideoRes = new Resources();
                mVideoRes.setTitle("雪怪大冒险");
                mVideoRes.setDescription("《雪怪大冒险》是一部囊括巨星阵容及美妙原创音乐的全年龄段冒险动画片。当一只年轻活泼的雪人发现了之前本认为不存在的人类，" +
                        "大脚怪传奇自此乱了套。 影片讲述了一个关乎友情、勇气与探索之趣的动人故事。关于人类这个“小脚怪”的消息让原本单纯的雪人族群陷入了骚乱之中，" +
                        "他们开始好奇，在雪村之外，究竟存在着一个怎样的世界？");
                mVideoRes.setLink("rtmp://www.smartvideoplayer.ml:8999/vod/xueguaidamaoxian.mp4");
                intent.putExtra("videoType", 0);
                intent.putExtra("video", mVideoRes);
                startActivity(intent);
            }
        });
    }
}