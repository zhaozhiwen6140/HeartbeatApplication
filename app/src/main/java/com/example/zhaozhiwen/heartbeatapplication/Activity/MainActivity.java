package com.example.zhaozhiwen.heartbeatapplication.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.zhaozhiwen.heartbeatapplication.Fragment.ApplicationFragment;
import com.example.zhaozhiwen.heartbeatapplication.Fragment.FocusFragment;
import com.example.zhaozhiwen.heartbeatapplication.Fragment.GameFragment;
import com.example.zhaozhiwen.heartbeatapplication.R;
import com.example.zhaozhiwen.heartbeatapplication.Adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.toolbar_title)
    TextView title;

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    private List<Fragment> list_fragment;
    private List<String> list_title;
    private ViewPagerAdapter viewPagerAdapter;
    private Fragment focusFragment;
    private Fragment applicationFragment;
    private Fragment gameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setMainTitle();
        initData();
    }

    private void setMainTitle() {
        if(title!=null){
            title.setText("心动应用");
            title.setTextColor(this.getResources().getColor(R.color.white));
        }
    }

    private void initData() {
        focusFragment=new FocusFragment();
        applicationFragment= new ApplicationFragment();
        gameFragment=new GameFragment();
        list_fragment=new ArrayList<>();
        list_fragment.add(focusFragment);
        list_fragment.add(applicationFragment);
        list_fragment.add(gameFragment);
        list_title=new ArrayList<>();
        list_title.add("焦点");
        list_title.add("应用");
        list_title.add("游戏");
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(2)));
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),list_fragment,list_title);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
