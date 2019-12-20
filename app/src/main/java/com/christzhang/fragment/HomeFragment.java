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
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.christzhang.bean.Resources;
import com.christzhang.player.PlayerActivity;
import com.christzhang.smartvideo.R;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class HomeFragment extends Fragment {
    private ImageView more;
    private GridView gridView;
    private GridView gridView1;
    private GridView gridView2;
    private ScrollView scrollView;
    private SliderLayout mDemoSlider;
    private List<Map<String,Object>>datalist;
    private int[] icon={R.drawable.mo24,R.drawable.mo23,R.drawable.mo9,R.drawable.mo1,R.drawable.mo11,R.drawable.mo12};
    private String[] iconName={"大黄蜂","毒液","惊奇队长","哥斯拉2","复仇者联盟4","流浪地球"};
    final Resources mVideoRes = new Resources();
    private SimpleAdapter simpleAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载 fragment 的布局文件
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int isadclicked = getActivity().getIntent().getIntExtra("adclicked", 0);
        if(isadclicked==1)
    {
        Intent intent_ad=new Intent(getActivity(),PlayerActivity.class);
        Resources video = new Resources();
        video.setTitle("雪怪大冒险");
        video.setDescription("《雪怪大冒险》是一部囊括巨星阵容及美妙原创音乐的全年龄段冒险动画片。当一只年轻活泼的雪人发现了之前本认为不存在的人类，" +
                "大脚怪传奇自此乱了套。 影片讲述了一个关乎友情、勇气与探索之趣的动人故事。关于人类这个“小脚怪”的消息让原本单纯的雪人族群陷入了骚乱之中，" +
                "他们开始好奇，在雪村之外，究竟存在着一个怎样的世界？");
        video.setLink("rtmp://www.smartvideoplayer.ml:8999/vod/xueguaidamaoxian.mp4");
        intent_ad.putExtra("videoType", 0);
        intent_ad.putExtra("video", video);
        startActivity(intent_ad);
    }
   // more=(ImageView)getActivity().findViewById(R.id.more);
       /* more.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),"连接服务器超时",Toast.LENGTH_SHORT).show();
        }
    });*/
        mVideoRes.setTitle("雪怪大冒险");
        mVideoRes.setLink("rtmp://www.smartvideoplayer.ml:8999/vod/xueguaidamaoxian.mp4");
        mVideoRes.setDescription("《雪怪大冒险》是一部囊括巨星阵容及美妙原创音乐的全年龄段冒险动画片。当一只年轻活泼的雪人发现了之前本认为不存在的人类，" +
                "大脚怪传奇自此乱了套。 影片讲述了一个关乎友情、勇气与探索之趣的动人故事。关于人类这个“小脚怪”的消息让原本单纯的雪人族群陷入了骚乱之中，" +
                "他们开始好奇，在雪村之外，究竟存在着一个怎样的世界？");
        mDemoSlider = (SliderLayout)getActivity().findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("雪怪大冒险",R.drawable.xgslider);
        file_maps.put("雪",R.drawable.xgslider);
        file_maps.put("怪",R.drawable.xgslider);
        file_maps.put("大", R.drawable.xgslider);
        file_maps.put("冒", R.drawable.xgslider);
        file_maps.put("险", R.drawable.xgslider);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            //Toast.makeText(getActivity(),slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getActivity(),PlayerActivity.class);
                            intent.putExtra("videoType", 0);
                            intent.putExtra("video", mVideoRes);
                            startActivity(intent);
                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(2500);
        scrollView=(ScrollView)getActivity().findViewById(R.id.scrollview);
        gridView=(GridView)getActivity().findViewById(R.id.gridview);
        gridView1=(GridView)getActivity().findViewById(R.id.gridview1);
        gridView2=(GridView)getActivity().findViewById(R.id.gridview2);
        datalist=new ArrayList<Map<String, Object>>();
        simpleAdapter=new SimpleAdapter(getActivity(),getData(),R.layout.fragment_home_gridview_item,new String[]{"img","text"},new int[]{R.id.img,R.id.text_icon});
        gridView.setFocusable(false);
        gridView1.setFocusable(false);
        gridView2.setFocusable(false);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),PlayerActivity.class);
                intent.putExtra("videoType", 0);
                intent.putExtra("video", mVideoRes);
                startActivity(intent);
            }
        });
        gridView1.setAdapter(simpleAdapter);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),PlayerActivity.class);
                intent.putExtra("videoType", 0);
                intent.putExtra("video", mVideoRes);
                startActivity(intent);
            }
        });
        gridView2.setAdapter(simpleAdapter);
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),PlayerActivity.class);
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
    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onResume() {
        mDemoSlider.startAutoCycle();
        super.onResume();
    }
}