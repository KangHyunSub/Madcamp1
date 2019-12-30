package com.example.basic;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Else extends Fragment {

    int i = 0;
    public final Integer images_ids[] = {
            R.drawable.water_1, R.drawable.water_2,
            R.drawable.water_3, R.drawable.water_4,
            R.drawable.water_5, R.drawable.water_6,
            R.drawable.water_7, R.drawable.water_8
    };

    public Else() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View waterView = inflater.inflate(R.layout.fragment_else, container, false);
        Button button = (Button) waterView.findViewById(R.id.button);
        final ImageView imageView = (ImageView) waterView.findViewById(R.id.imageView);
        final TextView textView = (TextView) waterView.findViewById(R.id.textView);

        //public int i = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i += 1;

                if (i >= 8) {
                    Toast toast = Toast.makeText(getActivity(), "Congratulations! You drank 8 cups of Water!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    double percentage = i / 8 * 100;
                    //String percentageString = Double.toString(percentage);
                    textView.setText(String.format("%.0f", percentage) + " %");
                    //textView.setText(percentageString);
                } else {
                    imageView.setImageResource(images_ids[i]);
                    double percentage = i / 8.0 * 100;
                    textView.setText(String.format("%.0f", percentage) + " %");
                }
            }
        });

        return waterView;
    }

}
