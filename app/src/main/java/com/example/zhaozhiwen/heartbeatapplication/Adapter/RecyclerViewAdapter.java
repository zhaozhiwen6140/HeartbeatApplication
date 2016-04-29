package com.example.zhaozhiwen.heartbeatapplication.Adapter;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaozhiwen.heartbeatapplication.ApplicationContext;
import com.example.zhaozhiwen.heartbeatapplication.ApplicationModel;
import com.example.zhaozhiwen.heartbeatapplication.FocusItemModel;
import com.example.zhaozhiwen.heartbeatapplication.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhaozhiwen on 2016/4/14.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private List<ApplicationModel> modelList;
    private LayoutInflater inflater;
    private ApplicationModel model;
    private int width;
    private int height;

    public RecyclerViewAdapter(List<ApplicationModel> modelList,int width,int height) {
         this.modelList=modelList;
         inflater=LayoutInflater.from(ApplicationContext.getContext());
         this.width=width;
         this.height=height;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        switch(viewType){
            case ApplicationModel.BigFrame:
                view=inflater.inflate(R.layout.item_bigframe,parent,false);
                break;
            case ApplicationModel.SmallFrame:
                view=inflater.inflate(R.layout.item_smallframe,parent,false);
                break;
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position){
          model=modelList.get(position);
           int paramHeight=width/2;
          switch(model.getItemType()){
            case ApplicationModel.BigFrame:
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) holder.binner.getLayoutParams();
                params.height=paramHeight;
                holder.binner.setLayoutParams(params);
                holder.binner.setImageURI(Uri.parse(model.getBinner()));
                holder.bigframe_title.setText(model.getTitle());
                holder.bigframe_small_icon.setImageURI(Uri.parse(model.getIcon()));
                holder.bigframe_package_size.setText(model.getPackageSize());
                holder.bigframe_download.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ApplicationContext.getContext(),"正在准备下载",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case ApplicationModel.SmallFrame:
                holder.smallframe_title.setText(model.getTitle());
                holder.smallframe_icon.setImageURI(Uri.parse(model.getIcon()));
                holder.smallframe_package_size.setText(model.getPackageSize());
                holder.smallframe_download.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ApplicationContext.getContext(),"正在准备下载",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(!TextUtils.isEmpty(modelList.get(position).getBinner())){
            modelList.get(position).setItemType(ApplicationModel.BigFrame);
        }else {
            modelList.get(position).setItemType(ApplicationModel.SmallFrame);
        }
        return modelList.get(position).getItemType();
    }

}
class MyViewHolder extends RecyclerView.ViewHolder{

    @Nullable
    @Bind(R.id.big_binner)
    SimpleDraweeView binner;

    @Nullable
    @Bind(R.id.bigframe_icon)
    SimpleDraweeView bigframe_small_icon;

    @Nullable
    @Bind(R.id.bigframe_title)
    TextView bigframe_title;

    @Nullable
    @Bind(R.id.bigframe_package_size)
    TextView bigframe_package_size;

    @Nullable
    @Bind(R.id.bigframe_download)
    Button bigframe_download;

    @Nullable
    @Bind(R.id.smallframe_icon)
    SimpleDraweeView smallframe_icon;

    @Nullable
    @Bind(R.id.smallframe_title)
    TextView smallframe_title;

    @Nullable
    @Bind(R.id.smallframe_package_size)
    TextView smallframe_package_size;

    @Nullable
    @Bind(R.id.smallframe_download)
    Button smallframe_download;


    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}

