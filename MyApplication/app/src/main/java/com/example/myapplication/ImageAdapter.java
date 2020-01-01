package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//import android.view.ViewHolder;

public class ImageAdapter extends  RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<Cell> galleryList;
    private Context context;

    public ImageAdapter(Context context, ArrayList<Cell> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ImageAdapter.ViewHolder viewHolder, int i) {
        //viewHolder.title.setText(galleryList.get(i).getTitle());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img.setImageResource(galleryList.get(i).getImg());

        //ImageView imageview = (ImageView) findViewById(R.id.imageView);

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ImageView imageview = (ImageView) view.findViewById(R.id.fullimg);
                //viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //viewHolder.img.setImageResource(R.id.fullimg);
                //viewHolder.img.set
                viewHolder.img.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                viewHolder.img.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;

                //viewHolder.img.setAdjustViewBounds(false);
                //viewHolder.img.setCropToPadding(true);
                //viewHolder.img.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        });


    }


    public int getItemCount() {
        return galleryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public ImageView img;
        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }


}
