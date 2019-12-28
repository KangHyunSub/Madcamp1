package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import static com.example.basic.R.drawable.pic_1;

public class FullScreenImageActivity extends Activity {

    public final Integer images_ids[] = {
            R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_6,
            R.drawable.pic_7, R.drawable.pic_8,
            R.drawable.pic_9, R.drawable.pic_10,
            R.drawable.pic_11, R.drawable.pic_12,
            R.drawable.pic_13, R.drawable.pic_14,
            R.drawable.pic_15, R.drawable.pic_16,
            R.drawable.pic_17, R.drawable.pic_18,
            R.drawable.pic_19, R.drawable.pic_20
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen_image);
        Integer image_id = getIntent().getIntExtra("picture", 0);


        ImageView image = (ImageView) findViewById(R.id.fullScreenimageView);

        Drawable drawable = getResources().getDrawable(images_ids[image_id]);
        image.setImageDrawable(drawable);
//        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        viewHolder.img.setImageResource(galleryList.get(i).getImg());

//        Intent callingActivityIntent = getIntent();
//        if (callingActivityIntent != null) {
        //Context context= this.getApplicationContext();
//            if (fullScreenImageView != null) {
//            }
//        }
    }
}
