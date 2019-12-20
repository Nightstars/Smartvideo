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
 * 综艺页面
 */
public class Fragment_showspage extends Fragment {
    private GridView gridView_shows;
    private List<Map<String,Object>> datalist;
    private int[] icon={R.drawable.sh1,R.drawable.sh2,R.drawable.sh3,R.drawable.sh4,R.drawable.sh5,R.drawable.sh6,R.drawable.sh7,R.drawable.sh8,R.drawable.sh9,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx,R.drawable.xgdmx};
    private String[] iconName={"这！就是街舞","少年可期","向往的生活","忘不了餐厅","密室大逃脱","极限挑战 ","创造营2019","奇遇人生","声入人心","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险","雪怪大冒险"};
    final Resources mVideoRes = new Resources();
    private SimpleAdapter simpleAdapter;

    public Fragment_showspage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_showspage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVideoRes.setTitle("雪怪大冒险");
        mVideoRes.setLink("rtmp://www.smartvideoplayer.ml:8999/vod/xueguaidamaoxian.mp4");
        mVideoRes.setDescription("《雪怪大冒险》是一部囊括巨星阵容及美妙原创音乐的全年龄段冒险动画片。当一只年轻活泼的雪人发现了之前本认为不存在的人类，" +
                "大脚怪传奇自此乱了套。 影片讲述了一个关乎友情、勇气与探索之趣的动人故事。关于人类这个“小脚怪”的消息让原本单纯的雪人族群陷入了骚乱之中，" +
                "他们开始好奇，在雪村之外，究竟存在着一个怎样的世界？");
        gridView_shows=(GridView)getActivity().findViewById(R.id.gridview_showspage);
        datalist=new ArrayList<Map<String, Object>>();
        simpleAdapter=new SimpleAdapter(getActivity(),getData(),R.layout.fragment_home_gridview_item,new String[]{"img","text"},new int[]{R.id.img,R.id.text_icon});
        gridView_shows.setAdapter(simpleAdapter);
        gridView_shows.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
