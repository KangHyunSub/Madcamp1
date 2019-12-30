package com.example.basic;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Else extends Fragment {

    public final Integer images_ids[] = {
            R.drawable.water_1, R.drawable.water_2,
            R.drawable.water_3, R.drawable.water_4,
            R.drawable.water_5, R.drawable.water_6,
            R.drawable.water_7, R.drawable.water_8
    };

    public Else() {
        // Required empty public constructor
    }

    int index = 0;

    SharedPreferences a;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View waterView = inflater.inflate(R.layout.fragment_else, container, false);
        Button button = (Button) waterView.findViewById(R.id.button);


        a = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        int i = a.getInt("i", 0);

        index = i;

        final ImageView imageView = (ImageView) waterView.findViewById(R.id.imageView);
        final TextView textView = (TextView) waterView.findViewById(R.id.textView);
        imageView.setImageResource(images_ids[index]);
        double percentage = index / 8.0 * 100;
        textView.setText(String.format("%.0f", percentage) + " %");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    double percentage = index / 8 * 100;
                    //String percentageString = Double.toString(percentage);
                    textView.setText(String.format("%.0f", percentage) + " %");
                    //textView.setText(percentageString);

                } else {
                    imageView.setImageResource(images_ids[index]);
                    double percentage = index / 8.0 * 100;
                    textView.setText(String.format("%.0f", percentage) + " %");
                }
            }
        });

        return waterView;
    }

}
