package com.example.zhaozhiwen.heartbeatapplication.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class GameFragment extends Fragment {

    private RecyclerViewAdapter adapter;
    private List<ApplicationModel> modelList;
    private int width;
    private int height;
    public  static final String BASE_URL="https://api.themoviedb.org";//一般只在这个地方添加域名即可，也可根据接口中的要求来实现。
    private MovieData movieData;//这个需要根据具体模型进行修改
    private int statusCode;
    private Context mContext;

    @Bind(R.id.game_recycler)
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_game,container,false);
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
                    Log.e("GameFragment", movieData.getOverview());//检验接口是否真的访问成功
                    Toast.makeText(mContext, "访问成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "没有数据", Toast.LENGTH_SHORT).show();
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
        modelList.add(new ApplicationModel("灵剑奇缘","http://d.hiphotos.baidu.com/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=62c54a7da544ad343ab28fd5b1cb6791/a5c27d1ed21b0ef4e83370ced9c451da80cb3e43.jpg","http://newsimg.5054399.com/uploads/litimg/160224/15311S0319D.jpg","83.7MB",0));
        modelList.add(new ApplicationModel("水果忍者","","http://www.99danji.com/upload/2011621/2011621112013.jpg","130.0MB",0));
        modelList.add(new ApplicationModel("剑与魔法","","http://images.liqucn.com/mini/120x120/h028/h16/images201512141525530_info200X200_120x120.png","237.0MB",0));
        modelList.add(new ApplicationModel("御剑飞仙","","http://pic.96u.com/Uploads/Picture/2016-01-29/56aadc23a9b35.jpg","123.0MB",0));
        modelList.add(new ApplicationModel("捕鱼达人","","http://f.hiphotos.baidu.com/baike/w%3D268/sign=53209245fafaaf5184e386b9b45594ed/838ba61ea8d3fd1fdc0f9859374e251f95ca5f4a.jpg","114.0MB",0));
        modelList.add(new ApplicationModel("灵剑奇缘","http://d.hiphotos.baidu.com/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=62c54a7da544ad343ab28fd5b1cb6791/a5c27d1ed21b0ef4e83370ced9c451da80cb3e43.jpg","http://newsimg.5054399.com/uploads/litimg/160224/15311S0319D.jpg","83.7MB",0));
        modelList.add(new ApplicationModel("水果忍者","","http://www.99danji.com/upload/2011621/2011621112013.jpg","130.0MB",0));
        modelList.add(new ApplicationModel("剑与魔法","","http://images.liqucn.com/mini/120x120/h028/h16/images201512141525530_info200X200_120x120.png","237.0MB",0));
        modelList.add(new ApplicationModel("御剑飞仙","","http://pic.96u.com/Uploads/Picture/2016-01-29/56aadc23a9b35.jpg","123.0MB",0));
        modelList.add(new ApplicationModel("捕鱼达人","","http://f.hiphotos.baidu.com/baike/w%3D268/sign=53209245fafaaf5184e386b9b45594ed/838ba61ea8d3fd1fdc0f9859374e251f95ca5f4a.jpg","114.0MB",0));
        modelList.add(new ApplicationModel("灵剑奇缘","http://d.hiphotos.baidu.com/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=62c54a7da544ad343ab28fd5b1cb6791/a5c27d1ed21b0ef4e83370ced9c451da80cb3e43.jpg","http://newsimg.5054399.com/uploads/litimg/160224/15311S0319D.jpg","83.7MB",0));
        modelList.add(new ApplicationModel("水果忍者","","http://www.99danji.com/upload/2011621/2011621112013.jpg","130.0MB",0));
        modelList.add(new ApplicationModel("剑与魔法","","http://images.liqucn.com/mini/120x120/h028/h16/images201512141525530_info200X200_120x120.png","237.0MB",0));
        modelList.add(new ApplicationModel("御剑飞仙","","http://pic.96u.com/Uploads/Picture/2016-01-29/56aadc23a9b35.jpg","123.0MB",0));
        modelList.add(new ApplicationModel("捕鱼达人","","http://f.hiphotos.baidu.com/baike/w%3D268/sign=53209245fafaaf5184e386b9b45594ed/838ba61ea8d3fd1fdc0f9859374e251f95ca5f4a.jpg","114.0MB",0));
        modelList.add(new ApplicationModel("灵剑奇缘","http://d.hiphotos.baidu.com/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=62c54a7da544ad343ab28fd5b1cb6791/a5c27d1ed21b0ef4e83370ced9c451da80cb3e43.jpg","http://newsimg.5054399.com/uploads/litimg/160224/15311S0319D.jpg","83.7MB",0));
        modelList.add(new ApplicationModel("水果忍者","","http://www.99danji.com/upload/2011621/2011621112013.jpg","130.0MB",0));
        modelList.add(new ApplicationModel("剑与魔法","","http://images.liqucn.com/mini/120x120/h028/h16/images201512141525530_info200X200_120x120.png","237.0MB",0));
        modelList.add(new ApplicationModel("御剑飞仙","","http://pic.96u.com/Uploads/Picture/2016-01-29/56aadc23a9b35.jpg","123.0MB",0));
        modelList.add(new ApplicationModel("捕鱼达人","","http://f.hiphotos.baidu.com/baike/w%3D268/sign=53209245fafaaf5184e386b9b45594ed/838ba61ea8d3fd1fdc0f9859374e251f95ca5f4a.jpg","114.0MB",0));
    }
}

