package com.iteso.vizkar_v1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class activityLoginScreen extends AppCompatActivity {

    Button LogIn;
    com.google.android.gms.common.SignInButton gLogin;
    TextView Nuevo;
    EditText Email, Password;
    ImageView Logo, PassLogo, UserLogo;
    private static int RC_SIGN_IN = 100;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser = null;
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
        gLogin =  findViewById(R.id.sign_in_button);
        LogIn = findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        Email = findViewById(R.id.username);
        Password = findViewById(R.id.password);

        Glide.with(this).load("https://thumbs.gfycat.com/DearDescriptiveBlacklemur-small.gif").into(Logo);

        if (currentUser != null) {
            updateUI(currentUser);
        }
        gLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentUser != null) {
                    updateUI(currentUser);
                }
                else{
                  startSignInIntent();
                }
            }
        });


        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String email = Email.getText().toString();
           String pass = Password.getText().toString();
                if (email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(view.getContext(), "Email o Password vacio.", Toast.LENGTH_SHORT).show();
                } else {
                        Register(email, pass);
                }
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
    private void startSignInIntent() {
        try {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
        } catch (Exception e){
            Toast.makeText(activityLoginScreen.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(FirebaseUser account) {
        Intent intent = new Intent( this, activityMain.class);
        startActivity(intent);
        finish();
    }

    public void Register(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);
            } else {
                Toast.makeText(activityLoginScreen.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
            }

        }
    });
    }


}
