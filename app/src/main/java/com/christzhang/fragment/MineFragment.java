package com.christzhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.christzhang.smartvideo.About;
import com.christzhang.smartvideo.Activity_loc;
import com.christzhang.smartvideo.History;
import com.christzhang.smartvideo.Login;
import com.christzhang.smartvideo.Mysource;
import com.christzhang.smartvideo.R;
//我的页面item
import com.christzhang.smartvideo.Settings;
import com.christzhang.smartvideo.collect;
import com.leon.lib.settingview.LSettingItem;

/**
 *我的页面
 */

public class MineFragment extends Fragment {
    private LSettingItem item_loc;
    private LSettingItem item_collect;
    private LSettingItem item_history;
    private LSettingItem item_link;
    private LSettingItem item_set;
    private LSettingItem item_about;
    private LSettingItem item_update;
    private TextView showname;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mine,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showname=(TextView)getActivity().findViewById(R.id.showname);
        item_loc=getActivity().findViewById(R.id.item_loc);
        item_collect=getActivity().findViewById(R.id.item_collect);
        item_history=getActivity().findViewById(R.id.item_hisroty);
        item_link=getActivity().findViewById(R.id.item_link);
        item_set=getActivity().findViewById(R.id.item_setting);
        item_about=getActivity().findViewById(R.id.item_about);
        item_update=getActivity().findViewById(R.id.item_upd);
        showname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_login=new Intent(getActivity(), Login.class);
                startActivity(intent_login);
            }
        });
        item_loc.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent_loc=new Intent(getActivity(), Activity_loc.class);
                startActivity(intent_loc);
            }
        });
        item_collect.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent_collect=new Intent(getActivity(), collect.class);
                startActivity(intent_collect);
            }
        });
        item_history.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent_history=new Intent(getActivity(), History.class);
                startActivity(intent_history);
            }
        });
        item_link.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent_link=new Intent(getActivity(), Mysource.class);
                startActivity(intent_link);
            }
        });
        item_set.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent_settings=new Intent(getActivity(), Settings.class);
                startActivity(intent_settings);
            }
        });
        item_about.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent_about=new Intent(getActivity(), About.class);
                startActivity(intent_about);
            }
        });
        item_update.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Toast.makeText(getActivity(),"当前已是最新版本   v1.5.0",Toast.LENGTH_SHORT).show();
            }
        });
    }
}