package com.christzhang.smartvideo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;
import com.christzhang.fragment.HomeFragment;
import com.christzhang.fragment.LocalFragment;
import com.christzhang.fragment.MineFragment;
import com.christzhang.fragment.MoviesFragment;

public class HomeActivity extends AppCompatActivity {
    HomeFragment homeFragment; //主页
    MoviesFragment  moviesFragment;
    LocalFragment localFragment;
    MineFragment mineFragment;
    BottomNavigationView  navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView=(BottomNavigationView)findViewById(R.id.navigation);
        final FragmentManager fragmentManager = getSupportFragmentManager(); //获取 fragment 管理器
        //默认显示HomeFragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //获得 Fragment 事务处理器
        homeFragment = new HomeFragment(); //把主页 new 出来
        fragmentTransaction.replace(R.id.content_view, homeFragment); //加载fragment
        fragmentTransaction.commit();//提交加载操作
        //为navigation设置监听
        navigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //获取事务处理器
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();

                        switch (item.getItemId()) { //读取选择的item的id

                            //当选中的item的id是 navigation_home 时，
                            //隐藏其他fragment，把fragment_home显示出来
                            case R.id.navigation_home:

                                //如果 communityFragment 不等于空，就把他隐藏掉
                                if (moviesFragment != null){
                                    fragmentTransaction1.hide(moviesFragment);
                                }

                                if (localFragment != null){
                                    fragmentTransaction1.hide(localFragment);
                                }
                                if (mineFragment != null){
                                    fragmentTransaction1.hide(mineFragment);
                                }
                                //如果fragment还没创建就创建一个，然后add
                                //如果fragment已经创建了，就show
                                if (homeFragment == null) {
                                    homeFragment = new HomeFragment();
                                    fragmentTransaction1.add(R.id.content_view ,homeFragment);
                                }else
                                    fragmentTransaction1.show(homeFragment);
                                break;

                            case R.id.navigation_movies:
                                if (homeFragment != null){
                                    fragmentTransaction1.hide(homeFragment);
                                }
                                if (localFragment != null){
                                    fragmentTransaction1.hide(localFragment);
                                }
                                if (mineFragment != null){
                                    fragmentTransaction1.hide(mineFragment);
                                }
                                if (moviesFragment == null) {
                                    moviesFragment = new MoviesFragment();
                                    fragmentTransaction1.add(R.id.content_view ,moviesFragment);
                                }else
                                    fragmentTransaction1.show(moviesFragment);
                                break;

                            case R.id.navigation_local:
                                if (moviesFragment != null){
                                    fragmentTransaction1.hide(moviesFragment);
                                }
                                if (homeFragment != null){
                                    fragmentTransaction1.hide(homeFragment);
                                }
                                if (mineFragment != null){
                                    fragmentTransaction1.hide(mineFragment);
                                }
                                if (localFragment == null) {
                                    localFragment = new LocalFragment();
                                    fragmentTransaction1.add(R.id.content_view ,localFragment);
                                }else
                                    fragmentTransaction1.show(localFragment);
                                break;

                            case R.id.navigation_mine:
                                if (homeFragment != null){
                                    fragmentTransaction1.hide(homeFragment);
                                }
                                if (moviesFragment != null){
                                    fragmentTransaction1.hide(moviesFragment);
                                }
                                if (localFragment != null){
                                    fragmentTransaction1.hide(localFragment);
                                }
                                if (mineFragment == null) {
                                    mineFragment = new MineFragment();
                                    fragmentTransaction1.add(R.id.content_view ,mineFragment);
                                }else
                                    fragmentTransaction1.show(mineFragment);
                                break;
                        }

                        //提交操作
                        fragmentTransaction1.commit();

                        return true; //一定要返回true，否则会选择不了item
                    }
                });
    }
}
