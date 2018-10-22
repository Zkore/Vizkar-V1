package com.iteso.vizkar_v1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    ProgressBar bar;
    TextView textViewBarPercentage;
    Integer progBarPercentage = 0;
    ImageView gifLogo;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bar = findViewById(R.id.progressBar);
        textViewBarPercentage = findViewById(R.id.TextView_bar);
        gifLogo = findViewById(R.id.Image_logo);

        Glide.with(this).load("https://thumbs.gfycat.com/SeveralInfantileAfricanfisheagle-size_restricted.gif").into(gifLogo);

        new Thread(new Runnable() {
            public void run() {
                while (progBarPercentage < 100) {
                    progBarPercentage += 5;
                    handler.post(new Runnable() {
                        public void run() {
                            bar.setProgress(progBarPercentage);
                            textViewBarPercentage.setText(progBarPercentage+"/"+bar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progBarPercentage >= 99){
                        Intent intent = new Intent(ActivitySplashScreen.this, activityLoginScreen.class);
                        startActivity(intent);
                        finish();

                    }
                }
            }
        }).start();




    }



    /*
    public User loadPreferences(){
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.USER_PREFERENCES",
                        MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("NAME", null));
        user.setPsw(sharedPreferences.getString("PWD", null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED", false));
        sharedPreferences = null;
        return user;
    }

    }

    */
}
