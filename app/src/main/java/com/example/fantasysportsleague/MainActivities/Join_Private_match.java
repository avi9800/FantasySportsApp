package com.example.fantasysportsleague.MainActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fantasysportsleague.MainActivities.Adapters.joined_match_adapter;
import com.example.fantasysportsleague.R;

import java.util.ArrayList;
import java.util.List;

public class Join_Private_match extends AppCompatActivity{

    Button join_private_match;
    TextView my_username;
    EditText joining_code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_private_match);

        join_private_match=findViewById(R.id.join_button);
        my_username=findViewById(R.id.joining_my_name);
        joining_code=findViewById(R.id.code_for_joining);



        join_with_code();
    }

    private void join_with_code() {
        my_username.setText(getSharedPreferences("PREFERENCE1", MODE_PRIVATE)
                .getString("name","Not present"));

        String code=joining_code.getText().toString().trim();
        joining_code.setText("123456");
        join_private_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Join_Private_match.this,joined_match.class);
                startActivity(i);
            }
        });
    }


}