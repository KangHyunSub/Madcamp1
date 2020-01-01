package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public class MainActivity extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Cell> cells = prepareData();
        ImageAdapter adapter = new ImageAdapter(getApplicationContext(), cells);
        recyclerView.setAdapter(adapter);
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