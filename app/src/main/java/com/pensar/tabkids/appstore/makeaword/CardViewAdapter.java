package com.pensar.tabkids.appstore.makeaword;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/1/17.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<CardViewContent> contentList;
    private final List<Integer> selectorList = new ArrayList<Integer>();
    private int selectedPosition ;

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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        CardViewContent cardViewContent = contentList.get(position);
        holder.imageName.setText(cardViewContent.getImageName());
        Log.e("bitmap", "" + CommonUtil.getDataFromAsserts(mContext, cardViewContent.getImageName()));
        holder.image.setImageBitmap(CommonUtil.getDataFromAsserts(mContext, cardViewContent.getImageName() + ".png"));
        holder.itemView.setSelected(selectedPosition == position);



        if (!selectorList.contains(position)) {
            // view not selected
            holder.itemView.setBackgroundColor(Color.WHITE);
        } else{
            // view is selected
            holder.itemView.setBackgroundResource(R.color.hilight);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notifyItemChanged(position);

                selectedPosition =getSelectedPosition();
                view.setBackgroundResource(R.drawable.selector);
                notifyItemChanged(position);


                view.setBackgroundColor(Color.CYAN);

                // (*1)
                // forcing single selection here
                if (selectorList.isEmpty()){
                    selectorList.add(position);
                }else {
                    int oldSelected = selectorList.get(0);
                    selectorList.clear();

                    selectorList.add(position);

                    // we do not notify that an item has been selected
                    // because that work is done here.  we instead send
                    // notifications for items to be deselected
                    notifyItemChanged(oldSelected);
                    //notifyItemInserted(position);
                }
                Log.e("selected Value","*************"+selectorList.toString());
            }
        });


    }

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

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
}
