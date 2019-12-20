package com.christzhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.christzhang.smartvideo.R;

/**
 * 电影页面
 */
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class MoviesFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = {"电影", "动漫", "综艺"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_movies,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //实例化
        viewPager = (ViewPager)getActivity().findViewById(R.id.viewpager);
        tabLayout = (TabLayout)getActivity().findViewById(R.id.tablayout);
        //页面，数据源
        list = new ArrayList<>();
        list.add(new com.christzhang.fragment.Fragment_moviespage());
        list.add(new com.christzhang.fragment.Fragment_dictionarypage());
        list.add(new com.christzhang.fragment.Fragment_showspage());
        //ViewPager的适配器
        adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //绑定
        tabLayout.setupWithViewPager(viewPager);
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}