package com.example.basic;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gallery extends Fragment {

    private final String images_titles[] = {
            "pic_1",
            "pic_2",
            "pic_3",
            "pic_4",
            "pic_5",
            "pic_6",
            "pic_7",
            "pic_8",
            "pic_9",
            "pic_10",
            "pic_11",
            "pic_12",
            "pic_13",
            "pic_14",
            "pic_15",
            "pic_16",
            "pic_17",
            "pic_18",
            "pic_19",
            "pic_20"
    };

    private final Integer images_ids[] = {
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
    public Gallery() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity main = (MainActivity) getActivity();
        View galleryView = inflater.inflate(R.layout.fragment_gallery, null);

        RecyclerView recyclerView = (RecyclerView) galleryView.findViewById(R.id.gallery);
//        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(main.getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Cell> cells = prepareData();
        ImageAdapter adapter = new ImageAdapter(main.getApplicationContext(), cells);
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    private ArrayList<Cell> prepareData() {
        ArrayList<Cell> theimage = new ArrayList<>();
        for (int i = 0; i < images_titles.length; i ++) {
            Cell cell = new Cell();
            cell.setImg(images_ids[i]);
            theimage.add(cell);
        }

        return theimage;
    }
}