package com.example.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {

    EditText etemail;
    EditText etpassword;
    Button btnlog;
    ProgressBar prg;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        currentUser=null;
        if(currentUser != null){
            startActivity(new Intent(loginActivity.this, WelcomeActivity.class));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth=FirebaseAuth.getInstance();
        etemail=findViewById(R.id.email);
        etpassword=findViewById(R.id.password);
        btnlog=findViewById(R.id.btnlog);
        prg=findViewById(R.id.pgbarlog);


        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prg.setVisibility(View.VISIBLE);
                String email,password;
                email=String.valueOf(etemail.getText());
                password=String.valueOf(etpassword.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(loginActivity.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(loginActivity.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                prg.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(loginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(loginActivity.this, WelcomeActivity.class));


                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(loginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });






            }
        });





    }
    public void register(View view){
        startActivity(new Intent(loginActivity.this, registerActivity.class));
    }

    public void Welcome(View view) {
        startActivity(new Intent(loginActivity.this, WelcomeActivity.class));
    }
}