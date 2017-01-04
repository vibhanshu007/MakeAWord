package com.pensar.tabkids.appstore.makeaword;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 3/1/17.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<CardViewContent> contentList;

    public CardViewAdapter(Context mContext, List<CardViewContent> contentList){
        this.mContext= mContext;
        this.contentList=contentList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardViewContent cardViewContent= contentList.get(position);
        holder.imageName.setText(cardViewContent.getImageName());
        holder.image.setImageBitmap(CommonUtil.getDataFromAsserts(mContext,cardViewContent.getImageName()));

    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView imageName;
        public ImageView image;


        public MyViewHolder(View itemView) {
            super(itemView);
            imageName = (TextView) itemView.findViewById(R.id.card_text);
            image = (ImageView) itemView.findViewById(R.id.card_image);


        }
    }
}
