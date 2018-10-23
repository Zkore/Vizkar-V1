package com.iteso.vizkar_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class activitySignUpScreen extends AppCompatActivity {
    Button SignUp;
    TextView Atras;
    ImageView Logo, PassLogo, UserLogo, MailLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        Logo = findViewById(R.id.vizkarLogo);
        PassLogo = findViewById(R.id.passwordLogo);
        UserLogo = findViewById(R.id.userLogo);
        PassLogo.setImageResource(R.drawable.logo_lock);
        UserLogo.setImageResource(R.drawable.logo_user);
        MailLogo = findViewById(R.id.emailLogo);
        MailLogo.setImageResource(R.drawable.logo_mail);
        Atras = findViewById(R.id.lblAtras);

        Glide.with(this).load("https://thumbs.gfycat.com/DearDescriptiveBlacklemur-small.gif").into(Logo);
        SignUp = findViewById(R.id.login);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( view.getContext(), activityMain.class);
                startActivity(intent);
                finish();
            }
        });
        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( view.getContext(), activityLoginScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
