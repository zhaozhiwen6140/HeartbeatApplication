package com.example.zhaozhiwen.heartbeatapplication.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhiwen.heartbeatapplication.ApplicationContext;
import com.example.zhaozhiwen.heartbeatapplication.Adapter.FocusAdapter;
import com.example.zhaozhiwen.heartbeatapplication.MainImage;
import com.example.zhaozhiwen.heartbeatapplication.Activity.NoBoringActionBarActivity;
import com.example.zhaozhiwen.heartbeatapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhaozhiwen on 2016/4/13.
 */
public class FocusFragment extends Fragment {
    private FocusAdapter adapter;
    private List<MainImage> imageList;
    private Context mContext;

    @Bind(R.id.focus_recycler)
    RecyclerView focusRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          View view=inflater.inflate(R.layout.fragment_focus,container,false);
          ButterKnife.bind(this, view);
          mContext= ApplicationContext.getContext();
          initData();
         focusRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
         focusRecycler.setHasFixedSize(true);
         adapter=new FocusAdapter(imageList,mContext);
         focusRecycler.setAdapter(adapter);
         adapter.setOnItemClickListener(new FocusAdapter.OnItemClickListener() {
             @Override
             public void onItemClick(View view, int position) {
                 startActivity(new Intent(getActivity(),NoBoringActionBarActivity.class));
             }
         });
          return view;
    }

    private void initData() {
        imageList=new ArrayList<>();
        imageList.add(new MainImage("http://pic.orsoon.com/uploads/allimg/2015/11/05/6-46671446689009.jpeg"));
        imageList.add(new MainImage("http://p19.qhimg.com/t01bbc519d1866c000e.jpg"));
        imageList.add(new MainImage("http://img1.imgtn.bdimg.com/it/u=1495091651,1375973654&fm=15&gp=0.jpg"));
    }
}
