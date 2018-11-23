package com.iteso.vizkar_v1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class activitySignUpScreen extends AppCompatActivity {
    Button SignUp;
    TextView Atras;
    ImageView Logo, PassLogo, UserLogo, MailLogo;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    com.google.android.gms.common.SignInButton gLogin;
    private static int RC_SIGN_IN = 100;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        Logo = findViewById(R.id.vizkarLogo);
        PassLogo = findViewById(R.id.passwordLogo);
        UserLogo = findViewById(R.id.userLogo);
        PassLogo.setImageResource(R.drawable.logo_lock);
        UserLogo.setImageResource(R.drawable.logo_user);
        MailLogo = findViewById(R.id.emailLogo);
        MailLogo.setImageResource(R.drawable.logo_mail);
        Atras = findViewById(R.id.lblAtras);
        gLogin =  findViewById(R.id.sign_in_button);

        if (currentUser != null) {
        }
        else{
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken("415423395842-rfjkja68r19cki758uscnvbrj94cmijg.apps.googleusercontent.com")
                    .requestEmail()
                    .build();
            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        }
        Glide.with(this).load("https://thumbs.gfycat.com/DearDescriptiveBlacklemur-small.gif").into(Logo);
        SignUp = findViewById(R.id.login);
        gLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (currentUser != null) {
                    Toast.makeText(view.getContext(), "Ya te has registrado con tu usuario de google.", Toast.LENGTH_SHORT).show();
                }
                else{
                    startSignInIntent();
                }

            }
        });
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Toast.makeText(this, "Error al registrarse con Google.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            currentUser = mAuth.getCurrentUser();
                            updateUI(currentUser);
                        } else {
                            Toast.makeText(getApplicationContext(), "error en login con google..", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private void startSignInIntent() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    private void updateUI(FirebaseUser account) {
        Intent intent = new Intent( this, activityMain.class);
        startActivity(intent);
        finish();
    }
}
