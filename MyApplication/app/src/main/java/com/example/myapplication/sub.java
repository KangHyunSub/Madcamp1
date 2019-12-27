package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class sub extends AppCompatActivity {
    private Button btn_move;
    private EditText first_name;
    private EditText phone_number;
    private String str1;
    private String str3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_content_sub);
        first_name=findViewById(R.id.first_name);
        phone_number=findViewById(R.id.phone_number);

        btn_move=findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                str1=first_name.getText().toString();
                str3=phone_number.getText().toString();
                Intent intent = new Intent(sub.this, MainActivity.class);
                intent.putExtra("fn",str1);
                intent.putExtra("pn",str3);
                startActivity(intent);

            }

        });

    }
}
