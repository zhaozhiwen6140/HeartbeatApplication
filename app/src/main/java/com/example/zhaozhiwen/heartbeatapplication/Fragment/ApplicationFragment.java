package com.example.zhaozhiwen.heartbeatapplication.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zhaozhiwen.heartbeatapplication.ApplicationContext;
import com.example.zhaozhiwen.heartbeatapplication.ApplicationModel;
import com.example.zhaozhiwen.heartbeatapplication.R;
import com.example.zhaozhiwen.heartbeatapplication.Adapter.RecyclerViewAdapter;
import com.example.zhaozhiwen.heartbeatapplication.TestAPI.TestAPI;
import com.example.zhaozhiwen.heartbeatapplication.TestModel.MovieData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by zhaozhiwen on 2016/4/13.
 */
public class ApplicationFragment extends Fragment {

    private RecyclerViewAdapter adapter;
    private List<ApplicationModel> modelList;
    private int width;
    private int height;
    public  static final String BASE_URL="https://api.themoviedb.org";//一般只在这个地方添加域名即可，也可根据接口中的要求来实现。
    private MovieData movieData;//这个需要根据具体模型进行修改
    private int statusCode;
    private Context mContext;

    @Bind(R.id.application_recycler)
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_application,container,false);
        ButterKnife.bind(this, view);
        mContext= ApplicationContext.getContext();
        initRetrofit();//实现异步获取数据
        initData();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;
        adapter=new RecyclerViewAdapter(modelList,width,height);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initRetrofit() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TestAPI service=retrofit.create(TestAPI.class);
        Call<MovieData> call=service.getDapplicationData("1d1cd40875197d9e76c870167c8aa3c9");
        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Response<MovieData> response, Retrofit retrofit) {
                if (response != null) {
                    statusCode = response.code();
                    movieData = response.body();//如果接口存在，可在继续获取真实的数据。
                    Log.e("ApplicationFragment", movieData.getTitle());//检验接口是否真的访问成功
                    Toast.makeText(mContext, "访问成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(mContext,"没有数据",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("errorMessage", t.getMessage());
                Toast.makeText(mContext, "请求失败！", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initData() {
        modelList=new ArrayList<>();
        modelList.add(new ApplicationModel("Mia音乐","http://2.pic.anfensi.com/Uploads/Picture/2016-3-9/t013954ee0bcb9b9d65.png","http://pic.5577.com/up/2016-3/20163151017483240.png","4.7MB",0));
        modelList.add(new ApplicationModel("唔哩","","http://www.xp510.com/shouji/uploadfile/2016/0105/20160105034126513.jpg","14.9MB",0));
        modelList.add(new ApplicationModel("同城夜约会","","http://images.liqucn.com/mini/120x120/h027/h89/images201510191359460_info144X144_120x120.png","4.1MB",0));
        modelList.add(new ApplicationModel("一元夺宝","","http://d.hiphotos.baidu.com/baike/w%3D268/sign=b62d218374f082022d92963973fafb8a/4bed2e738bd4b31c9c67511b80d6277f9e2ff833.jpg","11.8MB",0));
        modelList.add(new ApplicationModel("蘑菇街","","http://g.hiphotos.baidu.com/baike/w%3D268/sign=596c8478262dd42a5f0906ad3b3b5b2f/30adcbef76094b3622e9cafca0cc7cd98d109dac.jpg","30.2MB",0));
        modelList.add(new ApplicationModel("Mia音乐","http://2.pic.anfensi.com/Uploads/Picture/2016-3-9/t013954ee0bcb9b9d65.png","http://pic.5577.com/up/2016-3/20163151017483240.png","4.7MB",0));
        modelList.add(new ApplicationModel("唔哩","","http://www.xp510.com/shouji/uploadfile/2016/0105/20160105034126513.jpg","14.9MB",0));
        modelList.add(new ApplicationModel("同城夜约会","","http://images.liqucn.com/mini/120x120/h027/h89/images201510191359460_info144X144_120x120.png","4.1MB",0));
        modelList.add(new ApplicationModel("一元夺宝","","http://d.hiphotos.baidu.com/baike/w%3D268/sign=b62d218374f082022d92963973fafb8a/4bed2e738bd4b31c9c67511b80d6277f9e2ff833.jpg","11.8MB",0));
        modelList.add(new ApplicationModel("蘑菇街","","http://g.hiphotos.baidu.com/baike/w%3D268/sign=596c8478262dd42a5f0906ad3b3b5b2f/30adcbef76094b3622e9cafca0cc7cd98d109dac.jpg","30.2MB",0));
        modelList.add(new ApplicationModel("Mia音乐","http://2.pic.anfensi.com/Uploads/Picture/2016-3-9/t013954ee0bcb9b9d65.png","http://pic.5577.com/up/2016-3/20163151017483240.png","4.7MB",0));
        modelList.add(new ApplicationModel("唔哩","","http://www.xp510.com/shouji/uploadfile/2016/0105/20160105034126513.jpg","14.9MB",0));
        modelList.add(new ApplicationModel("同城夜约会","","http://images.liqucn.com/mini/120x120/h027/h89/images201510191359460_info144X144_120x120.png","4.1MB",0));
        modelList.add(new ApplicationModel("一元夺宝","","http://d.hiphotos.baidu.com/baike/w%3D268/sign=b62d218374f082022d92963973fafb8a/4bed2e738bd4b31c9c67511b80d6277f9e2ff833.jpg","11.8MB",0));
        modelList.add(new ApplicationModel("蘑菇街","","http://g.hiphotos.baidu.com/baike/w%3D268/sign=596c8478262dd42a5f0906ad3b3b5b2f/30adcbef76094b3622e9cafca0cc7cd98d109dac.jpg","30.2MB",0));
        modelList.add(new ApplicationModel("Mia音乐","http://2.pic.anfensi.com/Uploads/Picture/2016-3-9/t013954ee0bcb9b9d65.png","http://pic.5577.com/up/2016-3/20163151017483240.png","4.7MB",0));
        modelList.add(new ApplicationModel("唔哩","","http://www.xp510.com/shouji/uploadfile/2016/0105/20160105034126513.jpg","14.9MB",0));
        modelList.add(new ApplicationModel("同城夜约会","","http://images.liqucn.com/mini/120x120/h027/h89/images201510191359460_info144X144_120x120.png","4.1MB",0));
        modelList.add(new ApplicationModel("一元夺宝","","http://d.hiphotos.baidu.com/baike/w%3D268/sign=b62d218374f082022d92963973fafb8a/4bed2e738bd4b31c9c67511b80d6277f9e2ff833.jpg","11.8MB",0));
        modelList.add(new ApplicationModel("蘑菇街","","http://g.hiphotos.baidu.com/baike/w%3D268/sign=596c8478262dd42a5f0906ad3b3b5b2f/30adcbef76094b3622e9cafca0cc7cd98d109dac.jpg","30.2MB",0));
    }
}

