package com.example.veny.venyamiliafitri_1202150243_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Veny on 2/23/2018.
 */

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>{
    private GradientDrawable mGradientDrawable;
    private ArrayList<Drink> mDrinksData;
    private Context mContext;

    DrinksAdapter(Context context, ArrayList<Drink> drinksData) {
        this.mDrinksData = drinksData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.ades);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public DrinksAdapter.DrinksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrinksViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(DrinksAdapter.DrinksViewHolder holder, int position) {
        //Get the current sport
        Drink currentDrink = mDrinksData.get(position);

        //Bind the data to the views
        holder.bindTo(currentDrink);
    }

    @Override
    public int getItemCount() {
        return mDrinksData.size();
    }

    static class DrinksViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mKeteranganText;
        private ImageView mDrinksImage;
        private Context mContext;
        private Drink mCurrentDrink;
        private GradientDrawable mGradientDrawable;
        private TextView mDetailDrink;

        DrinksViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Inisialisasi views
            mTitleText = (TextView)itemView.findViewById(R.id.merk);
            mKeteranganText = (TextView)itemView.findViewById(R.id.keterangan);
            mDrinksImage = (ImageView)itemView.findViewById(R.id.drinksImage);
            mDetailDrink = (TextView)itemView.findViewById(R.id.detailDrink);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set OnClickListener pada setiap view
            itemView.setOnClickListener(this);
        }

        void bindTo(Drink currentDrink){
            //Menempatkan textviews dengan data
            mTitleText.setText(currentDrink.getTitle());
            mKeteranganText.setText(currentDrink.getInfo());
            mDetailDrink.setText(currentDrink.getDetail());

            //Melakukan get current drink
            mCurrentDrink = currentDrink;



            //Mengisi images ke ImageView menggunakan Glide library
            Glide.with(mContext).load(currentDrink.
                    getImageResource()).placeholder(mGradientDrawable).into(mDrinksImage);
        }

        @Override
        public void onClick(View view) {

            //Setting detail intent
            Intent detailIntent = Drink.starter(mContext, mCurrentDrink.getTitle(),
                    mCurrentDrink.getImageResource(),mCurrentDrink.getDetail());


            //Memulai detail activity
            mContext.startActivity(detailIntent);
        }
    }
}
