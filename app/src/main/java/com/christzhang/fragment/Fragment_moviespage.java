package com.christzhang.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.christzhang.bean.Resources;
import com.christzhang.player.PlayerActivity;
import com.christzhang.smartvideo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 电影页面
 */
public class Fragment_moviespage extends Fragment {
    private GridView gridView_movies;
    private List<Map<String,Object>> datalist;
    private int[] icon={R.drawable.mo1,R.drawable.mo2,R.drawable.mo3,R.drawable.mo4,R.drawable.mo5,R.drawable.mo6,R.drawable.mo7,R.drawable.mo8,R.drawable.mo9,R.drawable.mo10,R.drawable.mo11,R.drawable.mo12,R.drawable.mo13,R.drawable.mo14,R.drawable.mo15,R.drawable.mo16,R.drawable.mo17,R.drawable.mo18,R.drawable.mo19,R.drawable.mo20,R.drawable.mo21,R.drawable.mo22,R.drawable.mo23,R.drawable.mo24};
    private String[] iconName={"哥斯拉2","X战警：黑凤凰 ","蜘蛛侠:英雄远征","黑衣人:全球追踪","追龙Ⅱ","忠犬流浪记","狮子王","阿拉丁","惊奇队长","上海堡垒","复仇者联盟4","流浪地球","雷霆沙赞","反贪风暴4","人间·喜剧","地球最后的夜晚","中国机长","过春天","蜘蛛侠:平行宇宙","叶问外传:张天志","江湖儿女","神探蒲松龄","毒液","大黄蜂 "};
    final Resources mVideoRes = new Resources();
    private SimpleAdapter simpleAdapter;
    public Fragment_moviespage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moviespage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVideoRes.setTitle("雪怪大冒险");
        mVideoRes.setLink("rtmp://www.smartvideoplayer.ml:8999/vod/xueguaidamaoxian.mp4");
        mVideoRes.setDescription("《雪怪大冒险》是一部囊括巨星阵容及美妙原创音乐的全年龄段冒险动画片。当一只年轻活泼的雪人发现了之前本认为不存在的人类，" +
                "大脚怪传奇自此乱了套。 影片讲述了一个关乎友情、勇气与探索之趣的动人故事。关于人类这个“小脚怪”的消息让原本单纯的雪人族群陷入了骚乱之中，" +
                "他们开始好奇，在雪村之外，究竟存在着一个怎样的世界？");
        gridView_movies=(GridView)getActivity().findViewById(R.id.gridview_moviespage);
        datalist=new ArrayList<Map<String, Object>>();
        simpleAdapter=new SimpleAdapter(getActivity(),getData(),R.layout.fragment_home_gridview_item,new String[]{"img","text"},new int[]{R.id.img,R.id.text_icon});
        gridView_movies.setAdapter(simpleAdapter);
        gridView_movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), PlayerActivity.class);
                intent.putExtra("videoType", 0);
                intent.putExtra("video", mVideoRes);
                startActivity(intent);
            }
        });
    }
    private List<Map<String,Object>> getData(){
        for(int i=0;i<icon.length;i++)
        {
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("img",icon[i]);
            map.put("text",iconName[i]);
            datalist.add(map);
        }
        return datalist;
    }
}
