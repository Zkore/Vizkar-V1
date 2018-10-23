package com.iteso.vizkar_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

public class activityLoginScreen extends AppCompatActivity {

    Button LogIn;
    TextView Nuevo;
    ImageView Logo, PassLogo, UserLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        Logo = findViewById(R.id.vizkarLogo);
        PassLogo = findViewById(R.id.passwordLogo);
        UserLogo = findViewById(R.id.userLogo);
        PassLogo.setImageResource(R.drawable.logo_lock);
        UserLogo.setImageResource(R.drawable.logo_user);
        Nuevo = findViewById(R.id.lblNuevo);

        Glide.with(this).load("https://thumbs.gfycat.com/DearDescriptiveBlacklemur-small.gif").into(Logo);
        LogIn = findViewById(R.id.login);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( view.getContext(), activityMain.class);
                startActivity(intent);
                finish();
            }
        });
        Nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( view.getContext(), activitySignUpScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
