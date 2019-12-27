package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

class person {
    private String name;
    private String number;
}
public class Content extends Fragment {
    private Button plus;
    private ListView m_oListView=null;
    List name = new ArrayList();
    List number = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_content);
        name.add("김형섭");
        name.add("남유진");
        number.add("010-2711-9155");
        number.add("010-6555-9145");

        Intent intent =getIntent();
        String str1 =intent.getStringExtra("fn");
        String str3 =intent.getStringExtra("pn");
        if (str1!=null) {
            name.add(str1);
            number.add(str3);
        }
        ArrayList<ItemData> oData = new ArrayList<>();


        int len=name.size();
        for (int i=0; i<len; i++) {
            ItemData oItem = new ItemData();
            oItem.strTitle = name.get(i).toString();
            oItem.strDate = number.get(i).toString();
            oData.add(oItem);
        }


// ListView, Adapter 생성 및 연결 ------------------------
        m_oListView = (ListView)findViewById(R.id.klist);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);
        oAdapter.notifyDataSetChanged();

        //ArrayList<String> data=new ArrayList<String>();
        //ArrayAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        //ListView klist = (ListView) findViewById(R.id.klist) ;
        //klist.setAdapter(adapter) ;


        plus=findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Content.this, sub.class);
                startActivity(intent);
            }

        });

    public Content() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

}
