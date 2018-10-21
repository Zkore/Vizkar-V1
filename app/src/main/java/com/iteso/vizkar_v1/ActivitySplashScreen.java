package com.iteso.vizkar_v1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    ProgressBar bar;
    TextView textViewBarPercentage;
    Integer progBarPercentage = 0;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bar = findViewById(R.id.progressBar);
        textViewBarPercentage = findViewById(R.id.TextView_bar);


                new Thread(new Runnable() {
                    public void run() {
                        while (progBarPercentage < 100) {
                            progBarPercentage += 10;
                            handler.post(new Runnable() {
                                public void run() {
                                    bar.setProgress(progBarPercentage);
                                    textViewBarPercentage.setText(progBarPercentage+"/"+bar.getMax());
                                }
                            });
                            try {
                                // Sleep for 200 milliseconds.
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
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
