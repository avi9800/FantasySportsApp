package com.example.fantasysportsleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fantasysportsleague.MainActivities.Join_match;
import com.mikhaellopez.circularimageview.CircularImageView;

public class Profile_maker extends AppCompatActivity {

    EditText username,password;
    CircularImageView circularImageView;
    TextView submit;
    String name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_maker);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        circularImageView=findViewById(R.id.profile_image);
        submit=findViewById(R.id.submit);

        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.BLACK);

        circularImageView.setBorderColorStart(Color.BLACK);
        circularImageView.setBorderColorEnd(Color.WHITE);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);


        circularImageView.setShadowEnable(true);

        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.WHITE);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit_data();
            }
        });
    }

    public void submit_data(){
        name=username.getText().toString().trim();
        pass=password.getText().toString().trim();

        String nam = getSharedPreferences("PREFERENCE1", MODE_PRIVATE)
                .getString("name",null);
        if(nam==null){
           getSharedPreferences("PREFERENCE1", MODE_PRIVATE).edit().putString("name",name).commit();
            getSharedPreferences("PREFERENCE2", MODE_PRIVATE).edit().putString("password",pass).commit();
            Toast.makeText(this, "Let's start playing", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Profile_maker.this, Join_match.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        else{
            final String nm=getSharedPreferences("PREFERENCE1", MODE_PRIVATE).getString("name",null);
            if(name.isEmpty()){
                username.setError("Enter the username");
            }
           else if(nm.equals(name)){
                final String password_of_user=getSharedPreferences("PREFERENCE2", MODE_PRIVATE).getString("password",null);
                if(password_of_user.equals(pass)){
                    Toast.makeText(this, "Welcome "+nm, Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Profile_maker.this, Join_match.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
                else{
                    password.setError("Enter valid password");
                    password.setText("");
                }
            }
           else{
               username.setError("Invalid username");
               username.setText("");
            }
        }
    }
}