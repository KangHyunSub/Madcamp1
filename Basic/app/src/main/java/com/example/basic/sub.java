package com.example.basic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class sub extends Fragment {
    private Button btn_move;
    private EditText first_name;
    private EditText phone_number;
    private String str1;
    private String str3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sub,
                container,
                false);
        first_name = view.findViewById(R.id.first_name);
        phone_number = view.findViewById(R.id.phone_number);

        btn_move = view.findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = first_name.getText().toString();
                str3 = phone_number.getText().toString();
                Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("fn", str1);
                intent.putExtra("pn", str3);
                startActivity(intent);

            }

        });
        return view;
    }
}
