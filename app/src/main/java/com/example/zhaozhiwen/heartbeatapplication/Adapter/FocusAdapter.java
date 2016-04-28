package com.example.zhaozhiwen.heartbeatapplication.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhiwen.heartbeatapplication.MainImage;
import com.example.zhaozhiwen.heartbeatapplication.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by zhaozhiwen on 2016/4/25.
 */
public class FocusAdapter extends RecyclerView.Adapter<FocusViewHolder> {

    private List<MainImage> imageList;
    private Context mContext;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener=listener;
    }


    public FocusAdapter(List<MainImage> data,Context mContext) {
        super();
        imageList=data;
        this.mContext=mContext;
    }

    @Override
    public FocusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.item_focusfragment,parent,false);
        return new FocusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FocusViewHolder holder, final int position) {
        MainImage image=imageList.get(position);
        holder.imageView.setImageURI(Uri.parse(image.getImageView()));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(holder.imageView,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }


}

  class FocusViewHolder extends RecyclerView.ViewHolder{

      @Bind(R.id.focus_image)
      SimpleDraweeView imageView;

    public FocusViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
