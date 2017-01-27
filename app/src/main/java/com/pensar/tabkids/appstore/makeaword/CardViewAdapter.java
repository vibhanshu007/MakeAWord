package com.pensar.tabkids.appstore.makeaword;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by root on 3/1/17.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder>  {
    public Context mContext;
    private List<CardViewContent> contentList;
    private final List<Integer> selectorList = new ArrayList<Integer>();
    private int selectedPosition;




    public CardViewAdapter(Context mContext, List<CardViewContent> contentList) {
        this.mContext = mContext;
        this.contentList = contentList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(this,mContext,itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        CardViewContent cardViewContent = contentList.get(position);
        holder.imageName.setText(cardViewContent.getImageName());
        Log.e("bitmap", "" + CommonUtil.getDataFromAsserts(mContext, cardViewContent.getImageName()));
        holder.image.setImageBitmap(CommonUtil.getDataFromAsserts(mContext, cardViewContent.getImageName() + ".png"));
        holder.itemView.setSelected(selectedPosition == position);

        if (!((MainActivity) mContext).is_in_actionMode) {
            holder.checkBox.setVisibility(View.GONE);
        } else {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(false);
        }

/*

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
*/

    }

    public int getItemCount() {
        return contentList.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener{

        public TextView imageName;
        public ImageView image;
        public CheckBox checkBox;
          CardView cardView;
          Context context;
          CardViewAdapter cardViewAdapter;
        MainActivity mainActivity;

        public MyViewHolder(CardViewAdapter cardViewAdapter,Context context,View itemView) {
            super(itemView);
            this.context=context;
            this.cardViewAdapter=cardViewAdapter;
            imageName = (TextView) itemView.findViewById(R.id.card_text);
            image = (ImageView) itemView.findViewById(R.id.card_image);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_2);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cardView.setOnLongClickListener(this);
            cardView.setOnClickListener(this);
            //Log.e("wordLetters",""+wordLetters);
        }

        @Override
        public boolean onLongClick(View view) {
            Log.e("Long click is working","#######");
            ((MainActivity)context).toolbar.getMenu().clear();

            ((MainActivity)context).toolbar.inflateMenu(R.menu.toolbar_layout);
            ((MainActivity)context).counterTextView.setVisibility(View.VISIBLE);
            ((MainActivity)context).toolbar.setTitle("0 Selected Item");
            ((MainActivity)context).is_in_actionMode=true;
            cardViewAdapter.notifyDataSetChanged();
            ((MainActivity)context).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            return true;
        }

        @Override
        public void onClick(View view) {
            Log.e("POSITION","POSITION"+getAdapterPosition());
            ((MainActivity)context).prepareSelection(view,getAdapterPosition());
        }
    }
    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }


}
