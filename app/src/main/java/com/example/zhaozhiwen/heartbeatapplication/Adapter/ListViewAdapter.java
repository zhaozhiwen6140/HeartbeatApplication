package com.example.zhaozhiwen.heartbeatapplication.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.zhaozhiwen.heartbeatapplication.FocusItemModel;
import com.example.zhaozhiwen.heartbeatapplication.R;
import com.example.zhaozhiwen.heartbeatapplication.ToolUtil.SystemUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhaozhiwen on 2016/4/27.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<FocusItemModel> data;
    private int margin;
    private int width;
    private int height;
    private int widthChange;

    public ListViewAdapter(Context context,List<FocusItemModel> data) {
        super();
        mContext=context;
        this.data=data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position){
        return data.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FocusItemModel itemModel=data.get(position);
        ViewHolder holder;
               if(convertView==null){
                   convertView= LayoutInflater.from(mContext).inflate(R.layout.noactionbar_mainitem,parent,false);
                   holder=new ViewHolder(convertView);
                   convertView.setTag(holder);
               }else {
                   holder= (ViewHolder) convertView.getTag();
               }
                   holder.little_title1.setText(itemModel.getItemTitle());
                   holder.item_image1.setImageURI(Uri.parse(itemModel.getItemImage()));
                   holder.item_content1.setText(itemModel.getItemContent());

                   holder.little_title2.setText(itemModel.getItemTitle());
                   holder.item_image2.setImageURI(Uri.parse(itemModel.getItemImage()));
                   holder.item_content2.setText(itemModel.getItemContent());

                   margin= SystemUtil.dip2px(mContext,8);
                   width=SystemUtil.getWidth(mContext);
                   widthChange=width-margin*2;
                   height=width/2;
                   LinearLayout.LayoutParams lay=new LinearLayout.LayoutParams(widthChange,widthChange/2);
                   lay.setMargins(margin, 0, margin, 0);
                   holder.binner.setLayoutParams(lay);

                   holder.binner.setImageURI(Uri.parse(itemModel.getBinner()));
                   holder.bigframe_title.setText(itemModel.getSmallTitle());
                   holder.bigframe_small_icon.setImageURI(Uri.parse(itemModel.getSmallicon()));
                   holder.bigframe_package_size.setText(itemModel.getSmallContent());
                   holder.bigframe_download.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Toast.makeText(mContext, "正在准备下载", Toast.LENGTH_SHORT).show();
                       }
                   });
                       return convertView;

    }


    class ViewHolder{

        @Nullable
        @Bind(R.id.little_title1)
        TextView little_title1;

        @Nullable
        @Bind(R.id.little_title2)
        TextView little_title2;

        @Nullable
        @Bind(R.id.item_content1)
        TextView item_content1;

        @Nullable
        @Bind(R.id.item_content2)
        TextView item_content2;

        @Nullable
        @Bind(R.id.item_image1)
        SimpleDraweeView item_image1;

        @Nullable
        @Bind(R.id.item_image2)
        SimpleDraweeView item_image2;

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

        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }

       }
}
