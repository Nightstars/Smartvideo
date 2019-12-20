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
 * 动漫页面
 */
public class Fragment_dictionarypage extends Fragment {
    private GridView gridView_diction;
    private List<Map<String,Object>> datalist;
    private int[] icon={R.drawable.di1,R.drawable.di2,R.drawable.di3,R.drawable.di4,R.drawable.di5,R.drawable.di6,R.drawable.di7,R.drawable.di8,R.drawable.di9,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx};
    private String[] iconName={"白蛇：缘起","魔水晶:抗争时代 ","呆瓜兄弟","哪吒之魔童降世","大飞船历险记","白牙","雪人奇缘","潜艇总动员","星际侠探","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险"};
    final Resources mVideoRes = new Resources();
    private SimpleAdapter simpleAdapter;

    public Fragment_dictionarypage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dictionarypage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVideoRes.setTitle("雪怪大冒险");
        mVideoRes.setLink("rtmp://www.smartvideoplayer.ml:8999/vod/xueguaidamaoxian.mp4");
        mVideoRes.setDescription("《雪怪大冒险》是一部囊括巨星阵容及美妙原创音乐的全年龄段冒险动画片。当一只年轻活泼的雪人发现了之前本认为不存在的人类，" +
                "大脚怪传奇自此乱了套。 影片讲述了一个关乎友情、勇气与探索之趣的动人故事。关于人类这个“小脚怪”的消息让原本单纯的雪人族群陷入了骚乱之中，" +
                "他们开始好奇，在雪村之外，究竟存在着一个怎样的世界？");
        gridView_diction=(GridView)getActivity().findViewById(R.id.gridview_dictionpage);
        datalist=new ArrayList<Map<String, Object>>();
        simpleAdapter=new SimpleAdapter(getActivity(),getData(),R.layout.fragment_home_gridview_item,new String[]{"img","text"},new int[]{R.id.img,R.id.text_icon});
        gridView_diction.setAdapter(simpleAdapter);
        gridView_diction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
