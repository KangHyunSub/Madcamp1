package com.example.basic;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class Else extends Fragment {





    public final Integer images_ids[] = {
            R.drawable.water_0,
            R.drawable.water_1, R.drawable.water_2,
            R.drawable.water_3, R.drawable.water_4,
            R.drawable.water_5, R.drawable.water_6,
            R.drawable.water_7, R.drawable.water_8
    };

    public Else() {
        // Required empty public constructor
    }

    int index = 0;
    int k=0;
    Thread thread;
    boolean isThread=false;

    SharedPreferences a;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View waterView = inflater.inflate(R.layout.fragment_else, container, false);
        Button button = (Button) waterView.findViewById(R.id.button);


        a = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        int i = a.getInt("i", 0);

        index = i;



        final ImageView imageView = (ImageView) waterView.findViewById(R.id.imageView);
        final TextView textView = (TextView) waterView.findViewById(R.id.textView);
        if (index >=8) {
            imageView.setImageResource(images_ids[8]);
            double percentage = 8.0 / 8.0 * 100;
            textView.setText(String.format("%.0f", percentage) + " %");
        } else {
            imageView.setImageResource(images_ids[index]);
            double percentage = index / 8.0 * 100;
            textView.setText(String.format("%.0f", percentage) + " %");

        }

//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd", Locale.getDefault());
//
//        String currentDateandTime = sdf.format(new Date());

        Timer timer = new Timer();
        // Creates a Calendar object that specifies a specific time of day
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 99);

        Date date = cal.getTime();

        TimerTask tt = new TimerTask() {
            @Override
            public void run () {
                index = 0;
                Activity myActivity=(Activity) container.getContext();
                SharedPreferences a = PreferenceManager.getDefaultSharedPreferences(myActivity);
                SharedPreferences.Editor editor = a.edit();
                editor.putInt("i", index);
                editor.apply();
            }
        };

        timer.schedule(tt, date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k=0;
                isThread=true;
                thread= new Thread(){
                    public void run(){
                        while(isThread){
                            try {
                                sleep(5000);//5000->36000
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.sendEmptyMessage(0);
                        }
                    }
                };
                thread.start();

                index += 1;

                Activity myActivity=(Activity)(view.getContext());
                SharedPreferences a = PreferenceManager.getDefaultSharedPreferences(myActivity);
                SharedPreferences.Editor editor = a.edit();
                editor.putInt("i", index);
                editor.apply();

                if (index >= 8) {
                    Toast toast = Toast.makeText(getActivity(), "Congratulations! You drank 8 cups of Water!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    double percentage = 8 / 8 * 100;
                    textView.setText(String.format("%.0f", percentage) + " %");
                    imageView.setImageResource(images_ids[8]);
                } else {
                    imageView.setImageResource(images_ids[index]);
                    double percentage = index / 8.0 * 100;
                    textView.setText(String.format("%.0f", percentage) + " %");
                }
            }
        });

        return waterView;
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            k++;
            Toast.makeText(getActivity().getApplicationContext(),"물을 안마신지" +k+"시간이 자났어요!", Toast.LENGTH_SHORT).show();
        }
    };
}
